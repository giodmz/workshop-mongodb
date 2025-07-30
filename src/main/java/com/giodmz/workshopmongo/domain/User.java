package com.giodmz.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

// @Value deixa a classe imutável
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document // corresponde uma colecao do mongoDB (user)
public class User implements Serializable {

    @Id
    String id;
    String name;
    String email;


}
