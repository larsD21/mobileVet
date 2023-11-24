package de.appointment.entity.internal;


import de.appointment.entity.AppointmentTO;
import de.appointment.entity.DrugTO;
import de.appointment.entity.GOTTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
@Entity
@Table(name = "Appointment")
public class Appointment implements Serializable {
    @Id
    @SequenceGenerator(name = "APPOINTMENT", sequenceName = "APPOINTMENT", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPOINTMENT")
    @Column(name = "appointmentID")
    private long appointmentID;
    private String appointmentDate;
    @ElementCollection
    @CollectionTable(name="priceVariants", joinColumns = @JoinColumn(name="appointmentID"))
    private List<Integer> priceVariant;
    private String picturePath;
    private String diagnose;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Appointment_GOT",
            joinColumns = @JoinColumn(name = "appointmentID"),
            inverseJoinColumns = @JoinColumn(name = "gotID")
    )
    private List<GOT> got;

    private long patient;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Appointment_Drug",
            joinColumns = @JoinColumn(name = "appointmentID"),
            inverseJoinColumns = @JoinColumn(name = "drugID")
    )
    private List<Drug> usedDrugs;
    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "vet")
    private Vet vet;

    public Appointment(){}
    public Appointment(long appointmentID, String appointmentDate, List<Integer> priceVariant, String picturePath, String diagnose, List<GOT> got, long patient, List<Drug> usedDrugs, Vet vet){
       this.appointmentID = appointmentID;
       this.appointmentDate = appointmentDate;
        this.priceVariant = new ArrayList<>();
        if(isVariantValid(priceVariant)){
            this.priceVariant = priceVariant;

        } else{
            for(GOT i : got){
                this.priceVariant.add(1);
            }
        }
       this.picturePath = picturePath;
       this.diagnose = diagnose;
       this.got = got;
       this.patient = patient;
       this.usedDrugs = usedDrugs;
       this.vet = vet;
    }

    public Appointment(String appointmentDate, List<Integer> priceVariant, String picturePath, String diagnose, List<GOT> got, long patient, List<Drug> usedDrugs, Vet vet){
        this.appointmentDate = appointmentDate;
        this.priceVariant = new ArrayList<>();
        if(isVariantValid(priceVariant)){
            this.priceVariant = priceVariant;

        } else{
            for(GOT i : got){
                this.priceVariant.add(1);
            }
        }
        this.picturePath = picturePath;
        this.diagnose = diagnose;
        this.got = got;
        this.patient = patient;
        this.usedDrugs = usedDrugs;
        this.vet = vet;
    }

    public AppointmentTO toAppointmentTO(){
        List<DrugTO> usedDrugs = new ArrayList<>();
        List<GOTTO> got = new ArrayList<>();
        for (Drug i : this.usedDrugs){
            usedDrugs.add(i.toDrugTO());
        }

        for(GOT i : this.got){
            got.add(i.toGOTTO());
        }
        return new AppointmentTO(this.appointmentID,this.appointmentDate,this.priceVariant, this.picturePath, this.diagnose, got, this.patient ,usedDrugs, this.vet.getVetID(), this.vet.getFirstName(), this.vet.getLastName());
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
    private boolean isVariantValid(List<Integer> priceVariant){
        for(Integer i: priceVariant){
            if(i < 1 || i > 3){
                return false;
            }
        }
        return true;
    }

    public long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public List<Integer> getPriceVariant() {
        return priceVariant;
    }

    public void setPriceVariant(List<Integer> priceVariant) {
        this.priceVariant = priceVariant;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public List<GOT> getGot() {
        return got;
    }

    public void setGot(List<GOT> got) {
        this.got = got;
    }

    public List<Drug> getUsedDrugs() {
        return usedDrugs;
    }

    public void setUsedDrugs(List<Drug> usedDrugs) {
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
