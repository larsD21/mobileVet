package de.vet.rest;

import de.appointment.entity.BillingTO;
import de.patients.usecase.IGetPatient;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.appointment.usecase.IGetBilling;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

//Author Lars Diekmann

@Path("billing")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {
    @Inject
    IGetBilling getBilling;

    @Inject
    IGetPatient getPatient;

    @GET
    @Path("getBilling/{startDate}/{endDate}")
    //@JWTTokenNeeded(Permissions = Role.ACCOUNTANT)
    public List<BillingTO> getAllBilling(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate){
        List<BillingTO> billing = new ArrayList<>();

        getBilling.getBillings(startDate, endDate).forEach(i -> {
            i.setSpecies(getPatient.getPatientByID(i.getPatientID()).getSpecies());
            billing.add(i);
        });
        return billing;
    }


}
