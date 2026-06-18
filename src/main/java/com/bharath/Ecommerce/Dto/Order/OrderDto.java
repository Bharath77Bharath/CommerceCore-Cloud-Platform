package com.bharath.Ecommerce.Dto.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private List<OrderItemDto> orderItems;
    private Double totalItemsAmount;
    private Double taxAmount;
    private Double totalAmount;
    private String status;
    private String referenceNo;

}
