package com.giodmz.workshopmongo.resources;

import com.giodmz.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method= RequestMethod.GET)
    // melhora a estrutura http com possíveis erros e cabecalhos
    public ResponseEntity<List<User>> findAll(){
        User maria = User.builder().name("maria").email("maria@email.c").id("1").build();
        User alex = User.builder().name("alex").email("alex@email.c").id("2").build();
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
