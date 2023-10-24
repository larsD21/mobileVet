package de.vet.rest;

import de.vet.entity.BillingTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.vet.usecase.IGetBilling;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

//Author Lars Diekmann

@Path("billing")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {
    @Inject
    IGetBilling getBilling;

    @GET
    @Path("getBilling/{startDate}/{endDate}")
    @JWTTokenNeeded(Permissions = Role.ACCOUNTANT)
    public List<BillingTO> getAllBilling(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate){
        return getBilling.getBillings(startDate, endDate);
    }


}
