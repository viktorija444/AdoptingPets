package com.example.springudomljavanjezivotinja.web.dto;

public class KorisnikRegistracijaDto {

    private String ime;
    private String prezime;
    private String brojTelefona;
    private String email;
    private String lozinka;
    private String potvrdaLozinke;


    public KorisnikRegistracijaDto() {

    }
    public KorisnikRegistracijaDto(String ime, String prezime, String email, String brojTelefona, String lozinka, String potvrdaLozinke) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.lozinka = lozinka;
        this.potvrdaLozinke = potvrdaLozinke;

    }



    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }


    public String getPotvrdaLozinke() {
        return potvrdaLozinke;
    }

    public void setPotvrdaLozinke(String potvrdaLozinke) {
        this.potvrdaLozinke = potvrdaLozinke;
    }
}


