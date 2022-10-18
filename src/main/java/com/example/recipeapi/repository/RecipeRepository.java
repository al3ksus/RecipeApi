package com.example.recipeapi.repository;

import com.example.recipeapi.model.dbModel.Author;
import com.example.recipeapi.model.dbModel.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByAuthor(Author author);
}
