package com.example.springudomljavanjezivotinja.servisi;


import com.example.springudomljavanjezivotinja.service.CatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ZivotinjeServisImplTest {

    @Autowired
    ZivotinjeRepository zivotinjeRepository;

    CatServiceImpl zivotinjeServisImpl;
    Zivotinja zivotinje;

    @BeforeEach // koristi se za podesavanje svega sto name je potrebno za testiranje
    void setUp() {
        zivotinjeServisImpl = new CatServiceImpl(zivotinjeRepository);
        this.zivotinje = new Zivotinja(1L, "Keti", "opis", "02.01.2001", "");
    }

    @Test
    void getZivotinjeWhenKeywordIsNUll() {
        List<Zivotinja> listaZivotinjaRepository = zivotinjeRepository.findAll();
        List<Zivotinja> listaZivotinjaServis = zivotinjeServisImpl.getZivotinje(null);

        assertNotNull(listaZivotinjaRepository);
        assertNotNull(listaZivotinjaServis);

        assertEquals(listaZivotinjaRepository.size(), listaZivotinjaServis.size());

        assertEquals(1,listaZivotinjaServis.size());
    }

    @Test
    void getZivotinje() {
        List<Zivotinja> listaZivotinjaRepository = zivotinjeRepository.search("Keti");
        List<Zivotinja> listaZivotinjaServis = zivotinjeServisImpl.getZivotinje("Keti");

        assertNotNull(listaZivotinjaRepository);
        assertNotNull(listaZivotinjaServis);

        assertEquals(listaZivotinjaRepository.size(), listaZivotinjaServis.size());

        assertEquals(1,listaZivotinjaServis.size());
    }

    @Test
    void getZivotinjeKeywordWhenIsNotPresent() {
        List<Zivotinja> listaZivotinjaRepository = zivotinjeRepository.search("Beti");
        List<Zivotinja> listaZivotinjaServis = zivotinjeServisImpl.getZivotinje("Beti");

        assertNotNull(listaZivotinjaRepository);
        assertNotNull(listaZivotinjaServis);

        assertEquals(listaZivotinjaRepository.size(), listaZivotinjaServis.size());

        assertEquals(0,listaZivotinjaServis.size());
        assertEquals(0, listaZivotinjaRepository.size());
    }



    @Test
    void saveProductToDB() {
        Zivotinja zivotinje1 = new Zivotinja();
        zivotinje1.setId(6L);
        zivotinje1.setImage("fffddfd");
        zivotinje1.setImeLjubimca("Milan");
        zivotinje1.setTipLjubimca(TipLjubimca.MACKA);
        zivotinje1.setOpis("0dcsvfvfdv");
        zivotinje1.setDatumRodjenja("02.02.2022.");


        //Zivotinja zivotinja1Provera = zivotinjeServisImpl.saveProductToDB(zivotinje1);
      //  Optional<Zivotinja> zivotinjaOptional = zi
       // assertThat(zivotinja1Provera.getImeLjubimca()).isNotNull();
    }



    @Test
    void get() {
        Optional<Zivotinja> zivorinjeOptional = zivotinjeRepository.findById(5L);
        Zivotinja zivotinjaServis = zivotinjeServisImpl.get(5L);

        assertTrue(zivorinjeOptional.isPresent());
        assertNotNull(zivotinjaServis);

        assertEquals(zivorinjeOptional.get().getId(), zivotinjaServis.getId());

    }

    // dodati test ako ne postoji ID u bazi

    @Test
    void updateZivotinje() {
        Zivotinja zivotinje1 = new Zivotinja();
        zivotinje1.setId(6L);
        zivotinje1.setImage("fffddfd");
        zivotinje1.setImeLjubimca("Ljubisa");
        zivotinje1.setTipLjubimca(TipLjubimca.MACKA);
        zivotinje1.setOpis("0dcsvfvfdv");
        zivotinje1.setDatumRodjenja("02.02.2022.");


        Zivotinja zivotinja1Provera = zivotinjeRepository.save(zivotinje1);

        assertThat(zivotinja1Provera.getImeLjubimca()).isNotNull();

    }

    @Test
    void deleteZivotinjuById() {

        Long deleteId = Long.valueOf(6L);

        zivotinjeServisImpl.deleteZivotinjuById(deleteId);


    }
}