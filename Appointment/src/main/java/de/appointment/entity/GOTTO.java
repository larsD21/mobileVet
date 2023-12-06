package de.appointment.entity;

import de.appointment.entity.internal.GOT;

//author Lars Diekmann
public class GOTTO {
    private long gotID;
    private String description;
    private double price1;
    private double price2;
    private double price3;

    public GOTTO(){}

    public GOTTO(long gotID, String description,double price1, double price2, double price3) {
        this.gotID = gotID;
        this.description = description;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }

    public GOTTO(long gotID){
        this.gotID = gotID;
    }

    public GOT toGOT(){
        return new GOT(this.gotID, this.description,this.price1, this.price2, this.price3);
    }

    public long getGotID() {
        return gotID;
    }

    public void setGotID(long gotID) {
        this.gotID = gotID;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
