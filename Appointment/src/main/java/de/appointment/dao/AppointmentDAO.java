package de.appointment.dao;

import de.appointment.entity.internal.Appointment;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AppointmentDAO extends GenericDAO<Appointment> {
    public AppointmentDAO(){
        super(Appointment.class);
    }

    public void createAppointment(Appointment appointment){
        super.update(appointment);
    }

    public void editAppointment(Appointment appointment){
        super.update(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return super.findAll();
    }

    public Appointment getAppointmentByID(long ID){
        return super.find(ID);
    }
}
