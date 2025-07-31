package com.giodmz.workshopmongo.resources;

import com.giodmz.workshopmongo.domain.Post;
import com.giodmz.workshopmongo.resources.util.URL;
import com.giodmz.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){ // endpoint identificar o nome do parâmetro
        text = URL.decodeParam(text); // decodifica o texto
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
