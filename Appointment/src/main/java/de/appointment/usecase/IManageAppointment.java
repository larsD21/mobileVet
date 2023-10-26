package de.appointment.usecase;

import de.appointment.entity.AppointmentTO;
import jakarta.ejb.Local;

//author Lars Diekmann

@Local
public interface IManageAppointment {
    public void createAppointment(AppointmentTO appointment);
    public void editAppointment(AppointmentTO appointment);
}
