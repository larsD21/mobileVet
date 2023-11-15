package de.appointment.dao;

import de.appointment.entity.internal.Drug;
import jakarta.ejb.Stateless;

import java.util.List;

//author Lars Diekmann

@Stateless
public class DrugDAO extends GenericDAO<Drug> {
    public DrugDAO(){
        super(Drug.class);
    }

    public Drug getDrugByID(long ID){
        return super.find(ID);
    }

    public List<Drug> getAllDrugs(){
        return super.findAll();
    }
}
