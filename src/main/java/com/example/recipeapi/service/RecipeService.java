package com.example.recipeapi.service;

import com.example.recipeapi.model.dbModel.Author;
import com.example.recipeapi.model.dbModel.Ingredient;
import com.example.recipeapi.model.dbModel.Recipe;
import com.example.recipeapi.model.jsonModel.JsonRecipe;
import com.example.recipeapi.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public void add(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public List<Recipe> getList() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getListByAuthor(Author author) {
        return recipeRepository.findAllByAuthor(author);
    }

    public Optional<Recipe> getById(Long id) {
        return recipeRepository.findById(id);
    }
}
