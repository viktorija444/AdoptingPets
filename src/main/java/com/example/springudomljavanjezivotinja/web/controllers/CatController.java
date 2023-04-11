package com.example.springudomljavanjezivotinja.web.controllers;

import com.example.springudomljavanjezivotinja.model.Cat;
import com.example.springudomljavanjezivotinja.respositories.CatRepository;
import com.example.springudomljavanjezivotinja.service.CatService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class CatController {

    private CatService catService;
    @Autowired
    private CatRepository catRepository;


    public CatController(CatService catService) {

        this.catService = catService;
    }

    @GetMapping("/cats")
    public String catPage(Model model, @Param("keyword") String keyword) {

        List<Cat> cats = catService.getCats(keyword);
        model.addAttribute("cats", cats);
        model.addAttribute("keyword", keyword);
        return "cats";
    }


    @GetMapping("/add_cat")
    public String add(Model model) {
        model.addAttribute("cats", new Cat());
        return "add_cat";
        }


//    @PostMapping("/dodavanjezivotinje")
//    public String saveZivotinju(@RequestParam("file") MultipartFile file,
//                              @RequestParam("imeLjubimca") String imeLjubimca,
//                              @RequestParam("tipLjubimca") TipLjubimca tipLjubimca,
//                              @RequestParam("opis") String opis,
//                              @RequestParam("datumRodjenja") String datumRodjenja) {
//
//
//        zivotinjeServis.saveProductToDB(file, imeLjubimca, tipLjubimca, opis, datumRodjenja);
//
//
//        if(tipLjubimca == TipLjubimca.PAS) {
//            return "redirect:/psi";
//
//        }
//        return "redirect:/macke";
//
// }

    @PostMapping("/add_cat")
    public String saveCat(@RequestParam("file") MultipartFile file,
                                @ModelAttribute @Valid Cat cats) {

        log.debug("Save cat DB" + cats.getId());

        catService.saveCat(file, cats);

        return "redirect:/cats";
        }


    @GetMapping("/cats/edit/{id}")
    public String editCat(@PathVariable Long id, Model model) {
        model.addAttribute("cats", catService.get(id));
        return "edit_cat";
    }



    @PostMapping("/cats/{id}")
    public String updateCat(@PathVariable Long id,
                                  @RequestParam("file") MultipartFile file,
                                @ModelAttribute("cats") Cat cats,
                                Model model) {

        catService.updateCat(cats, file, id);



        return "redirect:/cats";
    }


    @GetMapping("/cats/{id}")
    public String deleteCat(@PathVariable Long id) {

        log.debug("Delete cat id" + id);

        catService.deleteCatById(id);

        return "redirect:/cats";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}

