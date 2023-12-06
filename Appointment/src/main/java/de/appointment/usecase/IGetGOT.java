package de.appointment.usecase;

import de.appointment.entity.GOTTO;
import jakarta.ejb.Local;

import java.util.List;
//Author Lars Diekmann

@Local
public interface IGetGOT {
    public List<GOTTO> getAllGOT();

    public GOTTO getGOT(long id);
}
