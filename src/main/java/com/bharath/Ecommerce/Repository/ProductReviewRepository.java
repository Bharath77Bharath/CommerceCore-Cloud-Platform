package com.bharath.Ecommerce.Repository;

import com.bharath.Ecommerce.Entity.Product;
import com.bharath.Ecommerce.Entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    List<ProductReview> findByProduct(Product product);
}
