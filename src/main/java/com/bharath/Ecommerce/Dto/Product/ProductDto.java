package com.bharath.Ecommerce.Dto.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;


    @NotBlank(message = "Name field is required")
    private String name;


    @NotNull(message = "Price field is required")
    @PositiveOrZero(message = "Value must be zero or greater than zero")
    private Double price;

    @NotBlank(message = "Description field is required")
    private String description;

    private String category;

    private Double ratings = 0.0;

    @NotBlank(message = "Seller is required")
    private String seller;

    @NotNull(message = "Stock field is required")
    private Integer stock;

    private Integer numOfReviews = 0;


    private List<ProductImageDto> images;


    private List<ProductReviewDto> reviews;
}
