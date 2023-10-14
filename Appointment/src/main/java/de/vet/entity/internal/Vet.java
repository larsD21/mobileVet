package de.vet.entity.internal;

import de.vet.entity.VetTO;
import jakarta.persistence.*;

//author Lars Diekmann
@Entity
@Table(name = "Vet")
public class Vet {
    @Id
    @SequenceGenerator(name = "VET", sequenceName = "VET", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VET")
    @Column(name = "vetID")
    private long vetID;
    private String lastName;
    private String firstName;

    public Vet(){}

    public Vet(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Vet(long vetID, String lastName, String firstName) {
        this.vetID = vetID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public VetTO toVetTO(){
        return new VetTO(this.vetID, this.lastName, this.firstName);
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
