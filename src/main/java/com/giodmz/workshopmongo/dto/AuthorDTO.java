package com.giodmz.workshopmongo.dto;

import com.giodmz.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {

    String id;
    String name;

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

}
