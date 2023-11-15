package de.patients.usecase;

import de.patients.entity.PatientTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IManagePatient {
    public void createPatient(PatientTO patientTO);
}
