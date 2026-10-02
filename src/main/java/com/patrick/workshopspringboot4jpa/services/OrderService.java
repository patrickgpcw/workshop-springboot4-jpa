package com.patrick.workshopspringboot4jpa.services;

import com.patrick.workshopspringboot4jpa.entities.Order;
import com.patrick.workshopspringboot4jpa.repositories.OrderRepository;
import com.patrick.workshopspringboot4jpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public Page<Order> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
