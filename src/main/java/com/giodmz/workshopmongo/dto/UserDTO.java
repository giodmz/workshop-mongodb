package com.giodmz.workshopmongo.dto;

import com.giodmz.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {

    String id;
    String name;
    String email;

    // construtor para instanciar a partir do objeto entity
    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();

    }

}
