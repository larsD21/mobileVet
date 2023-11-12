package de.appointment.entity;

import de.appointment.entity.internal.Appointment;
import de.appointment.entity.internal.Drug;
import de.appointment.entity.internal.GOT;
import de.appointment.entity.internal.Vet;
import de.patient.usecase.implementation.GetPatient;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
public class AppointmentTO {
    private long appointmentID;
    private String date;
    private int priceVariant;
    private String picturePath;
    private String diagnose;
    private List<GOT> got;
    private long patient;
    private List<Long> usedDrugs;
    private Vet vet;

    public AppointmentTO(long appointmentID, String date, int priceVariant,String picturePath, String diagnose, List<GOT> got, long patient, List<Long> usedDrugs, Vet vet) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.priceVariant = priceVariant;
        this.picturePath = picturePath;
        this.diagnose = diagnose;
        this.got = got;
        this.patient = patient;
        this.usedDrugs = usedDrugs;
        this.vet = vet;
    }

    public Appointment toAppointment(){
        List<Drug> usedDrugs = new ArrayList<>();
        for(Long i : this.usedDrugs){
            usedDrugs.add(new Drug());
        }
        return new Appointment(this.appointmentID, this.date, this.priceVariant,this.picturePath, this.diagnose, this.got, this.patient, usedDrugs, this.vet);
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

    public int getPriceVariant() {
        return priceVariant;
    }

    public void setPriceVariant(int priceVariant) {
        this.priceVariant = priceVariant;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public List<GOT> getGotID() {
        return this.got;
    }

    public void setGotID(List<GOT> got) {
        this.got = got;
    }

    public List<Long> getUsedDrugs() {
        return usedDrugs;
    }

    public void setUsedDrugs(List<Long> usedDrugs) {
        this.usedDrugs = usedDrugs;
    }

    public long getPatient() {
        return patient;
    }

    public void setPatient(long patient) {
        this.patient = patient;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

}
