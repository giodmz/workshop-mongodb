package com.giodmz.workshopmongo.resources;

import com.giodmz.workshopmongo.domain.Post;
import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.dto.UserDTO;
import com.giodmz.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    // melhora a estrutura http com possíveis erros e cabecalhos
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        // convertendo uma lista User em uma lista UserDTO
        // .map() pega o objeto x (User) e converte para UserDTO
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        User obj = service.fromDTO(objDto); // convertendo DTO para User
        obj = service.insert(obj);

        // recupera o endereco do novo objeto que foi inserido
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        // created retorna o código 201 HTTP (quando cria um novo recurso)
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build(); // 204 (não retorna nada)
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

}
