package de.vet.usecase.implementation;

import de.vet.dao.PatientDAO;
import de.vet.entity.PatientTO;
import de.vet.usecase.IManagePatient;
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
