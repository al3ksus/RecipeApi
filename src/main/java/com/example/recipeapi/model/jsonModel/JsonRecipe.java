package com.example.recipeapi.model.jsonModel;

import com.example.recipeapi.model.dbModel.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JsonRecipe {

    private String title;

    private String author;

    private List<JsonIngredient> ingredients;
}
