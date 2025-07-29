package com.giodmz.workshopmongo.services;

import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.dto.UserDTO;
import com.giodmz.workshopmongo.repository.UserRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User update(User obj) {
        User newObj = rep.findById(obj.getId()).orElseThrow(ObjectCollectedException::new);
        updateData(newObj, obj);
        return rep.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO (UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
