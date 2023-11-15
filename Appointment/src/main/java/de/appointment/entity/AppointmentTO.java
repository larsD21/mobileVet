package de.appointment.entity;

import de.appointment.entity.internal.Appointment;
import de.appointment.entity.internal.Drug;
import de.appointment.entity.internal.GOT;
import de.appointment.entity.internal.Vet;
import de.patients.usecase.implementation.GetPatient;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
public class AppointmentTO {
    private long appointmentID;
    private String date;
    private int priceVariant;
    private String picturePath;
    private String diagnose;
    private List<GOTTO> got;
    private long patient;
    private List<DrugTO> usedDrugs;
    private long vetID;
    private String lastName;
    private String firstName;


    public AppointmentTO(){}

    public AppointmentTO(long appointmentID, String date, int priceVariant,String picturePath, String diagnose, List<GOTTO> got, long patient, List<DrugTO> usedDrugs, long vetID, String firstName, String lastName) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.priceVariant = priceVariant;
        this.picturePath = picturePath;
        this.diagnose = diagnose;
        this.got = got;
        this.patient = patient;
        this.usedDrugs = usedDrugs;
        this.vetID = vetID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public AppointmentTO(String date, int priceVariant, String picturePath, String diagnose, List<GOTTO> got, long patient, List<DrugTO> usedDrugs, long vetID, String firstName, String lastName) {
        this.date = date;
        this.priceVariant = priceVariant;
        this.picturePath = picturePath;
        this.diagnose = diagnose;
        this.got = got;
        this.patient = patient;
        this.usedDrugs = usedDrugs;
        this.vetID = vetID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Appointment toAppointment(){
        List<Drug> usedDrugs = new ArrayList<>();
        List<GOT> got = new ArrayList<>();
        for(DrugTO i : this.usedDrugs){
            usedDrugs.add(i.toDrug());
        }

        for(GOTTO i : this.got){
            got.add(i.toGOT());
        }
        return new Appointment(this.appointmentID, this.date, this.priceVariant,this.picturePath, this.diagnose, got, this.patient, usedDrugs, new Vet(this.vetID, this.lastName, this.firstName));
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

    public List<GOTTO> getGot() {
        return got;
    }

    public void setGot(List<GOTTO> got) {
        this.got = got;
    }

    public long getPatient() {
        return patient;
    }

    public void setPatient(long patient) {
        this.patient = patient;
    }

    public List<DrugTO> getUsedDrugs() {
        return usedDrugs;
    }

    public void setUsedDrugs(List<DrugTO> usedDrugs) {
        this.usedDrugs = usedDrugs;
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

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

}
