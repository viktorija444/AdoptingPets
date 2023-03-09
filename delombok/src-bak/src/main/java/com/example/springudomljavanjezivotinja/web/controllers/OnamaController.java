package com.example.springudomljavanjezivotinja.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OnamaController {

    @GetMapping("/onama")
    public String onamaKlik(){
        return "onama";
    }
}
