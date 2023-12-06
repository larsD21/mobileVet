package de.vet.rest;

import de.appointment.entity.AppointmentTO;
import de.appointment.entity.DrugTO;
import de.appointment.entity.GOTTO;
import de.appointment.usecase.*;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Author Lars Diekmann

@Path("appointment")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    @Inject
    IManageAppointment manageAppointment;

    @Inject
    IGetAppointment getAppointment;

    @Inject
    IGetDrug getDrug;

    @Inject
    IGetGOT getGOT;

    @Inject
    IGetVet getVet;

    @POST
    @Path("create")
    //@JWTTokenNeeded(Permissions = Role.VET)
    public Response createAppointment(AppointmentTO appointment){
        if(appointment.getGotIDs().size() != appointment.getPriceVariant().size()){
            return Response.status(403, "GOT and priceVariant need the same length" ).build();
        }
        List<GOTTO> gTOs = new ArrayList<>();
        List<DrugTO> drugTOS = new ArrayList<>();
        for(int i = 0; i < appointment.getGotIDs().size(); i++){
            GOTTO g = getGOT.getGOT(appointment.getGotIDs().get(i));
            gTOs.add(g);
        }

        appointment.setGot(gTOs);

        //nullpointer exteption wahrscheinlich im schleifen kopf
//        for (int i = 0; i < appointment.getDrugIds().size(); i++){
//            DrugTO d = getDrug.getDrugByID(appointment.getDrugIds().get(i));
//            drugTOS.add(d);
//        }
//
        appointment.setUsedDrugs(drugTOS);

        appointment.setLastName(getVet.getVetByID(appointment.getVetID()).getLastName());
        appointment.setFirstName(getVet.getVetByID(appointment.getVetID()).getFirstName());
        manageAppointment.createAppointment(appointment);
        return Response.ok().build();
    }


    @POST
    @Path("edit")
    //@JWTTokenNeeded(Permissions = Role.VET)
    public Response editAppointment(AppointmentTO appointment){
        for(int i = 0; i < appointment.getGot().size(); i++){
            GOTTO g = getGOT.getGOT(appointment.getGot().get(i).getGotID());
            appointment.getGot().set(i, g);
        }

        for (int i = 0; i < appointment.getUsedDrugs().size(); i++){
            DrugTO d = getDrug.getDrugByID(appointment.getUsedDrugs().get(i).getDrugID());
            appointment.getUsedDrugs().set(i, d);
        }

        appointment.setLastName(getVet.getVetByID(appointment.getVetID()).getLastName());
        appointment.setFirstName(getVet.getVetByID(appointment.getVetID()).getFirstName());
        return Response.ok().build();
    }

    @GET
    @Path("getAll")
    //@JWTTokenNeeded(Permissions = Role.VET)
    public List<AppointmentTO> getAllAppointment(){
        return getAppointment.getAllAppointments();
    }
}
