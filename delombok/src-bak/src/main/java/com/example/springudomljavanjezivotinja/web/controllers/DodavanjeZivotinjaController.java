package com.example.springudomljavanjezivotinja.web.controllers;


import com.example.springudomljavanjezivotinja.servisi.ZivotinjeServis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dodavanjezivotinje")
public class DodavanjeZivotinjaController {

    public ZivotinjeServis zivotinjeServis;

    public DodavanjeZivotinjaController(ZivotinjeServis zivotinjeServis) {
        super();
        this.zivotinjeServis = zivotinjeServis;
    }

    @GetMapping
    public String prikaziDodatiZivotinjuHtml() {
        return "dodavanjezivotinje";
    }

    @ModelAttribute("zivotinje")
    public DodavanjeZivotinjaDto dodavanjeZivotinjaDto() {
        return new DodavanjeZivotinjaDto();

    }

    @PostMapping
    public String dodavanjeZivotinjaNaloga(@ModelAttribute("zivotinje")DodavanjeZivotinjaDto dodavanjeZivotinjaDto) {
        zivotinjeServis.save(dodavanjeZivotinjaDto);
        return "redirect:/dodavanjezivotinje?success";
    }
}


