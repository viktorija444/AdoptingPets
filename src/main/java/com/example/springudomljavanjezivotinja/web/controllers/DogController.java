package com.example.springudomljavanjezivotinja.web.controllers;

import com.example.springudomljavanjezivotinja.model.Dog;
import com.example.springudomljavanjezivotinja.respositories.DogRepository;
import com.example.springudomljavanjezivotinja.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DogController {

    @Autowired
    private final DogService dogService;
    @Autowired
    private DogRepository dogRepository;


    public DogController(DogService dogService) {

        this.dogService = dogService;

    }

    @GetMapping("/dogs")
    public String dogPage(Model model, @Param("keyword") String keyword) {

        List<Dog> dogs = dogService.getDogs(keyword);
        model.addAttribute("dogs", dogs);
        model.addAttribute("keyword", keyword);
        return "dogs";
    }


    @GetMapping("/add_dog")
    public String add(Model model) {
        model.addAttribute("dogs", new Dog());
        return "add_dog";
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

    @PostMapping("/add_pets")
    public String saveDog(@RequestParam("file") MultipartFile file,
                          @ModelAttribute @Valid Dog dogs) {

        dogService.saveDog(file, dogs);

        return "redirect:/cats";
    }


    @GetMapping("/edit/{id}")
    public String editDog(@PathVariable Long id, Model model) {
        model.addAttribute("dogs", dogService.get(id));
        return "edit_pets";
    }



    @PostMapping("/{id}")
    public String updateDog(@PathVariable Long id,
                            @RequestParam("file") MultipartFile file,
                            @ModelAttribute("dog") Dog dog,
                            Model model) {

        dogService.updateDog(dog, file, id);



        return "redirect:/dogs";
    }


    @GetMapping("/{id}")
    public String deleteDog(@PathVariable Long id) {
        dogService.deleteDogById(id);

        return "redirect:/dogs";
    }
}
