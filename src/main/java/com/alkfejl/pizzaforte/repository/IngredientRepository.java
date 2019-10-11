package com.alkfejl.pizzaforte.repository;

import com.alkfejl.pizzaforte.entity.Ingredient;
import com.alkfejl.pizzaforte.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    //Optional<User> findByUsername(String username);
}
