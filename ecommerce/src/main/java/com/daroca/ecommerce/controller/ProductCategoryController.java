package com.daroca.ecommerce.controller;

import com.daroca.ecommerce.model.ProductCategory;
import com.daroca.ecommerce.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository repository;

    @GetMapping("/productCategory")
    public List<ProductCategory> all() {
        return repository.findAll();
    }

}
