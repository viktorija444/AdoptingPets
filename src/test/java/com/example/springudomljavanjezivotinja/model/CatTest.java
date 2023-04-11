package com.example.springudomljavanjezivotinja.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat();
    }

    @Test
    void getUser() {
    }

    @Test
    void setUser() {
    }

    @Test
    void getImage() {
    }

    @Test
    void setImage() {
    }

    @Test
    void getId() {
        Long idValue = 4L;

        cat.setId(idValue);

        assertEquals(idValue, cat.getId());
    }

    @Test
    void setId() {
    }

    @Test
    void getPetName() {
    }

    @Test
    void setPetName() {
    }

    @Test
    void getDateOfBirth() {
    }

    @Test
    void setDateOfBirth() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void testToString() {
    }
}