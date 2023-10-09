package de.vet.entity;

import jakarta.persistence.*;

import java.util.List;

//author Lars Diekmann
@Entity
@Table(name="Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointmentID")
    private long appointmentID;
    private String date;
    private int priceVariant;
    //private picture?
    private String diagnose;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "got", referencedColumnName = "gotID")
    private GOT got;
    //private Patient patient
    @ElementCollection
    @CollectionTable(name = "UsedDrugs", joinColumns =@JoinColumn(name = "drugID"))
    private List<Drug> usedDrugs;

    public Appointment(){}
    public Appointment(long appointmentID, String date, int priceVariant, String diagnose){
       this.appointmentID = appointmentID;
       this.date = date;
       if(isVariantValid(priceVariant)){
           this.priceVariant = priceVariant;

       } else{
           this.priceVariant = 1;
       }
       this.diagnose = diagnose;
    }

    public Appointment(String date, int priceVariant, String diagnose){
        this.date = date;
        if(isVariantValid(priceVariant)){
            this.priceVariant = priceVariant;

        } else{
            this.priceVariant = 1;
        }
        this.diagnose = diagnose;
    }

    private boolean isVariantValid(int priceVariant){
        if(priceVariant == 1 || priceVariant == 2 || priceVariant == 3){
            return true;
        }else{
            return false;
        }
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
}
