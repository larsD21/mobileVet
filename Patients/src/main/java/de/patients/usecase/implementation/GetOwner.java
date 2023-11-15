package de.patients.usecase.implementation;

import de.patients.dao.OwnerDAO;
import de.patients.entity.OwnerTO;
import de.patients.entity.internal.Owner;
import de.patients.usecase.IGetOwner;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
@Stateless
public class GetOwner implements IGetOwner {
    @Inject
    OwnerDAO ownerDAO;

    @Override
    public List<OwnerTO> getAllOwner() {
        List<Owner> allOwner = ownerDAO.getAllOwner();
        List<OwnerTO> ownerTOS = new ArrayList<>();

        allOwner.forEach(owner -> {
            OwnerTO ownerTO = owner.toOwnerTO();
            ownerTOS.add(ownerTO);
        });

        return ownerTOS;
    }
}
