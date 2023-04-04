package com.example.springudomljavanjezivotinja.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisnikTest {

    Korisnik korisnik;

    @BeforeEach
    void setUp() {
        korisnik = new Korisnik(5L, "", "", "","", "");
    }

    @Test
    void getAuthorities() {
    }

    @Test
    void getZivotinje() {
    }

    @Test
    void setZivotinje() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void getUsername() {
    }

    @Test
    void getId() throws Exception{
        Long idValue = 4L;

        korisnik.setId(idValue);

        assertEquals(idValue, korisnik.getId());
    }

    @Test
    void getRole() {
    }

    @Test
    void getIme() {
    }

    @Test
    void getPrezime() {
    }



    @Test
    void getEmail() {
    }

    @Test
    void getBrojTelefona() {
    }




}