package com.damedomey.api.web.controller;

import com.damedomey.api.model.User;
import com.damedomey.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping(value = "")
    public List<User> index(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User show(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Void> add(@RequestBody User user){
        User userAdded = repository.persist(user);

        if (userAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping(value = "/{id}/edit")
    public ResponseEntity<Void> edit(@RequestBody User user, @PathVariable int id){
        User userAdded = repository.persist(user, id);

        if (userAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<Void> delete(){
        return null;
    }
}
