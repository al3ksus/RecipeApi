package com.example.recipeapi.service;

import com.example.recipeapi.model.dbModel.Author;
import com.example.recipeapi.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void add(Author author) {
        authorRepository.save(author);
    }

    public Optional<Author> getByNickName(String nickName) {
        return authorRepository.findByNickName(nickName);
    }
}
