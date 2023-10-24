package de.vet.usecase;

import de.vet.entity.PatientTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IGetPatient {
    public PatientTO getPatientByID(long ID);
}
