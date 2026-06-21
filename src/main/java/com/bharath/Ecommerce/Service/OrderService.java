package com.bharath.Ecommerce.Service;


import com.bharath.Ecommerce.Dto.Order.CreateOrderDto;
import com.bharath.Ecommerce.Dto.Order.OrderSummaryDto;
import com.bharath.Ecommerce.Dto.Order.OrderDto;
import com.bharath.Ecommerce.Dto.Order.OrderItemDto;
import com.bharath.Ecommerce.Dto.Product.ProductDto;
import com.bharath.Ecommerce.Entity.Order;
import com.bharath.Ecommerce.Entity.OrderItem;
import com.bharath.Ecommerce.Entity.Product;
import com.bharath.Ecommerce.Entity.Users;
import com.bharath.Ecommerce.Repository.OrderRepository;
import com.bharath.Ecommerce.Repository.ProductRepository;
import com.bharath.Ecommerce.Repository.UserRepository;
import com.bharath.Ecommerce.Security.CustomUserDetails;
import com.bharath.Ecommerce.Security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setCustomerEmail(order.getCustomerEmail());
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

    private Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        return userDetails.getUser();
    }

    private boolean isAdmin(Users user) {
        return user.getRole() == Role.ADMIN;
    }

    public OrderSummaryDto createOrder(CreateOrderDto createOrderDto) {
        Order order = new Order();

        Users currentUser = getCurrentUser();

        order.setUser(getCurrentUser());
        order.setCustomerName(currentUser.getName());
        order.setCustomerEmail(currentUser.getEmail());

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

        return new OrderSummaryDto(
                currentUser.getName(),
                currentUser.getEmail(),
                referenceNO,
                "Order placed Successfully"
        );
    }

    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

        Users currentUser = getCurrentUser();
        if(!isAdmin(currentUser) && !order.getUser().getId().equals(currentUser.getId())) {
            throw  new RuntimeException("Access Denied");
        }

        return convertToDto(order);
    }

    public OrderDto getOrderByReferenceNo(String referenceNo) {
        Order order = orderRepository.findByReferenceNo(referenceNo).orElseThrow(() -> new RuntimeException("Order not found"));

        Users currentUser = getCurrentUser();
        if(!isAdmin(currentUser) &&      !order.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Access Denied");
        }

        return convertToDto(order);
    }

    public List<OrderDto> getMyOrders() {
        Users currentUser = getCurrentUser();

        List<Order> orders = orderRepository.findByUser(currentUser);

        return orders.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orders =  orderRepository.findAll();

        return orders.stream()
                .map(this::convertToDto)
                .toList();
    }

    public Map<String, Object> getAllOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> productPage = orderRepository.findAll(pageable);

        List<OrderDto> orderDtos = productPage.getContent()
                .stream()
                .map(this::convertToDto)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("Orders", orderDtos);
        response.put("TotalOrders", productPage.getTotalElements());

        return response;
    }

}
