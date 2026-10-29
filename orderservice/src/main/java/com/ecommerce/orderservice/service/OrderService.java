package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.dto.CreateOrderRequest;
import com.ecommerce.orderservice.dto.OrderResponse;
import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.repository.OrderRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
  //  private final RestClient catalogRestClient;

    public OrderService(OrderRepository orderRepository){

        this.orderRepository = orderRepository;
//        this.catalogRestClient = catalogRestClient;
    }

    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {

        // 1. Check inventory availability in Catalog Service.
        Boolean available;

//        try {
//            available = catalogRestClient.get()
//                    .uri(
//                            "/api/products/{productId}/availability?quantity={quantity}",
//                            request.productId(),
//                            request.quantity()
//                    )
//                    .retrieve()
//                    .body(Boolean.class);
//
//        } catch (RestClientException ex) {
//
//            throw new ResponseStatusException(
//                    HttpStatus.SERVICE_UNAVAILABLE,
//                    "Unable to check product inventory",
//                    ex
//            );
//        }
//
//        // 2. Reject the order if inventory is unavailable.
//        if (!Boolean.TRUE.equals(available)) {
//            throw new ResponseStatusException(
//                    HttpStatus.CONFLICT,
//                    "Product inventory is unavailable"
//            );
//        }

        // 3. Calculate the total amount using request details.
        BigDecimal totalAmount = request.unitPrice()
                .multiply(BigDecimal.valueOf(request.quantity()));

        // 4. Create the order entity.
        Order order = new Order();

        order.setOrderNumber("ORD-" + UUID.randomUUID());

        order.setCustomerId(request.customerId());
        order.setCustomerName(request.customerName());
        order.setCustomerEmail(request.customerEmail());
        order.setCustomerPhone(request.customerPhone());
        order.setShippingAddress(request.shippingAddress());

        order.setProductId(request.productId());
        order.setProductName(request.productName());

        order.setQuantity(request.quantity());
        order.setUnitPrice(request.unitPrice());
        order.setTotalAmount(totalAmount);

        order.setPaymentMethod(request.paymentMethod());
        order.setPaymentStatus("PENDING");
        order.setOrderStatus("PLACED");

        // 5. Save the order in PostgreSQL.
        Order savedOrder = orderRepository.save(order);

        return mapToResponse(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found: " + id
                ));

        return mapToResponse(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getOrdersByCustomerId(Long customerId) {

        return orderRepository.findByCustomerId(customerId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrderResponse mapToResponse(Order order) {

        return new OrderResponse(
                order.getId(),
                order.getOrderNumber(),
                order.getCustomerId(),
                order.getCustomerName(),
                order.getCustomerEmail(),
                order.getCustomerPhone(),
                order.getShippingAddress(),
                order.getProductId(),
                order.getProductName(),
                order.getQuantity(),
                order.getUnitPrice(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getPaymentStatus(),
                order.getPaymentReference(),
                order.getOrderStatus(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}