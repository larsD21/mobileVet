package de.patient.usecase.implementation;

import de.patient.dao.OwnerDAO;
import de.patient.entity.OwnerTO;
import de.patient.entity.internal.Owner;
import de.patient.usecase.IGetOwner;
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
            OwnerTO drugTO = owner.toOwnerTO();
            ownerTOS.add(drugTO);
        });

        return ownerTOS;
    }
}
