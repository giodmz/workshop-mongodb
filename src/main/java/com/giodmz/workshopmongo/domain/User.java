package com.giodmz.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Value
@Builder
@ToString
@Getter
@Setter
@Document // corresponde uma colecao do mongoDB (user)
public class User implements Serializable {

    @Id
    String id;
    String name;
    String email;

    public User(String email, String id, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
