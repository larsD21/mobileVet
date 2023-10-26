package de.patient.usecase.implementation;

import de.patient.usecase.IManagePatient;
import de.patient.dao.PatientDAO;
import de.patient.entity.PatientTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

//author Lars Diekmann
@Stateless
public class ManagePatient implements IManagePatient {
    @Inject
    PatientDAO patientDAO;

    @Override
    public void createPatient(PatientTO patientTO) {
        patientDAO.createPatient(patientTO.toPatient());
    }
}
