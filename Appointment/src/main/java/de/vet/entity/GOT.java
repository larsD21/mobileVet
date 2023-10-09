package de.vet.entity;

import jakarta.persistence.*;

//author Lars Diekmann
@Entity
@Table(name = "GOT")
public class GOT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gotID")
    private long gotID;
    private double price1;
    private double price2;

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

    private double price3;
    public GOT(){}

    public GOT(long gotID, double price1, double price2, double price3) {
        this.gotID = gotID;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }

    public GOT(double price1, double price2, double price3) {
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }


}
