package de.patients.dao;

import de.patients.entity.internal.Patient;
import jakarta.ejb.Stateless;

import java.util.List;

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

    public List<Patient> getAllPatient(){
        return super.findAll();
    }
}
