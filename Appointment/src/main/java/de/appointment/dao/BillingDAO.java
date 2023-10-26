package de.appointment.dao;

import de.appointment.entity.internal.Billing;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class BillingDAO extends GenericDAO<Billing>{
    public BillingDAO(){super(Billing.class);}

    public List<Billing> getAllBilling(){
        return super.findAll();
    }

    public void saveBilling(Billing billing){
        super.save(billing);
    }

}
