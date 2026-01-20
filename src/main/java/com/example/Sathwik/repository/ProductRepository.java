package com.example.Sathwik.repository;

import com.example.Sathwik.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
