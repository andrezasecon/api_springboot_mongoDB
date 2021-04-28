package com.andreza.apirestmongo.services;

import com.andreza.apirestmongo.domain.Post;
import com.andreza.apirestmongo.repository.PostRepository;
import com.andreza.apirestmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

//     Consulta utilizando Query methods
//    public List<Post> findByTitle(String text){
//        return postRepo.findByTitleContainingIgnoreCase(text);
//    }

    // consulta utilizando o @Query
    public List<Post> findByTitle(String text){
        return postRepo.findByTitle(text);
    }

    // consulta utilizando o @Query com vários critérios
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepo.fullSearch(text, minDate, maxDate);
    }
}
