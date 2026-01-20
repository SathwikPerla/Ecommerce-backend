package com.example.Sathwik.client;

import com.example.Sathwik.dto.PaymentWebhookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PaymentServiceClient {

    private final RestTemplate restTemplate;

    private static final String WEBHOOK_URL =
            "http://localhost:8080/api/webhooks/payment";

    /**
     * Simulate payment gateway callback
     */
    @Async
    public void simulatePaymentCallback(String orderId) {
        try {
            // simulate processing delay
            Thread.sleep(3000);

            PaymentWebhookRequest webhookRequest = new PaymentWebhookRequest();
            webhookRequest.setOrderId(orderId);
            webhookRequest.setStatus("SUCCESS");

            restTemplate.postForObject(
                    WEBHOOK_URL,
                    webhookRequest,
                    Void.class
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
