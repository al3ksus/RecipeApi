package com.example.recipeapi.model.jsonModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JsonIngredient {

    private String title;

    private String count;
}
