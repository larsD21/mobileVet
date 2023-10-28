package de.appointment.usecase.implementation;

import de.appointment.dao.VetDAO;
import de.appointment.entity.VetTO;
import de.appointment.usecase.IGetVet;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

//Author Lars Diekmann

@Stateless
public class GetVet implements IGetVet {
    @Inject
    VetDAO vetDAO;

    @Override
    public VetTO getVetByID(long ID) {
        return vetDAO.getVetByID(ID).toVetTO();
    }
}
