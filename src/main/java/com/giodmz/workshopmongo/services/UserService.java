package com.giodmz.workshopmongo.services;

import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.dto.UserDTO;
import com.giodmz.workshopmongo.repository.UserRepository;
import com.giodmz.workshopmongo.resources.exceptions.ResourceExceptionHandler;
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

    public User insert(User obj) {
        return rep.insert(obj);
    }

    public void delete(String id){
        rep.findById(id).orElseThrow(ObjectCollectedException::new);
        rep.deleteById(id);
    }

    public User fromDTO (UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
