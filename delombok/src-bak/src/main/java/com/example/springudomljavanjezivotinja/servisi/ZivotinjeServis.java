package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Zivotinje;

import java.util.Set;

public interface ZivotinjeServis  {

    Zivotinje save(DodavanjeZivotinjaDto dodavanjeZivotinjaDto);


    Set<Zivotinje> getZivotinje();

    Zivotinje findById(Long l);

    void deleteById(Long idToDelete);





}
