package com.andreza.apirestmongo.resources;

import com.andreza.apirestmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User andreza = new User("2", "Andreza Secon", "andreza@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, andreza));
        return ResponseEntity.ok().body(list);
    }

}
