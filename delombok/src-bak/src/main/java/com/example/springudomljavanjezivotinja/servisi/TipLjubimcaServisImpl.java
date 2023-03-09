package com.example.springudomljavanjezivotinja.servisi;

import org.springframework.stereotype.Service;

@Service
public class TipLjubimcaServisImpl implements TipLjubimcaServis{

    public final TipLjubimcaRepository tipLjubimcaRepository;

    public TipLjubimcaServisImpl(TipLjubimcaRepository tipLjubimcaRepository) {
        this.tipLjubimcaRepository = tipLjubimcaRepository;
    }
}
