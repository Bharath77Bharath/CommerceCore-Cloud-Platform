package com.bharath.Ecommerce.Dto.Product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    private String name;
    private Double price;
    private String description;
    private String category;
    private String seller;
    private Integer stock;

}
