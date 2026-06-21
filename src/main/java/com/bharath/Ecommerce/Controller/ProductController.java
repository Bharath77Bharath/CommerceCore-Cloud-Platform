package com.bharath.Ecommerce.Controller;

import com.bharath.Ecommerce.Dto.Product.CreateProductDto;
import com.bharath.Ecommerce.Dto.Product.ProductDto;
import com.bharath.Ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //Read
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
    //Pagination Read
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Map<String, Object> productPage = productService.getAllProducts(page, size);
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam(required = false) String category, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice, @RequestParam(required = false) String keyword, @RequestParam(required = false) Double ratings) {

        List<ProductDto> productList = productService.searchProducts(category, minPrice, maxPrice, keyword, ratings);

        return new ResponseEntity<>(productList, HttpStatus.OK);

    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody CreateProductDto createProductDto) {
        ProductDto createdProductDto = productService.createProduct(createProductDto);

        return new ResponseEntity<>(createdProductDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @PathVariable Long id,@RequestBody CreateProductDto updateProductDto) {
        ProductDto updatedProductDto = productService.updateProduct(id, updateProductDto);

        return new ResponseEntity<>(updatedProductDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

        return new ResponseEntity<>("Product deleted successfully",HttpStatus.OK);
    }
}
