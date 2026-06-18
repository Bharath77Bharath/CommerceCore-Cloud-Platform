package com.bharath.Ecommerce.Service;


import com.bharath.Ecommerce.Dto.Order.CreateOrderDto;
import com.bharath.Ecommerce.Dto.Order.OrderSummaryDto;
import com.bharath.Ecommerce.Dto.Order.OrderDto;
import com.bharath.Ecommerce.Dto.Order.OrderItemDto;
import com.bharath.Ecommerce.Entity.Order;
import com.bharath.Ecommerce.Entity.OrderItem;
import com.bharath.Ecommerce.Entity.Product;
import com.bharath.Ecommerce.Repository.OrderRepository;
import com.bharath.Ecommerce.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setTotalItemsAmount(order.getTotalItemsAmount());
        orderDto.setTaxAmount(order.getTaxAmount());
        orderDto.setTotalAmount(order.getTotalAmount());
        orderDto.setStatus(order.getStatus());
        orderDto.setReferenceNo(order.getReferenceNo());

        List<OrderItemDto> itemDtos =
                order.getOrderItems()
                        .stream()
                        .map(item -> new OrderItemDto(
                                item.getName(),
                                item.getQuantity(),
                                item.getImage(),
                                item.getPrice(),
                                item.getProduct().getId()
                        ))
                        .toList();
        orderDto.setOrderItems(itemDtos);

        return orderDto;
    }

    public OrderSummaryDto createOrder(CreateOrderDto createOrderDto) {
        Order order = new Order();

        double totalItemsAmount = 0;

        for(OrderItemDto itemDto : createOrderDto.getOrderItemDto()) {
            OrderItem orderItem = new OrderItem();

            orderItem.setName(itemDto.getName());
            orderItem.setImage(itemDto.getImage());
            orderItem.setPrice(itemDto.getPrice());
            orderItem.setQuantity(itemDto.getQuantity());

            Product product = productRepository.findById(itemDto.getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));

            orderItem.setProduct(product);

            totalItemsAmount += itemDto.getPrice() * itemDto.getQuantity();

            orderItem.setOrder(order);
            orderItem.setProduct(product);

            order.getOrderItems().add(orderItem);

        }

        String status = "PENDING";
        double taxAmount = 100;
        double totalAmount = taxAmount + totalItemsAmount;

        order.setStatus(status);
        order.setTaxAmount(taxAmount);
        order.setTotalItemsAmount(totalItemsAmount);
        order.setTotalAmount(totalAmount);
        String referenceNO = UUID.randomUUID().toString();
        order.setReferenceNo(referenceNO);

        orderRepository.save(order);

        return new OrderSummaryDto(referenceNO);
    }

    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

        return convertToDto(order);
    }

    public OrderDto getOrderByReferenceNo(String referenceNo) {
        Order order = orderRepository.findByReferenceNo(referenceNo).orElseThrow(() -> new RuntimeException("Order not found"));

        return convertToDto(order);
    }

}
