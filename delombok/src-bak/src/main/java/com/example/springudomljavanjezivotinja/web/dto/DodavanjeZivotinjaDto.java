package com.example.springudomljavanjezivotinja.web.dto;

import java.time.LocalDate;

public class DodavanjeZivotinjaDto {

    private String imeLjubimca;
    private String TipLjubimca;

    private LocalDate datumRodjenja;

    public DodavanjeZivotinjaDto(){

    }

    public DodavanjeZivotinjaDto(String imeLjubimca, LocalDate datumRodjenja, String tipLjubimca) {
        this.imeLjubimca = imeLjubimca;
        this.datumRodjenja = datumRodjenja;
        this.TipLjubimca = tipLjubimca;
    }

    public String getImeLjubimca() {
        return imeLjubimca;
    }

    public void setImeLjubimca(String imeLjubimca) {
        this.imeLjubimca = imeLjubimca;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTipLjubimca() {
        return TipLjubimca;
    }

    public void setTipLjubimca(String tipLjubimca) {
        TipLjubimca = tipLjubimca;
    }
}

