package de.appointment.usecase.implementation;

import de.appointment.dao.AppointmentDAO;
import de.appointment.entity.AppointmentTO;
import de.appointment.usecase.IManageAppointment;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


//author Lars Diekmann
@Stateless
public class ManageAppointment implements IManageAppointment {
    @Inject
    AppointmentDAO appointmentDAO;
    @Override
    public void createAppointment(AppointmentTO appointment) {
        appointmentDAO.createAppointment(appointment.toAppointment());
    }

    @Override
    public void editAppointment(AppointmentTO appointment) {
        appointmentDAO.editAppointment(appointment.toAppointment());
    }
}
