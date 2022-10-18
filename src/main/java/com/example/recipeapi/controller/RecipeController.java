package com.example.recipeapi.controller;

import com.example.recipeapi.model.dbModel.Author;
import com.example.recipeapi.model.dbModel.Recipe;
import com.example.recipeapi.model.jsonModel.JsonRecipe;
import com.example.recipeapi.parse.JsonParser;
import com.example.recipeapi.service.AuthorService;
import com.example.recipeapi.service.IngredientService;
import com.example.recipeapi.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("recipeapi/recipes")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    private final IngredientService ingredientService;

    private final AuthorService authorService;

    private  final JsonParser jsonParser;

    @GetMapping("/getlist")
    public List<JsonRecipe> getList() {
        return jsonParser.getJsonRecipeList();
    }

    @GetMapping("/getlist/{author}")
    public List<JsonRecipe> getListByAuthor(@PathVariable String author) {
        return jsonParser.getJsonRecipeList(author);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody JsonRecipe jsonRecipe) {
        Optional<Author> author = authorService.getByNickName(jsonRecipe.getAuthor());

        if (author.isPresent()) {
            Recipe recipe = new Recipe(jsonRecipe.getTitle(), author.get());
            recipeService.add(recipe);
            ingredientService.addList(jsonParser.toIngredientList(jsonRecipe.getIngredients()), recipe);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Recipe was added");
    }
}
