package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/login")
    public String loginPage() {
        return "login";  // Ensure there's a login.html or login view
    }

    @RequestMapping("/home")
    public String homePage() {
        return "home";  // Ensure there's a home.html or home view
    }
}
