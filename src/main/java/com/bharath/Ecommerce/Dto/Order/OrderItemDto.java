package com.bharath.Ecommerce.Dto.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private String name;
    private Integer quantity;
    private String image;
    private Double price;
    private Long product_id;

}
