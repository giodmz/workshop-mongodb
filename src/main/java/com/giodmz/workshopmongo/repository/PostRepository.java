package com.giodmz.workshopmongo.repository;

import com.giodmz.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  { // repository para gerenciar classes User, e o ID é tipo String

}
