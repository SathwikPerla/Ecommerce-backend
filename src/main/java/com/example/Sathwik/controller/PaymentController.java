package com.example.Sathwik.controller;

import com.example.Sathwik.dto.PaymentRequest;
import com.example.Sathwik.model.Payment;
import com.example.Sathwik.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/create")
    public Payment create(@RequestBody PaymentRequest request) {
        return service.createPayment(request);
    }
}
