package com.example.recipeapi.repository;

import com.example.recipeapi.model.dbModel.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNickName(String nickName);
}
