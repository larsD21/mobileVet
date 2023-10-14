package de.vet.entity.internal;


import de.vet.entity.AppointmentTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
@Entity
@Table(name="Appointment")
public class Appointment {
    @Id
    @SequenceGenerator(name = "APPOINTMENT", sequenceName = "APPOINTMENT", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPOINTMENT")
    @Column(name = "appointmentID")
    private long appointmentID;
    private String date;
    private int priceVariant;
    //private picture?
    private String diagnose;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "got", referencedColumnName = "gotID")
    private GOT got;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "patient", referencedColumnName = "patientID")
    private Patient patient;
    @ElementCollection
    @CollectionTable(name = "UsedDrugs", joinColumns =@JoinColumn(name = "drugID"))
    private List<Drug> usedDrugs;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "vet", referencedColumnName = "vetID")
    private Vet vet;

    public Appointment(){}
    public Appointment(long appointmentID, String date, int priceVariant, String diagnose, GOT got, Patient patient, List<Drug> usedDrugs, Vet vet){
       this.appointmentID = appointmentID;
       this.date = date;
       if(isVariantValid(priceVariant)){
           this.priceVariant = priceVariant;

       } else{
           this.priceVariant = 1;
       }
       this.diagnose = diagnose;
       this.got = got;
       this.patient = patient;
       this.usedDrugs = usedDrugs;
       this.vet = vet;
    }

    public Appointment(String date, int priceVariant, String diagnose, GOT got,  Patient patient, List<Drug> usedDrugs, Vet vet){
        this.date = date;
        if(isVariantValid(priceVariant)){
            this.priceVariant = priceVariant;

        } else{
            this.priceVariant = 1;
        }
        this.diagnose = diagnose;
        this.got = got;
        this.patient = patient;
        this.usedDrugs = usedDrugs;
        this.vet = vet;
    }

    public AppointmentTO toAppointmentTO(){
        List<Long> usedDrugsID = new ArrayList<>();
        for (Drug i : this.usedDrugs){
            usedDrugsID.add(i.getDrugID());
        }
        return new AppointmentTO(this.appointmentID,this.date,this.priceVariant, this.diagnose, this.got, patient.getPatientID() ,usedDrugsID, this.vet);
    }

    public void addDrug(Drug drug){
        if(isDrugInList(drug)){
            return;
        }else{
            this.usedDrugs.add(drug);
        }
    }

    private boolean isDrugInList(Drug drug){
        for(Drug i : this.usedDrugs){
            if(i == drug){
                return true;
            }
        }
        return false;
    }
    private boolean isVariantValid(int priceVariant){
        return priceVariant == 1 || priceVariant == 2 || priceVariant == 3;
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

    public GOT getGot() {
        return got;
    }

    public void setGot(GOT got) {
        this.got = got;
    }

    public List<Drug> getUsedDrugs() {
        return usedDrugs;
    }

    public void setUsedDrugs(List<Drug> usedDrugs) {
        this.usedDrugs = usedDrugs;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
