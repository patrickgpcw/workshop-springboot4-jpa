package com.patrick.workshopspringboot4jpa.resources;

import com.patrick.workshopspringboot4jpa.entities.User;
import com.patrick.workshopspringboot4jpa.resources.dto.UserCreateRequest;
import com.patrick.workshopspringboot4jpa.resources.dto.UserResponse;
import com.patrick.workshopspringboot4jpa.resources.dto.UserUpdateRequest;
import com.patrick.workshopspringboot4jpa.resources.mapper.UserMapper;
import com.patrick.workshopspringboot4jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> findAll(
            @PageableDefault(size = 10, sort = "id") Pageable pageable
    ) {
        Page<User> users = service.findAll(pageable);
        Page<UserResponse> response = users.map(UserMapper::toResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        User user = service.findById(id);
        UserResponse responses = UserMapper.toResponse(user);
        return ResponseEntity.ok().body(responses);
    }

    @PostMapping
    public ResponseEntity<UserResponse> insert(@RequestBody UserCreateRequest request) {
        User user = UserMapper.toEntity(request);
        service.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(UserMapper.toResponse(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        User user = service.update(id, request);
        return ResponseEntity.ok(UserMapper.toResponse(user));
    }
}
