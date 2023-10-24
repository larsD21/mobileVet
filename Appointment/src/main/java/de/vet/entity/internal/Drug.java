package de.vet.entity.internal;

import de.vet.entity.DrugTO;
import jakarta.persistence.*;

import java.io.Serializable;

//author Lars Diekmann
@Entity
@Table(name = "Drug")
public class Drug implements Serializable {
    @Id
    @SequenceGenerator(name = "DRUG", sequenceName = "DRUG", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRUG")
    @Column(name = "drugID")
    private long drugID;
    private String name;
    private double price;

    public Drug(){}

    public Drug(long drugID, String name, double price) {
        this.drugID = drugID;
        this.name = name;
        this.price = price;
    }

    public DrugTO toDrugTO(){
        return new DrugTO(this.drugID, this.name, this.price);
    }

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
