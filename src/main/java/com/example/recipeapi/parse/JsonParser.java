package com.example.recipeapi.parse;

import com.example.recipeapi.model.dbModel.Author;
import com.example.recipeapi.model.dbModel.Ingredient;
import com.example.recipeapi.model.dbModel.Recipe;
import com.example.recipeapi.model.jsonModel.JsonIngredient;
import com.example.recipeapi.model.jsonModel.JsonRecipe;
import com.example.recipeapi.service.AuthorService;
import com.example.recipeapi.service.IngredientService;
import com.example.recipeapi.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JsonParser {

    private final RecipeService recipeService;

    private final IngredientService ingredientService;

    private final AuthorService authorService;

    public List<JsonRecipe> getJsonRecipeList() {
        List<Recipe> recipeList = recipeService.getList();
        List<JsonRecipe> jsonRecipeList = new ArrayList<>();

        for (Recipe recipe : recipeList) {
            jsonRecipeList.add(new JsonRecipe(
                    recipe.getTitle(),
                    recipe.getAuthor().getNickName(),
                    toJsonIngredientList(ingredientService.findByRecipe(recipe.getId()))));
        }

        return jsonRecipeList;
    }

    public List<JsonRecipe> getJsonRecipeList(String nickName) {
        Optional<Author> author = authorService.getByNickName(nickName);
        List<Recipe> recipeList;
        List<JsonRecipe> jsonRecipeList = new ArrayList<>();

        if (author.isPresent()) {
            recipeList = recipeService.getListByAuthor(author.get());

            for (Recipe recipe : recipeList) {
                jsonRecipeList.add(new JsonRecipe(
                        recipe.getTitle(),
                        recipe.getAuthor().getNickName(),
                        toJsonIngredientList(ingredientService.findByRecipe(recipe.getId()))));
            }
        }

        return jsonRecipeList;
    }

    public List<Ingredient> toIngredientList(List<JsonIngredient> jsonIngredientList) {
        List<Ingredient> ingredientList = new ArrayList<>();

        for (JsonIngredient jsonIngredient : jsonIngredientList) {
            ingredientList.add(new Ingredient(jsonIngredient.getTitle(), jsonIngredient.getCount()));
        }

        return ingredientList;
    }

    private List<JsonIngredient> toJsonIngredientList(List<Ingredient> ingredientList) {
        List<JsonIngredient> jsonIngredientList = new ArrayList<>();

        for (Ingredient ingredient : ingredientList) {
            jsonIngredientList.add(new JsonIngredient(ingredient.getTitle(), ingredient.getCount()));
        }

        return jsonIngredientList;
    }


}
