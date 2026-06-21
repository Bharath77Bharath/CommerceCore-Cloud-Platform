package com.bharath.Ecommerce.Repository;

import com.bharath.Ecommerce.Entity.Order;
import com.bharath.Ecommerce.Entity.Users;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {


    Optional<Order> findByReferenceNo(String referenceNo);

    List<Order> findByUser(Users user);

    Optional<Order> findByIdAndUser(Long id, Users user);
}
