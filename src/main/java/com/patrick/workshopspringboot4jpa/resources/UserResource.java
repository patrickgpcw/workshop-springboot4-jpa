package com.patrick.workshopspringboot4jpa.resources;

import com.patrick.workshopspringboot4jpa.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Patrick", "patrick@gmail.com", "99999999", "1234");
        return ResponseEntity.ok().body(u);
    }

}
