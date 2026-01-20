package com.example.Sathwik.controller;

import com.example.Sathwik.dto.AddToCartRequest;
import com.example.Sathwik.model.CartItem;
import com.example.Sathwik.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @PostMapping("/add")
    public CartItem add(@RequestBody AddToCartRequest request) {
        return service.addToCart(request);
    }

    @GetMapping("/{userId}")
    public List<CartItem> get(@PathVariable String userId) {
        return service.getUserCart(userId);
    }

    @DeleteMapping("/{userId}/clear")
    public void clear(@PathVariable String userId) {
        service.clearCart(userId);
    }
}
