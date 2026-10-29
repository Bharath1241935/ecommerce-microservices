package com.ecommerce.orderservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        String orderNumber,
        Long customerId,
        String customerName,
        String customerEmail,
        String customerPhone,
        String shippingAddress,
        String productId,
        String productName,
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal totalAmount,
        String paymentMethod,
        String paymentStatus,
        String paymentReference,
        String orderStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}