package com.alkfejl.pizzaforte.controller;

import com.alkfejl.pizzaforte.entity.Basket;
import com.alkfejl.pizzaforte.entity.Pizza;
import com.alkfejl.pizzaforte.entity.User;
import com.alkfejl.pizzaforte.repository.BasketRepository;
import com.alkfejl.pizzaforte.repository.PizzaRepository;
import com.alkfejl.pizzaforte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping("/home")
    public Basket homepage() {
        return basketRepository.findByUserId(1);
    }

    @PostMapping("/addtobasket")
    public ResponseEntity<Basket> addToBasket(@RequestBody Pizza pizza) {
        Optional<User> oUser = userRepository.findById(1);
        User actUser = oUser.get();

        Pizza actPizza = pizzaRepository.findById(pizza.getId()).get();

        Basket actBasket = basketRepository.findByUserId(actUser.getId());
        actBasket.getPizza().add(actPizza);

        return ResponseEntity.ok(basketRepository.save(actBasket));
    }
}
