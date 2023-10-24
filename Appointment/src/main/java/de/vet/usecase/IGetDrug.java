package de.vet.usecase;

import de.vet.entity.DrugTO;
import jakarta.ejb.Local;

import java.util.List;

//author Lars Diekmann

@Local
public interface IGetDrug {
    public DrugTO getDrugByID(long ID);

    public List<DrugTO> getAllDrugs();
}
