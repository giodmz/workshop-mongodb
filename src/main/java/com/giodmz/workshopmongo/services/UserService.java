package com.giodmz.workshopmongo.services;

import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.repository.UserRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // instancia o UserRepository
    @Autowired
    private UserRepository rep;

    public List<User> findAll() {
        return rep.findAll();
    }

    public User findById(String id){
        return rep.findById(id).orElseThrow(ObjectCollectedException::new);
    }
}
