package de.appointment.usecase.implementation;

import de.appointment.dao.AppointmentDAO;
import de.appointment.entity.AppointmentTO;
import de.appointment.entity.internal.Appointment;
import de.appointment.usecase.IGetAppointment;
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

    @Override
    public AppointmentTO getAppointmentByID(long ID) {
        return appointmentDAO.getAppointmentByID(ID).toAppointmentTO();
    }
}
