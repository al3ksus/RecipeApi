package com.example.recipeapi.controller;

import com.example.recipeapi.model.dbModel.Author;
import com.example.recipeapi.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recipeapi/authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Author author) {
        authorService.add(new Author(author.getNickName()));
        return ResponseEntity.status(HttpStatus.OK).body("Author was added");
    }
}
