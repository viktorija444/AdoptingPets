package com.example.springudomljavanjezivotinja.web.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class KorisnikRegistracijaDto {

    @NotBlank(message = "Unesite vase ime")
    private String ime;
    @NotBlank(message = "Unesite vase prezime")
    private String prezime;
    @NotBlank(message = "Unesite broj telefona")
    private String brojTelefona;
    @NotBlank(message = "Unesite email")
    @Email(message = "Unesite pravilan email")
    private String email;
    @Length(min = 6, message = "Lozinka treba da bude duza od 6 karaktera")
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


