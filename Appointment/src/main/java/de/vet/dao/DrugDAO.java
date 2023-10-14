package de.vet.dao;

import de.vet.entity.internal.Drug;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class DrugDAO extends GenericDAO<Drug>{
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
