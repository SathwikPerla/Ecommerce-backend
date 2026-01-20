package com.example.Sathwik.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
public class Order {
    @Id
    private String id;
    private String userId;
    private Double totalAmount;
    private String status; // CREATED, PAID, FAILED
    private Instant createdAt;
}