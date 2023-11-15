package de.patients.entity;

import de.patients.entity.internal.Owner;
import de.patients.entity.internal.Patient;

//author Lars Diekmann
public class PatientTO {
    private long patientID;
    private String species;
    private String name;
    private long identNumber;
    private long ownerID;
    private String ownerLastName;
    private String ownerFirstName;
    private String ownerPlace;
    private String ownerZipCode;
    private String ownerStreet;
    private String ownerHouseNumber;
    private String ownerEmail;
    private String ownerPhoneNumber;

    public PatientTO(){}

    public PatientTO(long patientID, String species, String name, long identNumber, long ownerID, String ownerLastName, String ownerFirstName, String ownerPlace, String ownerZipCode, String ownerStreet, String ownerHouseNumber, String ownerEmail, String ownerPhoneNumber) {
        this.patientID = patientID;
        this.species = species;
        this.name = name;
        this.identNumber = identNumber;
        this.ownerID = ownerID;
        this.ownerLastName = ownerLastName;
        this.ownerFirstName = ownerFirstName;
        this.ownerPlace = ownerPlace;
        this.ownerZipCode = ownerZipCode;
        this.ownerStreet = ownerStreet;
        this.ownerHouseNumber = ownerHouseNumber;
        this.ownerEmail = ownerEmail;
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public PatientTO(String species, String name, long identNumber, long ownerID, String ownerLastName, String ownerFirstName, String ownerPlace, String ownerZipCode, String ownerStreet, String ownerHouseNumber, String ownerEmail, String ownerPhoneNumber) {
        this.species = species;
        this.name = name;
        this.identNumber = identNumber;
        this.ownerID = ownerID;
        this.ownerLastName = ownerLastName;
        this.ownerFirstName = ownerFirstName;
        this.ownerPlace = ownerPlace;
        this.ownerZipCode = ownerZipCode;
        this.ownerStreet = ownerStreet;
        this.ownerHouseNumber = ownerHouseNumber;
        this.ownerEmail = ownerEmail;
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public Patient toPatient(){
        return new Patient(this.patientID, this.species, this.name, this.identNumber, new Owner(this.ownerID,this.ownerLastName,this.ownerFirstName,this.ownerPlace,this.ownerZipCode,this.ownerStreet,this.ownerHouseNumber,this.ownerEmail,this.ownerPhoneNumber));
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

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerPlace() {
        return ownerPlace;
    }

    public void setOwnerPlace(String ownerPlace) {
        this.ownerPlace = ownerPlace;
    }

    public String getOwnerZipCode() {
        return ownerZipCode;
    }

    public void setOwnerZipCode(String ownerZipCode) {
        this.ownerZipCode = ownerZipCode;
    }

    public String getOwnerStreet() {
        return ownerStreet;
    }

    public void setOwnerStreet(String ownerStreet) {
        this.ownerStreet = ownerStreet;
    }

    public String getOwnerHouseNumber() {
        return ownerHouseNumber;
    }

    public void setOwnerHouseNumber(String ownerHouseNumber) {
        this.ownerHouseNumber = ownerHouseNumber;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }
}
