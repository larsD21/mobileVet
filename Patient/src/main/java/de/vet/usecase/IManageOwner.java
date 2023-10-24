package de.vet.usecase;

import de.vet.entity.OwnerTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IManageOwner {
    public void createOwner(OwnerTO owner);
}
