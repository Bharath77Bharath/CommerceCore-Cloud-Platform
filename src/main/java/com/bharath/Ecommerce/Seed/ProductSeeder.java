package com.bharath.Ecommerce.Seed;

import com.bharath.Ecommerce.Entity.Product;
import com.bharath.Ecommerce.Entity.ProductImage;
import com.bharath.Ecommerce.Entity.ProductReview;
import com.bharath.Ecommerce.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String @NonNull ... args) throws Exception {

        if(productRepository.count() == 0) {
            List<Product> demoProducts = List.of(

                    new Product(
                            null,
                            "iPhone 16 Pro",
                            129999.0,
                            "Apple flagship smartphone with A18 Pro chip and advanced camera system.",
                            "Phone",
                            4.8,
                            "Apple Store",
                            50,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "iphone-16-pro",
                                            "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Amazing camera quality and battery life.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "Samsung Galaxy S25 Ultra",
                            119999.0,
                            "Premium Android smartphone with AI features and powerful camera.",
                            "Phone",
                            4.7,
                            "Samsung Store",
                            40,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "s25-ultra",
                                            "https://images.unsplash.com/photo-1598327105666-5b89351aff97?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Excellent display and AI features.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )

                    ),

                    new Product(
                            null,
                            "MacBook Air M4",
                            109999.0,
                            "Lightweight laptop powered by Apple's M4 chip.",
                            "Laptop",
                            4.9,
                            "Apple Store",
                            25,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "macbook-air-m4",
                                            "https://images.unsplash.com/photo-1517336714739-489689fd1ca8?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Super fast and lightweight laptop.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "Dell XPS 15",
                            149999.0,
                            "High-performance laptop for professionals and developers.",
                            "Laptop",
                            4.6,
                            "Dell Official",
                            15,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "dell-xps-15",
                                            "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            4.0,
                                            "Great performance for development work.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "Sony WH-1000XM5",
                            29999.0,
                            "Industry-leading noise cancelling wireless headphones.",
                            "headphone",
                            4.8,
                            "Sony Store",
                            100,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "sony-wh1000xm5",
                                            "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Best noise cancellation I've used.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "Logitech MX Master 3S",
                            8999.0,
                            "Premium wireless productivity mouse.",
                            "Mouse",
                            4.7,
                            "Logitech",
                            120,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "mx-master-3s",
                                            "https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Perfect mouse for productivity.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "Apple Watch Series 10",
                            49999.0,
                            "Smartwatch with advanced health and fitness tracking.",
                            "Watch",
                            4.7,
                            "Apple Store",
                            60,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "apple-watch-series-10",
                                            "https://images.unsplash.com/photo-1434494878577-86c23bcb06b9?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Excellent fitness and health tracking.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "Samsung 55 Inch QLED TV",
                            79999.0,
                            "4K QLED Smart TV with vibrant colors and AI upscaling.",
                            "TV",
                            4.5,
                            "Samsung Store",
                            20,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "samsung-qled-tv",
                                            "https://images.unsplash.com/photo-1593784991095-a205069470b6?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            4.0,
                                            "Beautiful colors and picture quality.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "Kindle Paperwhite",
                            14999.0,
                            "E-reader with glare-free display and weeks of battery life.",
                            "E-reader",
                            4.8,
                            "Amazon",
                            80,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "kindle-paperwhite",
                                            "https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Fantastic reading experience.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    ),

                    new Product(
                            null,
                            "PlayStation 5",
                            54990.0,
                            "Next-generation gaming console with ultra-fast SSD.",
                            "Gaming",
                            4.9,
                            "Sony Store",
                            30,
                            1,
                            List.of(
                                    new ProductImage(
                                            null,
                                            "playstation-5",
                                            "https://images.unsplash.com/photo-1606813907291-d86efa9b94db?w=1200&auto=format&fit=crop",
                                            null
                                    )
                            ),
                            List.of(
                                    new ProductReview(
                                            null,
                                            5.0,
                                            "Amazing gaming performance and exclusives.",
                                            null,
                                            null,
                                            "Demo User"
                                    )
                            )
                    )
            );

            productRepository.saveAll(demoProducts);
            System.out.println("Seeded Demo Products!");
        } else {
            System.out.println("Products already exists, Skipping seed");
        }
    }
}
