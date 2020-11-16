package com.se.debreczeni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return homePage();
    }

    @GetMapping("/index")
    public String homePage() {
        return "redirect:/users/";
    }
}
