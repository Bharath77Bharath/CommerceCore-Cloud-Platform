package com.bharath.Ecommerce.Controller;


import com.bharath.Ecommerce.Dto.Product.ProductDto;
import com.bharath.Ecommerce.Dto.Product.ProductReviewDto;
import com.bharath.Ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products/review")
@RequiredArgsConstructor
public class ProductReviewController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addReview(@RequestBody @Valid ProductReviewDto reviewDto) {
        ProductDto productDto = productService.addReview(reviewDto);

        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }
}
