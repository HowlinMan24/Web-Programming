package com.demotest.wepprogramming.web.controller;

import com.demotest.wepprogramming.service.impl.AuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthServiceImpl authServiceImpl;

    public RegisterController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @GetMapping
    public String register(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "register";
    }

    @PostMapping
    public String register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String repeatedPassword,
            @RequestParam String name,
            @RequestParam String surname) {
        try {
            this.authServiceImpl.register(username, password, repeatedPassword, name, surname);
            return "redirect:/login";
        } catch (RuntimeException ex) {
            return "redirect:/register?error=" + ex.getMessage();
        }
    }
}