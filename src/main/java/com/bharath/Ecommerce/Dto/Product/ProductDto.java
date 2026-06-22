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
    private String name;
    private Double price;
    private String description;
    private String category;
    private Double ratings = 0.0;
    private String seller;
    private Integer stock;
    private Integer numOfReviews = 0;
    private List<ProductImageDto> images;
    private List<ProductReviewDto> reviews;
}
