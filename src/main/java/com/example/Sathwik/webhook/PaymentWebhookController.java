package com.example.Sathwik.webhook;

import com.example.Sathwik.dto.PaymentWebhookRequest;
import com.example.Sathwik.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks")
@RequiredArgsConstructor
public class PaymentWebhookController {

    private final PaymentService service;

    @PostMapping("/payment")
    public void handleWebhook(@RequestBody PaymentWebhookRequest request) {
        service.updatePaymentStatus(request.getOrderId(), request.getStatus());
    }
}
