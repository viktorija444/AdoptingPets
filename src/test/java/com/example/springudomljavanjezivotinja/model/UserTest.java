package com.example.springudomljavanjezivotinja.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

   User user;

    @BeforeEach
    void setUp() {
        user = new User(5L, "Marko", "Markovic", "markomarkovic@gmail.com","0602222222", "klopka12");
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

        user.setId(idValue);

        assertEquals(idValue, user.getId());
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