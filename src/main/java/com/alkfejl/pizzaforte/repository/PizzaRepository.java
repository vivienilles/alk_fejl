package com.alkfejl.pizzaforte.repository;

import com.alkfejl.pizzaforte.entity.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer> {
    //Iterable<Pizza> findAllByName(String name);

    //Optional<User> findByUsername(String username);
}
