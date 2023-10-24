package de.vet.rest;

import de.vet.entity.DrugTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.vet.usecase.IGetDrug;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


//author Lars Diekmann

@Path("drug")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DrugResource {
    @Inject
    IGetDrug getDrug;

    @GET
    @Path("getAll")
    @JWTTokenNeeded(Permissions = Role.VET)
    public List<DrugTO> getAllDrug(){
        return getDrug.getAllDrugs();
    }

    @GET
    @Path("get/{id}")
    @JWTTokenNeeded(Permissions = Role.VET)
    public DrugTO getDrug(@PathParam("id") long ID){
        return getDrug.getDrugByID(ID);
    }
}
