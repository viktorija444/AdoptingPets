package com.example.springudomljavanjezivotinja.servisi;

import com.example.springudomljavanjezivotinja.model.Korisnik;
import com.example.springudomljavanjezivotinja.respositories.UserRepository;
import com.example.springudomljavanjezivotinja.respositories.ZivotinjeRepository;
import com.example.springudomljavanjezivotinja.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class KorisnikServisimplTest {

    @MockBean
    UserRepository korisnikRepository;

    Korisnik korisnik;

    UserServiceImpl korisnikServisimpl;
    @Autowired
    private ZivotinjeRepository zivotinjeRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void save() {

    }

    @Test
    void isKorisnikEmailPresent() {
        Korisnik postojeciEmailRep = new Korisnik();


        korisnikRepository.save(postojeciEmailRep);

        when(korisnikRepository.findByEmail("markomaric@gmail.com")).thenReturn(Optional.of(postojeciEmailRep));

        assertThat(postojeciEmailRep).isNotNull();

    }

    @Test
    void loadUserByUsername() {



    }
}