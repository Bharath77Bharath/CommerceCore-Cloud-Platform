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
public class ProductReviewDto {

    @NotNull(message = "Product ID is required")
    private Long product_id;

    private String reviewerName;

    @NotBlank(message = "Comment cannot by empty")
    private String comment;

    @NotNull(message = "Rating is required")
    private Double rating;

}
