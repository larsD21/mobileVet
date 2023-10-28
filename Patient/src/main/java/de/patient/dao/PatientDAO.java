package de.patient.dao;

import de.patient.entity.internal.Patient;
import jakarta.ejb.Stateless;

//Author Lars Diekmann
@Stateless
public class PatientDAO extends GenericDAO<Patient> {
    public PatientDAO(){
        super(Patient.class);
    }

    public Patient getPatientByID(long ID){
        return super.find(ID);
    }

    public void createPatient(Patient patient){
        super.save(patient);
    }
}
