package com.alkfejl.pizzaforte.controller;

import com.alkfejl.pizzaforte.entity.Basket;
import com.alkfejl.pizzaforte.entity.Pizza;
import com.alkfejl.pizzaforte.entity.User;
import com.alkfejl.pizzaforte.repository.BasketRepository;
import com.alkfejl.pizzaforte.repository.PizzaRepository;
import com.alkfejl.pizzaforte.repository.UserRepository;
import com.alkfejl.pizzaforte.security.AuthenticatedUser;
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

    @Autowired
    AuthenticatedUser actUser;

    @GetMapping("/home")
    public Basket homepage() {
        return basketRepository.findByUserId(actUser.getUser().getId());
    }

    @PostMapping("/addtobasket")
    public ResponseEntity<Basket> addToBasket(@RequestBody Pizza pizza) {

        Pizza actPizza = pizzaRepository.findById(pizza.getId()).get();

        Basket actBasket = basketRepository.findByUserId(actUser.getUser().getId());
        actBasket.getPizza().add(actPizza);

        return ResponseEntity.ok(basketRepository.save(actBasket));
    }

    @GetMapping("/listall")
    public Iterable<Pizza> listAll() {
        return pizzaRepository.findAll();
    }

    @DeleteMapping("/removefrombasket")
    public ResponseEntity<Basket> removeFromBasket(@RequestBody Pizza pizza) {

        Pizza actPizza = pizzaRepository.findById(pizza.getId()).get();

        Basket actBasket = basketRepository.findByUserId(actUser.getUser().getId());
        actBasket.getPizza().remove(actPizza);
        basketRepository.save(actBasket);
        return ResponseEntity.ok(actBasket);
    }
}

