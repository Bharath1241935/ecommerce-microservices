package com.ecommerce.orderservice.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateOrderRequest(

        @NotNull
        Long customerId,

        @NotBlank
        String customerName,

        String customerEmail,

        String customerPhone,

        @NotBlank
        String shippingAddress,

        @NotNull
        String productId,

        @NotBlank
        String productName,

        @NotNull
        @Min(1)
        Integer quantity,

        @NotNull
        @DecimalMin("0.01")
        BigDecimal unitPrice,

        String paymentMethod

) {
}