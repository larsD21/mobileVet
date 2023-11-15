package de.patients.entity;

import de.patients.entity.internal.Owner;

public class OwnerTO {
    private long ownerID;
    private String lastName;
    private String firstName;
    private String place;
    private String zipCode;
    private String street;
    private String houseNumber;
    private String email;
    private String phoneNumber;

    public OwnerTO (){}

    public OwnerTO(long ownerID, String lastName, String firstName, String place, String zipCode, String street, String houseNumber, String email, String phoneNumber) {
        this.ownerID = ownerID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.place = place;
        this.zipCode = zipCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public OwnerTO(String lastName, String firstName, String place, String zipCode, String street, String houseNumber, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.place = place;
        this.zipCode = zipCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Owner toOwner(){
        return new Owner(this.ownerID, this.lastName, this.firstName, this.place, this.zipCode, this.street, this.houseNumber, this.email, this.phoneNumber);
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
