package com.alkfejl.pizzaforte.controller;

import com.alkfejl.pizzaforte.entity.User;
import com.alkfejl.pizzaforte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> homepage() {
        return userRepository.findAll();
    }
}
