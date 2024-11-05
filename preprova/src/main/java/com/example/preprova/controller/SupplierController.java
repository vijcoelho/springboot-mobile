package com.example.preprova.controller;

import com.example.preprova.model.Supplier;
import com.example.preprova.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/suppliers")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @PostMapping
    public Supplier addSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @GetMapping("/{supplierId}")
    private Optional<Supplier> findById(@RequestParam int id) {
        if (id <= 0) return Optional.empty();
        return supplierRepository.findById(id);
    }
}
