package com.example.springudomljavanjezivotinja.controllers;

import com.example.springudomljavanjezivotinja.servisi.KorisnikServis;
import com.example.springudomljavanjezivotinja.web.dto.KorisnikRegistracijaDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registracija")
public class KorisnickiRegistracioniController {

    private KorisnikServis korisnikServis;

    public KorisnickiRegistracioniController(KorisnikServis korisnikServis) {
        super();
        this.korisnikServis = korisnikServis;
    }

    @ModelAttribute("korisnik")
    public KorisnikRegistracijaDto korisnikRegistracijaDto() {
        return new KorisnikRegistracijaDto();

    }

    @GetMapping
    public String prikaziRegistraciniHtml() {
        return "registracija";
    }

    @PostMapping
    public String registracijaKorisnickogNaloga(@ModelAttribute("korisnik")KorisnikRegistracijaDto korisnikRegistracijaDto) {
        korisnikServis.save(korisnikRegistracijaDto);
        return "redirect:/registracija?success";
    }
}
