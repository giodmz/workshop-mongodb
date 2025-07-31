package com.giodmz.workshopmongo.services;

import com.giodmz.workshopmongo.domain.Post;
import com.giodmz.workshopmongo.repository.PostRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository rep;

    public Post findById(String id){
        return rep.findById(id).orElseThrow(ObjectCollectedException::new);
    }

    public List<Post> findByTitle(String text) {
//        return rep.findByTitleContainingIgnoreCase(text);
        return rep.searchTitle(text);
    }


}
