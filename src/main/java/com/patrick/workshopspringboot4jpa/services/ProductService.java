package com.patrick.workshopspringboot4jpa.services;

import com.patrick.workshopspringboot4jpa.entities.Product;
import com.patrick.workshopspringboot4jpa.repositories.ProductRepository;
import com.patrick.workshopspringboot4jpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
