package com.patrick.workshopspringboot4jpa.resources;

import com.patrick.workshopspringboot4jpa.entities.User;
import com.patrick.workshopspringboot4jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<User>> findAll(
            @PageableDefault(size = 10, sort = "id") Pageable pageable
    ) {
        Page<User> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
