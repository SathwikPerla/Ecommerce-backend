package com.example.Sathwik.service;

import com.example.Sathwik.model.CartItem;
import com.example.Sathwik.model.Order;
import com.example.Sathwik.model.Product;
import com.example.Sathwik.repository.CartRepository;
import com.example.Sathwik.repository.OrderRepository;
import com.example.Sathwik.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public Order createOrder(String userId) {

        List<CartItem> cartItems = cartRepository.findByUserId(userId);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        double totalAmount = 0;

        for (CartItem item : cartItems) {
            Product product = productRepository
                    .findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            totalAmount += product.getPrice() * item.getQuantity();

            // reduce stock
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);
        order.setStatus("CREATED");
        order.setCreatedAt(Instant.now());

        order = orderRepository.save(order);

        // clear cart
        cartRepository.deleteByUserId(userId);

        return order;
    }
}
