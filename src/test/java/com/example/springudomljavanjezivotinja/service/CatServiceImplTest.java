package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.model.Cat;
import com.example.springudomljavanjezivotinja.respositories.CatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CatServiceImplTest {

    @Autowired
    CatRepository catRepository;

    CatServiceImpl catService;

    Cat cat;

    @BeforeEach
    void setUp() {
        catService = new CatServiceImpl(catRepository);
        this.cat = new Cat(5L, "Misa", "Mackic", "02.01.2008", "");
    }

    @Test
    void getCatWhenKeywordIsNull() {
        List<Cat> catListRepository = catRepository.findAll();
        List<Cat> catListService = catService.getCats(null);

        assertNotNull(catListService);
        assertNotNull(catListRepository);

        assertEquals(catListRepository.size(), catListService.size());

        assertEquals(1, catListService.size());
    }

    @Test
    void getCats() {
        List<Cat> catListRepository = catRepository.search("nevena");
        List<Cat> catListService = catService.getCats("nevena");

        assertNotNull(catListService);
        assertNotNull(catListRepository);

        assertEquals(catListRepository.size(), catListService.size());

        assertEquals(1, catListService.size());

    }

    @Test
    void getCatKeywordWhenIsNotPresent() {
        List<Cat> catListRepository = catRepository.search("Beti");
        List<Cat> catListService = catService.getCats("Beti");

        assertNotNull(catListService);
        assertNotNull(catListRepository);

        assertEquals(catListRepository.size(), catListService.size());

        assertEquals(1, catListService.size());
        assertEquals(1, catListRepository.size());



    }

    @Test
    void saveCat() {
        catRepository.save(this.cat);

    }

    @Test
    void get() {
        Optional<Cat> catOptional = catRepository.findById(1L);
        Cat catService1 = catService.get(1L);

        assertTrue(catOptional.isPresent());
        assertNotNull(catService1);

        assertEquals(catOptional.get().getId(), catService1.getId());
    }

    @Test
    void updateCat() {
       this.cat.setPetName("Lukisa");

       Cat cat1 = catRepository.save(this.cat);
        assertThat(cat1.getPetName()).isNotNull();
    }

    @Test
    void deleteCatById() {

        Long deleteId = Long.valueOf(6L);

        catRepository.deleteById(deleteId);
    }
}