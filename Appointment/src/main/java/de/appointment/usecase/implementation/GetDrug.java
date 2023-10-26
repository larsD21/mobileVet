package de.appointment.usecase.implementation;

import de.appointment.dao.DrugDAO;
import de.appointment.entity.DrugTO;
import de.appointment.entity.internal.Drug;
import de.appointment.usecase.IGetDrug;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

//author Lars Diekmann
@Stateless
public class GetDrug implements IGetDrug {
    @Inject
    DrugDAO drugDAO;

    @Override
    public DrugTO getDrugByID(long ID) {
        return drugDAO.getDrugByID(ID).toDrugTO();
    }

    @Override
    public List<DrugTO> getAllDrugs() {
        List<Drug> drugs = drugDAO.getAllDrugs();
        List<DrugTO> drugTOs = new ArrayList<>();

        drugs.forEach(drug -> {
            DrugTO drugTO = drug.toDrugTO();
            drugTOs.add(drugTO);
        });

        return drugTOs;
    }
}
