package com.patrick.workshopspringboot4jpa.services;

import com.patrick.workshopspringboot4jpa.entities.User;
import com.patrick.workshopspringboot4jpa.repositories.UserRepository;
import com.patrick.workshopspringboot4jpa.resources.dto.UserUpdateRequest;
import com.patrick.workshopspringboot4jpa.resources.mapper.UserMapper;
import com.patrick.workshopspringboot4jpa.services.exceptions.DatabaseException;
import com.patrick.workshopspringboot4jpa.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void insert(User user) {
        repository.save(user);
    }

    public void delete(Long id) {
        try {
            User user = findById(id);
            repository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

    }

    @Transactional
    public User update(Long id, UserUpdateRequest request) {
        User user = findById(id);
        UserMapper.updateEntity(request, user);
        return user;

    }

}
