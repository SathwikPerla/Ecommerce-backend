package com.example.Sathwik.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaymentWebhookRequest {

    @NotBlank(message = "Order ID is required")
    private String orderId;

    @NotBlank(message = "Payment status is required")
    private String status;
    // Expected values: SUCCESS, FAILED
}