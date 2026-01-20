package com.example.Sathwik.controller;

import com.example.Sathwik.dto.CreateOrderRequest;
import com.example.Sathwik.model.Order;
import com.example.Sathwik.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Order create(@RequestBody CreateOrderRequest request) {
        return service.createOrder(request.getUserId());
    }
}
