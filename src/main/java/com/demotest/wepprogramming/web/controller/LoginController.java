package com.demotest.wepprogramming.web.controller;

import com.demotest.wepprogramming.model.User;
import com.demotest.wepprogramming.service.impl.AuthServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final AuthServiceImpl authServiceImpl;

    public LoginController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            user = this.authServiceImpl.login(username, password);
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        } catch (RuntimeException ex) {
            model.addAttribute("hasError", true);
            model.addAttribute("message", ex.getMessage());
            return "login";
        }
    }
}