package com.example.springudomljavanjezivotinja.web.controllers;


import com.example.springudomljavanjezivotinja.model.User;
import com.example.springudomljavanjezivotinja.respositories.UserRepository;
import com.example.springudomljavanjezivotinja.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class AuthController {

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Autowired
    private UserRepository userRepository;



    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registrationPage(Model model){
        log.debug("Getting Register Page");

        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public String registrationUser(Model model, @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            model.addAttribute("successMessage", "User successfully register!");
            model.addAttribute("bindingResult", bindingResult);
            return "registration";
        }
        List<Object> userPresentObj = userService.isUserPresent(user);
        if((Boolean) userPresentObj.get(0)){
            model.addAttribute("successMessage", userPresentObj.get(1));
            return "registration";
        }

        userService.save(user);
        model.addAttribute("successMessage", "User successfully register!");

        log.debug("Switch to login if you have registered" + user.getId());

        return "login";
    }
}
