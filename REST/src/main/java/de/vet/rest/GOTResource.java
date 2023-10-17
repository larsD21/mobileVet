package de.vet.rest;

import de.vet.entity.GOTTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.vet.usecase.IGetGOT;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

//author Lars Diekmann

@Path("got")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GOTResource {
    @Inject
    IGetGOT getGOT;

    @GET
    @Path("getAll")
    @JWTTokenNeeded(Permissions = Role.VET)
    public List<GOTTO> getAllGOT(){
        return getGOT.getAllGOT();
    }
}
