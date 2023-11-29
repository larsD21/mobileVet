package de.patients.usecase;

import de.patients.entity.OwnerTO;
import jakarta.ejb.Local;

import java.util.List;
//author Lars Diekmann
@Local
public interface IGetOwner {
    public List<OwnerTO> getAllOwner();
    public OwnerTO getOwner(long id);
}
