package com.se.debreczeni.controller;

import com.se.debreczeni.controller.repository.BookRepository;
import com.se.debreczeni.controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/index")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }


}
