package com.sifterstudios.postmanquiz.part4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Part4Controller {

    @GetMapping("/api/v1/users")
    public List<User> getAllUsers() {
        return UserDatabase.users.getAll();
    }
}
