package com.bharath.Ecommerce.Controller;

import com.bharath.Ecommerce.Dto.Product.ProductDto;
import com.bharath.Ecommerce.Dto.Product.ProductImageDto;
import com.bharath.Ecommerce.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products/image")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addImage(@RequestBody ProductImageDto productImageDto) {
        ProductDto productDto = productService.addImage(productImageDto);

        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

}
