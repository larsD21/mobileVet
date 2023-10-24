package de.vet.usecase;

import de.vet.entity.VetTO;
import jakarta.ejb.Local;

//Author Lars Diekmann
@Local
public interface IGetVet {
    public VetTO getVetByID(long ID);
}
