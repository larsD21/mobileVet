package de.appointment.usecase.implementation;

import de.appointment.dao.GOTDAO;
import de.appointment.entity.GOTTO;
import de.appointment.entity.internal.GOT;
import de.appointment.usecase.IGetGOT;
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

    @Override
    public GOTTO getGOT(long id) {
        return gotdao.getGOT(id).toGOTTO();
    }


}
