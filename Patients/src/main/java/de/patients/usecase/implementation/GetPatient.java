package de.patients.usecase.implementation;

import de.patients.entity.internal.Patient;
import de.patients.usecase.IGetPatient;
import de.patients.dao.PatientDAO;
import de.patients.entity.PatientTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
@Stateless
public class GetPatient implements IGetPatient {
    @Inject
    PatientDAO patientDAO;
    @Override
    public PatientTO getPatientByID(long ID) {
        return patientDAO.getPatientByID(ID).toPatientTO();
    }

    @Override
    public List<PatientTO> getALlPatient() {
        List<PatientTO> patientTOS = new ArrayList<>();
        List<Patient> patients = patientDAO.getAllPatient();

        patients.forEach(patient -> {
            PatientTO pTO = patient.toPatientTO();
            patientTOS.add(pTO);
        });

        return patientTOS;
    }
}
