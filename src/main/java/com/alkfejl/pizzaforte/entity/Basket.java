package com.alkfejl.pizzaforte.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*@Column
    private String name;

    @JsonIgnore
    @OneToMany (mappedBy = "basket")
    private List<Pizza> pizzaList;

    @JsonIgnore
    @OneToOne
    private User user;*/

    @ManyToOne
    private User user;

    @OneToMany
    private List<Pizza> pizza;
}