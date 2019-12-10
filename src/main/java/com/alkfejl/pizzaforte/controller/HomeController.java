package com.alkfejl.pizzaforte.controller;

import com.alkfejl.pizzaforte.entity.Basket;
import com.alkfejl.pizzaforte.entity.Ingredient;
import com.alkfejl.pizzaforte.entity.Pizza;
import com.alkfejl.pizzaforte.repository.BasketRepository;
import com.alkfejl.pizzaforte.repository.IngredientRepository;
import com.alkfejl.pizzaforte.repository.PizzaRepository;
import com.alkfejl.pizzaforte.repository.UserRepository;
import com.alkfejl.pizzaforte.security.AuthenticatedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
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
    IngredientRepository ingredientRepository;

    @Autowired
    AuthenticatedUser actUser;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("")
    public Basket homepage() {
        return basketRepository.findByUserId(actUser.getUser().getId());
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
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

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @DeleteMapping("/removefrombasket")
    public ResponseEntity<Basket> removeFromBasket(@RequestBody Pizza pizza) {

        Pizza actPizza = pizzaRepository.findById(pizza.getId()).get();

        Basket actBasket = basketRepository.findByUserId(actUser.getUser().getId());
        actBasket.getPizza().remove(actPizza);
        basketRepository.save(actBasket);
        return ResponseEntity.ok(actBasket);
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @PostMapping("/createpizza")
        public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
            pizzaRepository.save(pizza);
            List<Ingredient> ingredients = pizza.getIngredientList();
            for(Ingredient actIngredient : ingredients) {
                actIngredient.setPizza(pizza);
                ingredientRepository.save(actIngredient);
            }
            return ResponseEntity.ok(pizza);
        }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizza(
            @PathVariable Integer id
    ) {
        Optional<Pizza> oPizza = pizzaRepository.findById(id);
        if (oPizza.isPresent()) {
            return ResponseEntity.ok(oPizza.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

