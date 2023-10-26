package de.patient.entity;

import de.patient.entity.internal.Owner;
import de.patient.entity.internal.Patient;

//author Lars Diekmann
public class PatientTO {
    private long patientID;
    private String species;
    private String name;
    private long identNumber;
    private Owner owner;

    public PatientTO(long patientID, String species, String name, long identNumber, Owner owner) {
        this.patientID = patientID;
        this.species = species;
        this.name = name;
        this.identNumber = identNumber;
        this.owner = owner;
    }

    public Patient toPatient(){
        return new Patient(this.patientID, this.species, this.name, this.identNumber, this.owner);
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(long identNumber) {
        this.identNumber = identNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
