package de.vet.entity;

import de.vet.utils.BinarySearchDrug;
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
    public Appointment(long appointmentID, String date, int priceVariant, String diagnose, GOT got, List<Drug> usedDrugs){
       this.appointmentID = appointmentID;
       this.date = date;
       if(isVariantValid(priceVariant)){
           this.priceVariant = priceVariant;

       } else{
           this.priceVariant = 1;
       }
       this.diagnose = diagnose;
       this.got = got;
       this.usedDrugs = usedDrugs;
    }

    public Appointment(String date, int priceVariant, String diagnose){
        this.date = date;
        if(isVariantValid(priceVariant)){
            this.priceVariant = priceVariant;

        } else{
            this.priceVariant = 1;
        }
        this.diagnose = diagnose;
        this.got = got;
        this.usedDrugs = usedDrugs;
    }

    public void addDrug(Drug drug){
        if(isDrugInList(drug)){

        }else{
            this.usedDrugs.add(drug);
        }
    }

    private boolean isDrugInList(Drug drug){
        return BinarySearchDrug.isInList(drug.getDrugID(), this.usedDrugs);
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
}
