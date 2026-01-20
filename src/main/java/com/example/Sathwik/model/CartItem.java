package com.example.Sathwik.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CartItem {
    @Id
    private String id;
    private String userId;
    private String productId;
    private Integer quantity;
}