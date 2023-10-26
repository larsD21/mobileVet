package de.appointment.usecase;

import de.appointment.entity.VetTO;
import jakarta.ejb.Local;

//Author Lars Diekmann
@Local
public interface IGetVet {
    public VetTO getVetByID(long ID);
}
