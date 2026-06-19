package com.bharath.Ecommerce.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @GetMapping("/")
    public String home() {
        return """
                =====================================
                    Ecommerce API
                =====================================

                Welcome to the Ecommerce API.

                Available Endpoints:

                PRODUCTS
                GET    /api/products
                GET    /api/products/{id}
                GET    /api/products/search
                POST   /api/products
                PUT    /api/products/{id}
                DELETE /api/products/{id}

                REVIEWS
                GET    /api/reviews/product/{productId}
                POST   /api/reviews

                ORDERS
                POST   /api/orders
                GET    /api/orders/{id}
                GET    /api/orders

                SWAGGER DOCUMENTATION
                /swagger-ui/index.html

                Version: 1.0
                Developed by Bharath
                """;
    }

}
