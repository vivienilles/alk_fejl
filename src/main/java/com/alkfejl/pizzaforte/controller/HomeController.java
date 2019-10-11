package com.alkfejl.pizzaforte.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String homepage() {
        return "Zsofiafohercegne";
    }
}
