package com.example.springudomljavanjezivotinja.servisi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MackeServisImpl implements  MackeServis{

    public final MackeRepository mackeRepository;

    public MackeServisImpl(MackeRepository mackeRepository) {
        this.mackeRepository = mackeRepository;
    }

    @Override
    public List<Macke> getAllMacke() {
        return null;
    }
}
