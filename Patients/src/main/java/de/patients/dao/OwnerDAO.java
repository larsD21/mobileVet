package de.patients.dao;

import de.patients.entity.internal.Owner;
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

    public Owner getOwner(long id){return super.find(id);}

    public void createOwner(Owner owner){
        super.save(owner);
    }
}
