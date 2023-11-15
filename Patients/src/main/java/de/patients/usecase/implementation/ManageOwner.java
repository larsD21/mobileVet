package de.patients.usecase.implementation;

import de.patients.dao.OwnerDAO;
import de.patients.entity.OwnerTO;
import de.patients.usecase.IManageOwner;
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
