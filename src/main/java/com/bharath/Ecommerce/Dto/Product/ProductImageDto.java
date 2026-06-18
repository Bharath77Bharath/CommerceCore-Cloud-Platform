package com.bharath.Ecommerce.Dto.Product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDto {

    private Long product_id;
    private String url;
    private String publicId;

}
