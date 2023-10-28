package de.patient.usecase;

import de.patient.entity.PatientTO;
import jakarta.ejb.Local;

//author Lars Diekmann
@Local
public interface IManagePatient {
    public void createPatient(PatientTO patientTO);
}
