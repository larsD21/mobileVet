package de.patient.usecase.implementation;

import de.patient.dao.OwnerDAO;
import de.patient.entity.OwnerTO;
import de.patient.usecase.IManageOwner;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

//author Lars Diekmann
@Stateless
public class ManageOwner implements IManageOwner {
    @Inject
    OwnerDAO ownerDAO;
    @Override
    public void createOwner(OwnerTO owner) {
        ownerDAO.createOwner(owner.toOwner());
    }
}
