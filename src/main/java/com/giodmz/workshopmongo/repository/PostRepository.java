package com.giodmz.workshopmongo.repository;

import com.giodmz.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  { // repository para gerenciar classes User, e o ID é tipo String

    // consulta no spring data (query method)
    // ignoreCase -> ignora maísculo e minúsculo
    List<Post> findByTitleContainingIgnoreCase(String text);
}
