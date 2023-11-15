package de.patient.dao;

import de.patient.entity.internal.Owner;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;

import java.util.List;

@Stateless
public class OwnerDAO extends GenericDAO<Owner> {
    public OwnerDAO() {
        super(Owner.class);
    }

    public List<Owner> getAllOwner(){
        return super.findAll();
    }

    public void createOwner(Owner owner){
        super.save(owner);
    }
}
