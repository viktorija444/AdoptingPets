package com.example.springudomljavanjezivotinja.web.controllers;


import com.example.springudomljavanjezivotinja.model.Korisnik;
import com.example.springudomljavanjezivotinja.servisi.KorisnikServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    KorisnikServis korisnikServis;

    @RequestMapping(value = {"/prijava"}, method = RequestMethod.GET)
    public String prijavaKlik(){
        return "prijava";
    }

    @RequestMapping(value = {"/registracija"}, method = RequestMethod.GET)
    public String registracijaKlik(Model model){
        model.addAttribute("korisnik", new Korisnik());
        return "registracija";
    }

    @RequestMapping(value = {"/registracija"}, method = RequestMethod.POST)
    public String registracijaKorisnika(Model model, @Valid Korisnik korisnik, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("successMessage", "Korisnik uspesno registrovan!");
            model.addAttribute("bindingResult", bindingResult);
            return "registracija";
        }
        List<Object> userPresentObj = korisnikServis.isKorisnikPresent(korisnik);
        if((Boolean) userPresentObj.get(0)){
            model.addAttribute("successMessage", userPresentObj.get(1));
            return "registracija";
        }

        korisnikServis.save(korisnik);
        model.addAttribute("successMessage", "Korisnik uspesno registrovan!");

        return "prijava";
    }
}
