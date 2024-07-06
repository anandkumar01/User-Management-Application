package com.user.management.controller;

import com.user.management.model.UserDetails;
import com.user.management.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpSession session, Model model) {
        String message = (String) session.getAttribute("message");
        model.addAttribute("message", message);
        session.removeAttribute("message");
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserDetails user, HttpSession session) {
        System.out.println(user);

        boolean temp = userService.checkEmail(user.getEmail());
        if (temp) {
            session.setAttribute("message", "Email already exists.");
        } else {
            UserDetails userDetails = userService.createUser(user);
            if (userDetails != null) {
                session.setAttribute("message", "Registered successfully.");
            } else {
                session.setAttribute("message", "Something went wrong!");
            }
        }
        return "redirect:/register";
    }
}
