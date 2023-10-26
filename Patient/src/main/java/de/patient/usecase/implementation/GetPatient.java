package de.patient.usecase.implementation;

import de.patient.usecase.IGetPatient;
import de.patient.dao.PatientDAO;
import de.patient.entity.PatientTO;
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
