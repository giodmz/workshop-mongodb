package com.giodmz.workshopmongo.repository;

import com.giodmz.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>  { // repository para gerenciar classes User, e o ID é tipo String

}
