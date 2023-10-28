package de.appointment.usecase;

import de.appointment.entity.BillingTO;
import jakarta.ejb.Local;

import java.util.List;
//Author Lars Diekmann
@Local
public interface IGetBilling {
    public List<BillingTO> getBillings(String startDateStr, String endDateStr);
}
