package com.example.springudomljavanjezivotinja.web.controllers;

import com.example.springudomljavanjezivotinja.model.Zivotinje;
import com.example.springudomljavanjezivotinja.respositories.ZivotinjeRepository;
import com.example.springudomljavanjezivotinja.servisi.ZivotinjeServis;
import com.example.springudomljavanjezivotinja.servisi.ZivotinjeServisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@Controller
public class MackeController {


    @Autowired
    private final ZivotinjeServis zivotinjeServis;
    @Autowired
    private ZivotinjeRepository zivotinjeRepository;


    public MackeController(ZivotinjeServis zivotinjeServis) {

        this.zivotinjeServis = zivotinjeServis;

    }

    @GetMapping("/macke")
    public String mackeKlik(Model model, @Param("keyword") String keyword) {

        List<Zivotinje> zivotinje = zivotinjeServis.getZivotinje(keyword);
        model.addAttribute("zivotinje", zivotinje);
        model.addAttribute("keyword", keyword);
        return "macke";
    }

    @GetMapping("/dodavanjezivotinje")
    public String add(Model model) {
        model.addAttribute("zivotinje", new Zivotinje());
        return "dodavanjezivotinje";
    }

    @PostMapping("/dodavanjezivotinje")
    public String saveProduct(@RequestParam("file") MultipartFile file,
                              @RequestParam("imeLjubimca") String imeLjubimca,
                              @RequestParam("tipLjubimca") String tipLjubimca,
                              @RequestParam("opis") String opis,
                              @RequestParam("datumRodjenja") String datumRodjenja)
    {
        zivotinjeServis.saveProductToDB(file, imeLjubimca, tipLjubimca, opis, datumRodjenja);
        return "redirect:/macke";
    }

    @GetMapping("/macke/edit/{id}")
    public String editZivotinje(@PathVariable Long id, Model model) {
        model.addAttribute("zivotinje", zivotinjeServis.get(id));
        return "edit_zivotinje";
    }



    @PostMapping("/macke/{id}")
    public String updateZivotinje(@PathVariable Long id,
                                  @RequestParam("file") MultipartFile file,
                                @ModelAttribute("zivotinje") Zivotinje zivotinje,
                                Model model) {

        // get zivotinje from database by id
        Zivotinje existingZivotinje = zivotinjeServis.get(id);
        String fileNam = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileNam.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            existingZivotinje.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        existingZivotinje.setId(id);
        existingZivotinje.setImeLjubimca(zivotinje.getImeLjubimca());
        existingZivotinje.setTipLjubimca(zivotinje.getTipLjubimca());
        existingZivotinje.setOpis(zivotinje.getOpis());
        existingZivotinje.setDatumRodjenja(zivotinje.getDatumRodjenja());



        zivotinjeServis.updateZivotinje(existingZivotinje);
        return "redirect:/macke";
    }


    @GetMapping("/macke/{id}")
    public String deleteZivotinju(@PathVariable Long id) {
        zivotinjeServis.deleteZivotinjuById(id);
        return "redirect:/macke";
    }
}

