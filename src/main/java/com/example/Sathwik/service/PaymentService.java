package com.example.Sathwik.service;

import com.example.Sathwik.dto.PaymentRequest;
import com.example.Sathwik.model.Order;
import com.example.Sathwik.model.Payment;
import com.example.Sathwik.repository.OrderRepository;
import com.example.Sathwik.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public Payment createPayment(PaymentRequest request) {

        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(request.getAmount());
        payment.setStatus("PENDING");
        payment.setPaymentId("pay_mock_" + System.currentTimeMillis());
        payment.setCreatedAt(Instant.now());

        return paymentRepository.save(payment);
    }

    public void updatePaymentStatus(String orderId, String status) {

        Payment payment = paymentRepository.findByOrderId(orderId);
        payment.setStatus(status);
        paymentRepository.save(payment);

        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status.equals("SUCCESS") ? "PAID" : "FAILED");
        orderRepository.save(order);
    }
}
