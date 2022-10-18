package com.example.recipeapi.service;

import com.example.recipeapi.model.dbModel.Ingredient;
import com.example.recipeapi.model.dbModel.Recipe;
import com.example.recipeapi.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    private final RecipeService recipeService;

    public void add(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void addList(List<Ingredient> ingredientList, Recipe recipe) {
        for (Ingredient ingredient : ingredientList) {
            ingredient.setRecipe(recipe);
            ingredientRepository.save(ingredient);
        }
    }

    public List<Ingredient> findByRecipe(Long recipeId) {
        Optional<Recipe> recipe = recipeService.getById(recipeId);

        if (recipe.isPresent()) {
            return ingredientRepository.findAllByRecipe(recipe.get());
        }
        else {
            return List.of();
        }
     }
}
