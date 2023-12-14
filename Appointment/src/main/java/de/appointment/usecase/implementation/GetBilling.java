package de.appointment.usecase.implementation;

import de.appointment.dao.AppointmentDAO;
import de.appointment.entity.AppointmentTO;
import de.appointment.entity.BillingTO;
import de.appointment.entity.internal.Appointment;
import de.appointment.entity.internal.Billing;
import de.appointment.usecase.IGetBilling;
import de.appointment.dao.BillingDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//author Lars Diekmann
@Stateless
public class GetBilling implements IGetBilling {
    @Inject
    BillingDAO billingDAO;

    @Inject
    AppointmentDAO appointmentDAO;

    @Override
    public List<BillingTO> getBillings(String startDateStr, String endDateStr) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.BASIC_ISO_DATE;

        LocalDate startDate = LocalDate.parse(startDateStr, inputFormatter);
        LocalDate endDate = LocalDate.parse(endDateStr, inputFormatter);

        List<Billing> billings = billingDAO.getAllBilling();
        billings.sort(Comparator.comparing(billing -> billing.getAppointment().getAppointmentID()));

        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        List<Billing> createdBillings = new ArrayList<>();

        for (Appointment appointment : appointments) {
            LocalDate appointmentDate = LocalDate.parse(appointment.getAppointmentDate(), inputFormatter);
            boolean isWithinRange = !appointmentDate.isBefore(startDate) && !appointmentDate.isAfter(endDate);

            if (!isAppointmentInBillings(appointment, billings) && isWithinRange) {
                createdBillings.add(new Billing(appointment));
            }
        }

        List<BillingTO> newBillings = new ArrayList<>();

        createdBillings.forEach(billing -> {
            billingDAO.saveBilling(billing);
            BillingTO billingTO = billing.toBillingTO();
            newBillings.add(billingTO);
        });

        return newBillings;
    }

    @Override
    public List<AppointmentTO> getUnbilledAppointments() {
        List<Appointment> allAppointments = appointmentDAO.getAllAppointments();
        List<AppointmentTO> unbilledAppointments = new ArrayList<>();
        List<Billing> billings = billingDAO.getAllBilling();

        billings.sort(Comparator.comparing(billing -> billing.getAppointment().getAppointmentID()));

        for (Appointment i : allAppointments){
            if (!isAppointmentInBillings(i, billings)){
                unbilledAppointments.add(i.toAppointmentTO());
            }
        }
        return unbilledAppointments;
    }

    private boolean isAppointmentInBillings(Appointment appointment, List<Billing> billings) {
        int left = 0;
        int right = billings.size() - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            Billing midBilling = billings.get(mid);
            long midAppointmentID = midBilling.getAppointment().getAppointmentID();
            long appointmentID = appointment.getAppointmentID();

            if (midAppointmentID == appointmentID) {
                return true;
            } else if (midAppointmentID < appointmentID) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }


}
