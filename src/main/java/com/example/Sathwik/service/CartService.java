package com.example.Sathwik.service;

import com.example.Sathwik.dto.AddToCartRequest;
import com.example.Sathwik.model.CartItem;
import com.example.Sathwik.model.Product;
import com.example.Sathwik.repository.CartRepository;
import com.example.Sathwik.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItem addToCart(AddToCartRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem item = new CartItem();
        item.setUserId(request.getUserId());
        item.setProductId(product.getId());
        item.setQuantity(request.getQuantity());

        return cartRepository.save(item);
    }

    public List<CartItem> getUserCart(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public void clearCart(String userId) {
        cartRepository.deleteByUserId(userId);
    }
}
