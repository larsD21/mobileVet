package de.vet.usecase.implementation;

import de.vet.dao.AppointmentDAO;
import de.vet.entity.AppointmentTO;
import de.vet.usecase.IManageAppointment;
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
