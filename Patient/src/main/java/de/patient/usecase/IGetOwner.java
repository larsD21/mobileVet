package de.patient.usecase;

import de.patient.entity.OwnerTO;
import jakarta.ejb.Local;

import java.util.List;
//author Lars Diekmann
@Local
public interface IGetOwner {
    public List<OwnerTO> getAllOwner();
}
