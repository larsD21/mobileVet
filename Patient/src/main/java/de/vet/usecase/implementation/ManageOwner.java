package de.vet.usecase.implementation;

import de.vet.dao.OwnerDAO;
import de.vet.entity.OwnerTO;
import de.vet.usecase.IManageOwner;
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
