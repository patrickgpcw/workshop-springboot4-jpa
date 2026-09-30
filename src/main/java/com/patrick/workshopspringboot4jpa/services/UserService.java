package com.patrick.workshopspringboot4jpa.services;

import com.patrick.workshopspringboot4jpa.entities.User;
import com.patrick.workshopspringboot4jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public User findById(Long id) {
        return repository.findById(id).get();
    }

    public void insert(User user) {
        repository.save(user);
    }

}
