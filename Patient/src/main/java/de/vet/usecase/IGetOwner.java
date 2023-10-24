package de.vet.usecase;

import de.vet.entity.OwnerTO;
import jakarta.ejb.Local;

import java.util.List;
//author Lars Diekmann
@Local
public interface IGetOwner {
    public List<OwnerTO> getAllOwner();
}
