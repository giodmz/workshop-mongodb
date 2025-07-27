package com.giodmz.workshopmongo.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Value
@Builder
@ToString
@Getter
@Setter
public class User implements Serializable {
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
