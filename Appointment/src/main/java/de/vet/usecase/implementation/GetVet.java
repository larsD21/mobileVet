package de.vet.usecase.implementation;

import de.vet.dao.VetDAO;
import de.vet.entity.VetTO;
import de.vet.usecase.IGetVet;
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
