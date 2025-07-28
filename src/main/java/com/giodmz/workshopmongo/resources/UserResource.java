package com.giodmz.workshopmongo.resources;

import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.dto.UserDTO;
import com.giodmz.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method= RequestMethod.GET)
    // melhora a estrutura http com possíveis erros e cabecalhos
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        // convertendo uma lista User em uma lista UserDTO
        // .map() pega o objeto x (User) e converte para UserDTO
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
