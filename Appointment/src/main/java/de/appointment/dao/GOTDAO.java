package de.appointment.dao;

import de.appointment.entity.internal.GOT;
import jakarta.ejb.Stateless;

import java.util.List;

//Author Lars Diekmann

@Stateless
public class GOTDAO extends GenericDAO<GOT> {

    public GOTDAO(){
        super(GOT.class);
    }

    public List<GOT> getAllGOT(){
        return super.findAll();
    }
}
