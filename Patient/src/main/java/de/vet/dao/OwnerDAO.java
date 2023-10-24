package de.vet.dao;

import de.vet.entity.internal.Owner;
import jakarta.ejb.Stateless;

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
