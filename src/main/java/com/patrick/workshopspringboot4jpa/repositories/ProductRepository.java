package com.patrick.workshopspringboot4jpa.repositories;

import com.patrick.workshopspringboot4jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
