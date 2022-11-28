package com.sifterstudios.postmanquiz.part4;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Part4Controller {

    @GetMapping("/api/v1/users")
    public List<User> getAllUsers() {
        return UserDatabase.users.getAll();
    }

    @PostMapping("/api/v1/users")
    public User addUser(@RequestBody User data) {
        return new User(data);
    }
}
