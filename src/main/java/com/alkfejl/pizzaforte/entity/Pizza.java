package com.alkfejl.pizzaforte.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String description;

    @Column
    @NotNull
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        NEW, DOING, DONE
    }

    @OneToMany (mappedBy = "pizza")
    private List<Ingredient> ingredientList;

    @JsonIgnore
    @ManyToOne
    private User user;

}
