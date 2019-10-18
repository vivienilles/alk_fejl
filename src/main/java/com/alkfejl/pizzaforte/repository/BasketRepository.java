package com.alkfejl.pizzaforte.repository;

import com.alkfejl.pizzaforte.entity.Basket;
import com.alkfejl.pizzaforte.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Integer> {
    Basket findByUserId(Integer id);
}
