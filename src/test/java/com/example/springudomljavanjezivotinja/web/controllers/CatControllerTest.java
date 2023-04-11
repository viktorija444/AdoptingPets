package com.example.springudomljavanjezivotinja.web.controllers;

import com.example.springudomljavanjezivotinja.model.Cat;
import com.example.springudomljavanjezivotinja.respositories.CatRepository;
import com.example.springudomljavanjezivotinja.service.CatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
class CatControllerTest {

    @Mock
    CatRepository catRepository;

    @Mock
    CatService catService;

    CatController controller;

    MockMvc mockMvc;


    @BeforeEach
    public void setUp()throws Exception{
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix("/jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new CatController(catService))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    void catPage() throws Exception {
        Cat cat = new Cat();
        when(catService.get(anyLong())).thenReturn(cat);

        mockMvc.perform(get("/cats"))
                .andExpect(status().isOk())
                .andExpect(view().name("cats"))

                .andExpect(model().attributeExists("cats"));
    }

    @Test
    void add() throws Exception {
        Cat cat = new Cat();

        when(catService.get(anyLong())).thenReturn(cat);

        mockMvc.perform(get("/add_cat"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_cat"))
                .andExpect(model().attributeExists("cats"));

    }

    @Test
    void saveCat() throws Exception {
        Cat catSave = new Cat(10L, "Maca","o maci", "02.01.2008.", "");

        when(catRepository.save(any(Cat.class))).thenReturn(catSave);

        mockMvc.perform(multipart("/add_cat"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("cats"))
                .andExpect(view().name("redirect:/cats"));


        //when(catService.saveCat());

    }

    @Test
    void editCat() throws Exception {
        Cat cat = new Cat();

        when(catService.get(anyLong())).thenReturn(cat);

        mockMvc.perform(get("/cats/edit/2"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit_cat"))
                .andExpect(model().attributeExists("cats"));
    }

    @Test
    void updateCat() throws Exception{
        Cat cat = new Cat();
        cat.setId(10L);


        when(catService.get(anyLong())).thenReturn(cat);

        mockMvc.perform(get("/cats/6"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/cats"))
                .andExpect(model().attributeExists("cats"));

    }

    @Test
    void deleteCat() throws Exception {
        mockMvc.perform(get("/cats/6"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/cats"));

        verify(catService, times(1)).deleteCatById(anyLong());

    }
}