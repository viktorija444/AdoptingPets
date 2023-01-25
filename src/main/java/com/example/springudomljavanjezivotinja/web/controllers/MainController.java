package com.example.springudomljavanjezivotinja.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/prijava")
    public String login() {
        return "prijava";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
