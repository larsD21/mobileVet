package de.vet.rest;

import de.patient.entity.OwnerTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.patient.usecase.IGetOwner;
import de.patient.usecase.IManageOwner;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

//author Lars Diekmann

@Path("owner")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OwnerResource {
    @Inject
    IManageOwner manageOwner;

    @Inject
    IGetOwner getOwner;

    @POST
    @Path("create")
    @JWTTokenNeeded(Permissions = Role.VET)
    public Response createOwner(OwnerTO owner){
        manageOwner.createOwner(owner);
        return Response.ok().build();
    }

    @GET
    @Path("getAll")
    @JWTTokenNeeded(Permissions = Role.VET)
    public List<OwnerTO> getAllOwner(){
        return getOwner.getAllOwner();
    }

}
