package com.example.preprova.controller;

import com.example.preprova.model.Product;
import com.example.preprova.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{productId}")
    public Optional<Product> findById(@RequestParam int id) {
        if (id <= 0) return Optional.empty();
        return productRepository.findById(id);
    }
}
