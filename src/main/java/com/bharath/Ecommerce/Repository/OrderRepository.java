package com.bharath.Ecommerce.Repository;

import com.bharath.Ecommerce.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {


    Optional<Order> findByReferenceNo(String referenceNo);
}
