package de.appointment.dao;

import de.appointment.entity.internal.Vet;
import jakarta.ejb.Stateless;
//Author Lars Diekmann
@Stateless
public class VetDAO extends GenericDAO<Vet>{

    public VetDAO(){
        super(Vet.class);
    }

    public Vet getVetByID(long ID){
        return super.find(ID);
    }
}
