package com.example.springudomljavanjezivotinja.web.controllers;

import com.example.springudomljavanjezivotinja.servisi.ZivotinjeServis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MackeController {

    private final MackeServis mackeServis;
    private final ZivotinjeServis zivotinjeServis;
    private final TipLjubimcaServis tipLjubimcaServis;


    public MackeController(MackeServis mackeServis, ZivotinjeServis zivotinjeServis, TipLjubimcaServis tipLjubimcaServis) {
        this.mackeServis = mackeServis;
        this.zivotinjeServis = zivotinjeServis;
        this.tipLjubimcaServis = tipLjubimcaServis;
    }

    @GetMapping("/macke")
    public String mackeKlik() {
        return "macke";
    }


}

