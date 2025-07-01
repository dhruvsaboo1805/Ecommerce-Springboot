package com.example.ecommerce_spring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FakeStoreProductDTO {
    private String status;
    private String message;
    private ProductDTO products;
}
