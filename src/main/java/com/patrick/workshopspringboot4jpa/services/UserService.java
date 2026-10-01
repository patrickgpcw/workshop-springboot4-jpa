package com.patrick.workshopspringboot4jpa.services;

import com.patrick.workshopspringboot4jpa.entities.User;
import com.patrick.workshopspringboot4jpa.repositories.UserRepository;
import jakarta.transaction.Transactional;
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

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void update( Long id,User user) {
        User old = findById(id);
        old.setName(user.getName());
        old.setEmail(user.getEmail());
        old.setPhone(user.getPhone());
        old.setPassword(user.getPassword());
        repository.save(old);
    }

}
