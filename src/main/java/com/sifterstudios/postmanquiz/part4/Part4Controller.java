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
    public ResponseEntity<User> addUser(@RequestBody User data) {
        return new ResponseEntity<>(new User(data),HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/users/{id}")
    public String updateUser(@RequestBody User user, @PathVariable int id) {
        String firstName = user.getFirstName();
        String email = user.getEmail();
        PaymentType paymentType = user.getPreferedPaymentType();

        UserDatabase.users.getUser(id).setFirstName(firstName);
        UserDatabase.users.getUser(id).setEmail(email);
        UserDatabase.users.getUser(id).setPreferedPaymentType(paymentType);

        return "Updated user with id " + id;
    }
}
