package com.daroca.ecommerce.controller;

import com.daroca.ecommerce.model.Product;
import com.daroca.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping("/product/save")
    public Product save(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }
}
