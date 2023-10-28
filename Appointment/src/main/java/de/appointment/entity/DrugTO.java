package de.appointment.entity;

import de.appointment.entity.internal.Drug;

//author Lars Diekmann
public class DrugTO {
    private long drugID;
    private String name;
    private double price;

    public DrugTO(long drugID, String name, double price) {
        this.drugID = drugID;
        this.name = name;
        this.price = price;
    }

    public Drug toDrug(){
        return new Drug(this.drugID, this.name, this.price);
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
