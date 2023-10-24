package de.vet.usecase.implementation;

import de.vet.dao.OwnerDAO;
import de.vet.entity.OwnerTO;
import de.vet.entity.internal.Owner;
import de.vet.usecase.IGetOwner;
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
