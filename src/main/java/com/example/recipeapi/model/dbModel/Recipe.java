package com.example.recipeapi.model.dbModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String title;

    private double kcal;

    private double proteins;

    private double fats;

    private double carbohydrates;

    @OneToOne
    private Author author;

    public Recipe(String title, Author author) {
        this.title = title;
        this.author = author;
    }
}
