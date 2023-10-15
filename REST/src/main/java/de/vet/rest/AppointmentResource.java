package de.vet.rest;

import de.vet.entity.AppointmentTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.vet.usecase.IGetAppointment;
import de.vet.usecase.IManageAppointment;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @POST
    @Path("create")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response createAppointment(AppointmentTO appointment){
        manageAppointment.createAppointment(appointment);
        return Response.ok().build();
    }

    @POST
    @Path("edit")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response editAppointment(AppointmentTO appointment){
        manageAppointment.editAppointment(appointment);
        return Response.ok().build();
    }

    @GET
    @Path("getAll")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public List<AppointmentTO> getAllAppointment(){
        return getAppointment.getAllAppointments();
    }
}
