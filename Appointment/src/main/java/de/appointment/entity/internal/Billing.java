package de.appointment.entity.internal;

import de.appointment.entity.BillingTO;
import de.patient.usecase.IGetPatient;
import de.patient.usecase.implementation.GetPatient;
import jakarta.persistence.*;

import java.io.Serializable;

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
    public Billing(Appointment appointment){
        this.appointment = appointment;
    }

    public Billing(long billingID, Appointment appointment) {
        this.billingID = billingID;
        this.appointment = appointment;
    }

    public BillingTO toBillingTO(){
        IGetPatient getPatient = new GetPatient();
        return new BillingTO(this.billingID,
                this.appointment.getAppointmentID(),
                this.appointment.getAppointmentDate(),
                this.appointment.getVet().getFirstName(),
                this.appointment.getVet().getLastName(),
                getPatient.getPatientByID(this.appointment.getPatient()).getSpecies(),
                this.appointment.getDiagnose(),
                this.appointment.getGot().getGotID(),
                this.cost,
                this.tax);
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
