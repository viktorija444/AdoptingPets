package com.example.springudomljavanjezivotinja.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/about_us")
    public String aboutUsPage(){
        return "about_us";
    }
}
