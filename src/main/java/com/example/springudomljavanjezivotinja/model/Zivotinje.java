package com.example.springudomljavanjezivotinja.model;

import java.time.LocalDate;

public class Zivotinje {

    private String imeLjubimca;
    private TipLjubimca tipLjubimca;
    private Korisnik korisnik;
    private LocalDate datumRodjenja;


    public String getImeLjubimca() {
        return imeLjubimca;
    }

    public void setImeLjubimca(String imeLjubimca) {
        this.imeLjubimca = imeLjubimca;
    }

    public TipLjubimca getTipLjubimca() {
        return tipLjubimca;
    }

    public void setTipLjubimca(TipLjubimca tipLjubimca) {
        this.tipLjubimca = tipLjubimca;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
}
