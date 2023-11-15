package de.patients.usecase.implementation;

import de.patients.usecase.IManagePatient;
import de.patients.dao.PatientDAO;
import de.patients.entity.PatientTO;
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
