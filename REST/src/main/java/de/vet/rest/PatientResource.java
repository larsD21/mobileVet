package de.vet.rest;

import de.vet.entity.PatientTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.vet.usecase.IGetPatient;
import de.vet.usecase.IManagePatient;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @POST
    @Path("create")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response createPatient(PatientTO patientTO){
        managePatient.createPatient(patientTO);
        return Response.ok().build();
    }

    @GET
    @Path("get/{id}")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public PatientTO getPatient(@PathParam("id") long ID){
        return getPatient.getPatientByID(ID);
    }
}
