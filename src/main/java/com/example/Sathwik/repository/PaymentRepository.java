package com.example.Sathwik.repository;

import com.example.Sathwik.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {

    Payment findByOrderId(String orderId);
}
