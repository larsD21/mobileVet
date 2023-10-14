package de.vet.usecase.implementation;

import de.vet.dao.AppointmentDAO;
import de.vet.entity.AppointmentTO;
import de.vet.entity.internal.Appointment;
import de.vet.usecase.IGetAppointment;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
@Stateless
public class GetAppointment implements IGetAppointment {
    @Inject
    AppointmentDAO appointmentDAO;

    @Override
    public List<AppointmentTO> getAllAppointments() {
        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        List<AppointmentTO> appointmentTOS = new ArrayList<>();

        appointments.forEach(appointment -> {
            AppointmentTO appointmentTO = appointment.toAppointmentTO();
            appointmentTOS.add(appointmentTO);
        });

        return appointmentTOS;
    }
}
