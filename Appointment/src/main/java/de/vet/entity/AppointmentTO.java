package de.vet.entity;

import de.vet.entity.internal.*;
import de.vet.usecase.implementation.GetPatient;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
public class AppointmentTO {
    private long appointmentID;
    private String date;
    private int priceVariant;
    //private picture?
    private String diagnose;
    private GOT got;
    private long patient;
    private List<Long> usedDrugs;
    private Vet vet;

    public AppointmentTO(long appointmentID, String date, int priceVariant, String diagnose, GOT got, long patient, List<Long> usedDrugs, Vet vet) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.priceVariant = priceVariant;
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
        return new Appointment(this.appointmentID, this.date, this.priceVariant, this.diagnose, this.got, new GetPatient().getPatientByID(this.patient).toPatient(), usedDrugs, this.vet);
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

    public GOT getGotID() {
        return this.got;
    }

    public void setGotID(GOT got) {
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
}
