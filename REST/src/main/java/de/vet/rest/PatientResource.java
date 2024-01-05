package de.vet.rest;

import de.patients.entity.OwnerTO;
import de.patients.entity.PatientTO;
import de.patients.usecase.IGetOwner;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.patients.usecase.IGetPatient;
import de.patients.usecase.IManagePatient;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

//author Lars Diekmann

@Path("patient")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {
    @Inject
    IManagePatient managePatient;

    @Inject
    IGetPatient getPatient;

    @Inject
    IGetOwner getOwner;

    @POST
    @Path("create")
    //@JWTTokenNeeded(Permissions = Role.VET)
    public Response createPatient(PatientTO patientTO){
        long ownerID = patientTO.getOwnerID();
        OwnerTO ownerTO = getOwner.getOwner(ownerID);
        patientTO.setOwnerFirstName(ownerTO.getFirstName());
        patientTO.setOwnerLastName(ownerTO.getLastName());
        patientTO.setOwnerHouseNumber(ownerTO.getHouseNumber());
        patientTO.setOwnerPlace(ownerTO.getPlace());
        patientTO.setOwnerZipCode(ownerTO.getZipCode());
        patientTO.setOwnerStreet(ownerTO.getStreet());
        patientTO.setOwnerPhoneNumber(ownerTO.getPhoneNumber());
        patientTO.setOwnerEmail(ownerTO.getEmail());

        managePatient.createPatient(patientTO);
        return Response.ok().build();
    }

    @GET
    @Path("get/{id}")
    @JWTTokenNeeded(Permissions = Role.VET)
    public PatientTO getPatient(@PathParam("id") long ID){
        return getPatient.getPatientByID(ID);
    }

    @GET
    @Path("getAll")
    @JWTTokenNeeded(Permissions = Role.VET)
    public List<PatientTO> getAll(){
        return getPatient.getALlPatient();
    }
}
