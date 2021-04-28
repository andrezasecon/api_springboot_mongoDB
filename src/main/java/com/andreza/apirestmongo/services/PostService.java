package com.andreza.apirestmongo.services;

import com.andreza.apirestmongo.domain.Post;
import com.andreza.apirestmongo.repository.PostRepository;
import com.andreza.apirestmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post findById(String id) {
        Optional<Post> obj = postRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepo.findByTitleContainingIgnoreCase(text);
    }
}
