package de.appointment.usecase;

import de.appointment.entity.DrugTO;
import jakarta.ejb.Local;

import java.util.List;

//author Lars Diekmann

@Local
public interface IGetDrug {
    public DrugTO getDrugByID(long ID);

    public List<DrugTO> getAllDrugs();
}
