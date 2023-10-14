package de.vet.usecase;

import de.vet.entity.GOTTO;
import jakarta.ejb.Local;

import java.util.List;
//Author Lars Diekmann

@Local
public interface IGetGOT {
    public List<GOTTO> getAllGOT();
}
