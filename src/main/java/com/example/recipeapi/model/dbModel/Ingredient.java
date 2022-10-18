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
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String title;

    private String count;

    @OneToOne
    private Recipe recipe;

    public Ingredient(String title, String count) {
        this.title = title;
        this.count = count;
    }
}
