package de.patients.usecase;

import de.patients.entity.OwnerTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IManageOwner {
    public void createOwner(OwnerTO owner);
}
