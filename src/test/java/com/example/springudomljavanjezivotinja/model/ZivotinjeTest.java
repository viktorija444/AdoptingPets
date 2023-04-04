package com.example.springudomljavanjezivotinja.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZivotinjeTest {

    Zivotinja zivotinje;

    @BeforeEach
    void setUp() {
        zivotinje = new Zivotinja();
    }

    @Test
    void getKorisnik() {
    }

    @Test
    void getImage() {
    }

    @Test
    void getId() {
        Long idValue = 4L;

        zivotinje.setId(idValue);

        assertEquals(idValue, zivotinje.getId());
    }

    @Test
    void getImeLjubimca() {
    }

    @Test
    void getDatumRodjenja() {
    }

    @Test
    void getTipLjubimca() {
    }

    @Test
    void getOpis() {
    }
}