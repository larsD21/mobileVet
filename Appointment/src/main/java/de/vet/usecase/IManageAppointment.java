package de.vet.usecase;

import de.vet.entity.AppointmentTO;
import jakarta.ejb.Local;

//author Lars Diekmann

@Local
public interface IManageAppointment {
    public void createAppointment(AppointmentTO appointment);
    public void editAppointment(AppointmentTO appointment);
}
