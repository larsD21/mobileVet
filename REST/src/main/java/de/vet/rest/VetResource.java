package de.vet.rest;

import de.appointment.entity.VetTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.appointment.usecase.IGetVet;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

//author Lars Diekmann

@Path("got")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VetResource {
    @Inject
    IGetVet getVet;

    @GET
    @Path("get/{id}")
    //@JWTTokenNeeded(Permissions = Role.VET)
    public VetTO getVet(@PathParam("id") long ID){
        return getVet.getVetByID(ID);
    }
}
