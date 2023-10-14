package de.vet.usecase.implementation;

import de.vet.dao.PatientDAO;
import de.vet.entity.PatientTO;
import de.vet.usecase.IGetPatient;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

//author Lars Diekmann
@Stateless
public class GetPatient implements IGetPatient {
    @Inject
    PatientDAO patientDAO;
    @Override
    public PatientTO getPatientByID(long ID) {
        return patientDAO.getPatientByID(ID).toPatientTO();
    }
}
