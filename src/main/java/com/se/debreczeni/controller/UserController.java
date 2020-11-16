package com.se.debreczeni.controller;

import com.se.debreczeni.model.User;
import com.se.debreczeni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String showMain(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "users/index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "users/add";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/add";
        }

        userRepository.save(user);

        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "users/update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            user.setId(id);
            return "users/update";
        }

        userRepository.save(user);

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);

        return "redirect:/index";
    }
}