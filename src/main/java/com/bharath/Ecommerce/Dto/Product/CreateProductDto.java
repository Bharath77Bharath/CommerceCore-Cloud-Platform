package com.bharath.Ecommerce.Dto.Product;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    @NotBlank(message = "Product name is required ")
    private String name;
    @NotNull
    private Double price;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank
    private String category;
    @NotBlank
    private String seller;
    @NotNull
    private Integer stock;

}
