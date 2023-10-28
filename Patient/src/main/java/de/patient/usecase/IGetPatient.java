package de.patient.usecase;

import de.patient.entity.PatientTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IGetPatient {
    public PatientTO getPatientByID(long ID);
}
