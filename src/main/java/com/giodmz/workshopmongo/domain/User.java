package com.giodmz.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// @Value deixa a classe imutável

@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Document // corresponde uma colecao do mongoDB (user)
public class User implements Serializable {

    @Id
    String id;
    String name;
    String email;

    @Builder
    public User(String email, String id, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    // posts vão ser carregados apenas quando forem explicitamente acessados
    @DBRef(lazy = true)
    List<Post> posts = new ArrayList<>();


}
