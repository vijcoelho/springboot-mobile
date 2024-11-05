package com.example.preprova.controller;

import com.example.preprova.model.ProductCategory;
import com.example.preprova.repository.ProductCategoryRepository;
import com.example.preprova.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

    @GetMapping("/{productCategoryId}")
    public Optional<ProductCategory> findById(@RequestParam int id) {
        if (id <= 0) return Optional.empty();
        return productCategoryRepository.findById(id);
    }

    @GetMapping("/{productCategoryId}/products")
    public Optional<ProductCategory> findProductsByCategoryId(@RequestParam int id) {
        return productCategoryRepository.findById(id);
    }
}
