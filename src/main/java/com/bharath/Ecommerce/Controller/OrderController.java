package com.bharath.Ecommerce.Controller;


import com.bharath.Ecommerce.Dto.Order.CreateOrderDto;
import com.bharath.Ecommerce.Dto.Order.OrderSummaryDto;
import com.bharath.Ecommerce.Dto.Order.OrderDto;
import com.bharath.Ecommerce.Entity.Order;
import com.bharath.Ecommerce.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderSummaryDto> createOrder(@RequestBody CreateOrderDto createOrderDto) {
        OrderSummaryDto orderSummaryDto = orderService.createOrder(createOrderDto);

        return new ResponseEntity<>(orderSummaryDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto orderDto = orderService.getOrderById(id);

        return new ResponseEntity<>(orderDto,HttpStatus.OK);
    }

    @GetMapping("/referenceNo/{referenceNo}")
    public ResponseEntity<OrderDto> getOrderByReferenceNo(@PathVariable String referenceNo) {
        OrderDto orderDto = orderService.getOrderByReferenceNo(referenceNo);

        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping("/my-orders")
    public ResponseEntity<List<OrderDto>> getMyOrders() {
        List<OrderDto> orderDtos = orderService.getMyOrders();

        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();

        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/getpage")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> getAllOrders(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Map<String, Object> orderPage = orderService.getAllOrders(page, size);

        return new ResponseEntity<>(orderPage, HttpStatus.OK);
    }

}
