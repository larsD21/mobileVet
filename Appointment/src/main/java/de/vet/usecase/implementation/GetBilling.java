package de.vet.usecase.implementation;

import de.vet.dao.AppointmentDAO;
import de.vet.dao.BillingDAO;
import de.vet.entity.AppointmentTO;
import de.vet.entity.BillingTO;
import de.vet.entity.internal.Appointment;
import de.vet.entity.internal.Billing;
import de.vet.usecase.IGetBilling;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
        LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate endDate = LocalDate.parse(endDateStr, DateTimeFormatter.BASIC_ISO_DATE);

        List<Billing> billings = billingDAO.getAllBilling();
        billings.sort(Comparator.comparing(Billing::getBillingID));

        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        List<Billing> createdBillings = new ArrayList<>();

        for (Appointment appointment : appointments) {
            LocalDate appointmentDate = LocalDate.parse(appointment.getDate(), DateTimeFormatter.BASIC_ISO_DATE);
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

    private boolean isAppointmentInBillings(Appointment appointment, List<Billing> billings) {
        int left = 0;
        int right = billings.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Billing midBilling = billings.get(mid);
            long midBillingID = midBilling.getBillingID();
            long appointmentID = appointment.getAppointmentID();

            if (midBillingID == appointmentID) {
                return true;
            } else if (midBillingID < appointmentID) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }


}
