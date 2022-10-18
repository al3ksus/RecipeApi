package com.example.recipeapi.repository;

import com.example.recipeapi.model.dbModel.Ingredient;
import com.example.recipeapi.model.dbModel.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByRecipe(Recipe recipe);
}
