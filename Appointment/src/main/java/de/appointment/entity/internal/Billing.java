package de.appointment.entity.internal;

import de.appointment.entity.BillingTO;
import de.patients.usecase.IGetPatient;
import de.patients.usecase.implementation.GetPatient;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Billing")
public class Billing implements Serializable {
    @Id
    @SequenceGenerator(name = "BILLING", sequenceName = "BILLING", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILLING")
    @Column(name = "billingID")
    private long billingID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment")
    private Appointment appointment;

    private double cost;
    private double tax;

    public Billing(){}

    public Billing(Appointment appointment) {
        this.appointment = appointment;
        this.cost = 0;
        this.tax = 0;
        for(int i = 0; i<appointment.getGot().size(); i++){
            int variant = appointment.getPriceVariant().get(i);
            switch(variant){
                case 1:
                    this.cost += appointment.getGot().get(i).getPrice1();
                    break;
                case 2:
                    this.cost += appointment.getGot().get(i).getPrice2();
                    break;
                case 3:
                    this.cost += appointment.getGot().get(i).getPrice3();
                    break;
                default:
                    break;
            }
        }

        this.tax = cost*0.19;

        for(int i = 0; i<appointment.getUsedDrugs().size(); i++){
            this.cost += appointment.getUsedDrugs().get(i).getPrice();
            this.tax += appointment.getUsedDrugs().get(i).getPrice() * 0.19;
        }

    }

    public BillingTO toBillingTO(){
        IGetPatient getPatient = new GetPatient();
        List<Long> gotIDs = new ArrayList<>();
        for(GOT got : this.appointment.getGot()){
            gotIDs.add(got.getGotID());
        }
        return new BillingTO(this.billingID,
                this.appointment.getAppointmentID(),
                this.appointment.getAppointmentDate(),
                this.appointment.getVet().getFirstName(),
                this.appointment.getVet().getLastName(),
                this.appointment.getDiagnose(),
                gotIDs,
                this.cost,
                this.tax,
                this.appointment.getPatient());
    }

    public long getBillingID() {
        return billingID;
    }

    public void setBillingID(long billingID) {
        this.billingID = billingID;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
