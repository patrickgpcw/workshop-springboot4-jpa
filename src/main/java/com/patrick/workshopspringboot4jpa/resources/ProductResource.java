package com.patrick.workshopspringboot4jpa.resources;

import com.patrick.workshopspringboot4jpa.entities.Product;
import com.patrick.workshopspringboot4jpa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductResource {

    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        Page<Product> page = service.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
