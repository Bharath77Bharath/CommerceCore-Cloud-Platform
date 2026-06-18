package com.bharath.Ecommerce.Controller;


import com.bharath.Ecommerce.Dto.Order.CreateOrderDto;
import com.bharath.Ecommerce.Dto.Order.OrderSummaryDto;
import com.bharath.Ecommerce.Dto.Order.OrderDto;
import com.bharath.Ecommerce.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
