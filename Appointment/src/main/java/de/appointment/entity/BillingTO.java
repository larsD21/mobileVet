package de.appointment.entity;

import de.appointment.entity.internal.Billing;
import de.appointment.usecase.IGetAppointment;
import de.appointment.usecase.implementation.GetAppointment;

import java.util.List;

public class BillingTO {
    private long billingID;
    private long appointmentID;
    private String date;
    private String vetFirstName;
    private String vetLastName;
    private String species;
    private long patientID;
    private String diagnose;
    private List<Long> gotID;
    private double cost;
    private double tax;

    public BillingTO(long billingID, long appointmentID, String date, String vetFirstName, String vetLastName, String species, String diagnose, List<Long> gotID, double cost, double tax) {
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

    public BillingTO(long billingID, long appointmentID, String date, String vetFirstName, String vetLastName, String diagnose, List<Long> gotID, double cost, double tax, long patientID) {
        this.billingID = billingID;
        this.appointmentID = appointmentID;
        this.date = date;
        this.vetFirstName = vetFirstName;
        this.vetLastName = vetLastName;
        this.diagnose = diagnose;
        this.gotID = gotID;
        this.cost = cost;
        this.tax = tax;
        this.patientID = patientID;
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

    public List<Long> getGotID() {
        return gotID;
    }

    public void setGotID(List<Long> gotID) {
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

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }
}
