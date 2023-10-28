package de.patient.usecase;

import de.patient.entity.OwnerTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IManageOwner {
    public void createOwner(OwnerTO owner);
}
