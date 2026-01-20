package com.example.Sathwik.controller;

import com.example.Sathwik.model.Product;
import com.example.Sathwik.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }
}
