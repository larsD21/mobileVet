package de.patient.entity.internal;

import de.patient.entity.PatientTO;
import jakarta.persistence.*;

import java.io.Serializable;

//author Lars Diekmann
@Entity
@Table(name = "Patient")
public class Patient implements Serializable {
    @Id
    @SequenceGenerator(name = "PATIENT", sequenceName = "PATIENT", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATIENT")
    @Column(name = "patientID")
    private long patientID;
    private String species;
    private String name;
    private long identNumber;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "owner", referencedColumnName = "ownerID")
    private Owner owner;

    public Patient() {}

    public Patient(long patientID, String species, String name, long identNumber, Owner owner) {
        this.patientID = patientID;
        this.species = species;
        this.name = name;
        this.identNumber = identNumber;
        this.owner = owner;
    }

    public PatientTO toPatientTO(){
        return new PatientTO(this.patientID, this.species, this.name, this.identNumber, this.owner.getOwnerID(),this.owner.getLastName(),this.owner.getFirstName(),this.owner.getPlace(),this.owner.getZipCode(),this.owner.getStreet(),this.owner.getHouseNumber(),this.owner.getEmail(),this.owner.getPhoneNumber());
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
