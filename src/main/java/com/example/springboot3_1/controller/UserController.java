package com.example.springboot3_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("hello", "World Cup");
        return "index";
    }
}
