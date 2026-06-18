package com.bharath.Ecommerce.Service;

import com.bharath.Ecommerce.Dto.Product.CreateProductDto;
import com.bharath.Ecommerce.Dto.Product.ProductDto;
import com.bharath.Ecommerce.Dto.Product.ProductImageDto;
import com.bharath.Ecommerce.Dto.Product.ProductReviewDto;
import com.bharath.Ecommerce.Entity.Product;
import com.bharath.Ecommerce.Entity.ProductImage;
import com.bharath.Ecommerce.Entity.ProductReview;
import com.bharath.Ecommerce.Repository.ProductImageRepository;
import com.bharath.Ecommerce.Repository.ProductRepository;
import com.bharath.Ecommerce.Repository.ProductReviewRepository;
import com.bharath.Ecommerce.Specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;
    private final ProductReviewRepository productReviewRepository;
    private final ProductImageRepository productImageRepository;



    private ProductDto convertToDto(Product product) {
        ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setRatings(product.getRatings());
        dto.setSeller(product.getSeller());
        dto.setStock(product.getStock());
        dto.setNumOfReviews(product.getNumOfReviews());

        List<ProductImageDto> imageDtos = product.getImages()
                .stream()
                .map(image -> new ProductImageDto(
                        image.getProduct().getId(),
                        image.getPublicId(),
                        image.getUrl()
                ))
                .toList();
        dto.setImages(imageDtos);

        List<ProductReviewDto> productReviewDtos = product.getReviews()
                .stream()
                .map(productReview -> new ProductReviewDto(
                        productReview.getProduct().getId(),
                        productReview.getComment(),
                        productReview.getRating ()
                ))
                .toList();
        dto.setReviews(productReviewDtos);

        return dto;
    }

    //Read
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
    //Pagination Read
    public Map<String, Object> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductDto> productDtos = productPage.getContent()
                .stream()
                .map(this::convertToDto)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("Products", productDtos);
        response.put("TotalProducts", productPage.getTotalElements());

        return response;
    }

    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));

        return convertToDto(product);
    }

    public List<ProductDto> searchProducts(String category, Double minPrice, Double maxPrice, String keyword, Double ratings) {
        Specification<Product> specification = Specification.where(ProductSpecification.hasCategory(category))
                        .and(ProductSpecification.priceBetween(minPrice,maxPrice)
                        .and(ProductSpecification.hasNameOrDescription(keyword))
                        .and(ProductSpecification.ratingsGreaterThan(ratings)));

        return productRepository.findAll(specification)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public ProductDto createProduct(CreateProductDto createProductDto) {
        Product product = new Product();

        product.setName(createProductDto.getName());
        product.setPrice(createProductDto.getPrice());
        product.setDescription(createProductDto.getDescription());
        product.setCategory(createProductDto.getCategory());
        product.setSeller(createProductDto.getSeller());
        product.setStock(createProductDto.getStock());

        Product savedProduct = productRepository.save(product);

        return convertToDto(savedProduct);
    }

        public ProductDto updateProduct(Long id, CreateProductDto updatedProductDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(updatedProductDto.getName());
        product.setPrice(updatedProductDto.getPrice());
        product.setDescription(updatedProductDto.getDescription());
        product.setCategory(updatedProductDto.getCategory());
        product.setSeller(updatedProductDto.getSeller());
        product.setStock(updatedProductDto.getStock());

        Product updatedProduct = productRepository.save(product);

        return convertToDto(updatedProduct);
    }

    public void deleteProduct(Long id) {
        Product deleteProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(deleteProduct);
    }

    public ProductDto addReview(ProductReviewDto productReviewDto) {
        Product product = productRepository.findById(productReviewDto.getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));

        ProductReview productReview = new ProductReview();

        productReview.setComment(productReviewDto.getComment());
        productReview.setRating(productReviewDto.getRating());

        productReview.setProduct(product);

        productReviewRepository.save(productReview);


       List<ProductReview> reviews = productReviewRepository.findByProduct(product);

       product.setNumOfReviews(reviews.size());
       double averageRating = reviews
               .stream()
               .mapToDouble(ProductReview::getRating)
               .average()
               .orElse(0.0);
       product.setRatings(averageRating);

       Product savedProduct = productRepository.save(product);

       return convertToDto(savedProduct);

    }

    public ProductDto addImage(ProductImageDto productImageDto) {
        Product product = productRepository
                .findById(productImageDto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductImage productImage = new ProductImage();

        productImage.setPublicId(productImageDto.getPublicId());
        productImage.setUrl(productImageDto.getUrl());

        productImage.setProduct(product);

        productImageRepository.save(productImage);

        Product updatedProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));

        return convertToDto(updatedProduct);

    }

}
