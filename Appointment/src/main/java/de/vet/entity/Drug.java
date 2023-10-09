package de.vet.entity;

import jakarta.persistence.*;

//author Lars Diekmann
@Entity
@Table(name = "Drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "drugID")
    private long drugID;
    private String name;
    private double price;

    public long getDrugID() {
        return drugID;
    }

    public void setDrugID(long drugID) {
        this.drugID = drugID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
