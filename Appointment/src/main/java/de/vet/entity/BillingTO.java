package de.vet.entity;

import de.vet.entity.internal.Billing;
import de.vet.usecase.IGetAppointment;
import de.vet.usecase.implementation.GetAppointment;

public class BillingTO {
    private long billingID;
    private long appointmentID;
    private String date;
    private String vetFirstName;
    private String vetLastName;
    private String species;
    private String diagnose;
    private long gotID;
    private double cost;
    private double tax;

    public BillingTO(long billingID, long appointmentID, String date, String vetFirstName, String vetLastName, String species, String diagnose, long gotID, double cost, double tax) {
        this.billingID = billingID;
        this.appointmentID = appointmentID;
        this.date = date;
        this.vetFirstName = vetFirstName;
        this.vetLastName = vetLastName;
        this.species = species;
        this.diagnose = diagnose;
        this.gotID = gotID;
        this.cost = cost;
        this.tax = tax;
    }

    public Billing toBilling(){
        IGetAppointment getAppointment = new GetAppointment();
        return new Billing(billingID, getAppointment.getAppointmentByID(appointmentID).toAppointment());
    }

    public long getBillingID() {
        return billingID;
    }

    public void setBillingID(long billingID) {
        this.billingID = billingID;
    }

    public long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVetFirstName() {
        return vetFirstName;
    }

    public void setVetFirstName(String vetFirstName) {
        this.vetFirstName = vetFirstName;
    }

    public String getVetLastName() {
        return vetLastName;
    }

    public void setVetLastName(String vetLastName) {
        this.vetLastName = vetLastName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public long getGotID() {
        return gotID;
    }

    public void setGotID(long gotID) {
        this.gotID = gotID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
