package de.vet.entity;

import de.vet.entity.internal.Vet;

//author Lars Diekmann
public class VetTO {
    private long vetID;
    private String lastName;
    private String firstName;

    public VetTO(long vetID, String lastName, String firstName) {
        this.vetID = vetID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Vet toVet(){
        return new Vet(this.vetID, this.lastName, this.firstName);
    }

    public long getVetID() {
        return vetID;
    }

    public void setVetID(long vetID) {
        this.vetID = vetID;
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
}
