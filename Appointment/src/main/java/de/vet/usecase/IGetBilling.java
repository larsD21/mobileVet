package de.vet.usecase;

import de.vet.entity.BillingTO;
import jakarta.ejb.Local;

import java.util.List;
//Author Lars Diekmann
@Local
public interface IGetBilling {
    public List<BillingTO> getBillings(String startDateStr, String endDateStr);
}
