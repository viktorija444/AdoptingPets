package com.example.springudomljavanjezivotinja.servisi;


import com.example.springudomljavanjezivotinja.model.Zivotinje;
import com.example.springudomljavanjezivotinja.respositories.ZivotinjeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ZiotinjaServisImpl implements ZivotinjeServis{

    public final ZivotinjeRepository zivotinjeRepository;

    public ZiotinjaServisImpl(ZivotinjeRepository zivotinjeRepository) {
        this.zivotinjeRepository = zivotinjeRepository;
    }

    @Override
    public Zivotinje save(DodavanjeZivotinjaDto dodavanjeZivotinjaDto) {
        return null;
    }

    @Override
    public Set<Zivotinje> getZivotinje() {
        return null;
    }

    @Override
    public Zivotinje findById(Long l) {
        return null;
    }

    @Override
    public void deleteById(Long idToDelete) {

    }
}
