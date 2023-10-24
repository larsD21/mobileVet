package de.vet.usecase;

import de.vet.entity.AppointmentTO;
import jakarta.ejb.Local;

import java.util.List;
//author Lars Diekmann

@Local
public interface IGetAppointment {
    public List<AppointmentTO> getAllAppointments();

    public AppointmentTO getAppointmentByID(long ID);
}
