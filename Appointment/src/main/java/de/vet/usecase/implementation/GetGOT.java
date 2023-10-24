package de.vet.usecase.implementation;

import de.vet.dao.GOTDAO;
import de.vet.entity.GOTTO;
import de.vet.entity.internal.GOT;
import de.vet.usecase.IGetGOT;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

//Author Lars Diekmann

@Stateless
public class GetGOT implements IGetGOT {
    @Inject
    GOTDAO gotdao;

    @Override
    public List<GOTTO> getAllGOT() {
        List<GOT> gots = gotdao.getAllGOT();
        List<GOTTO> gottos = new ArrayList<>();

        gots.forEach(got ->{
            GOTTO gotto = got.toGOTTO();
            gottos.add(gotto);
        });
        return gottos;
    }
}
