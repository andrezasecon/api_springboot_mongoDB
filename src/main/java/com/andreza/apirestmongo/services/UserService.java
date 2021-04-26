package com.andreza.apirestmongo.services;

import com.andreza.apirestmongo.domain.User;
import com.andreza.apirestmongo.dto.UserDTO;
import com.andreza.apirestmongo.repository.UserRepository;
import com.andreza.apirestmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }


    public void deleteUSer(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
