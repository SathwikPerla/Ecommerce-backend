package com.example.Sathwik.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateOrderRequest {

    @NotBlank(message = "User ID is required")
    private String userId;
}
