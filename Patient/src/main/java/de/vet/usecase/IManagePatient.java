package de.vet.usecase;

import de.vet.entity.PatientTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IManagePatient {
    public void createPatient(PatientTO patientTO);
}
