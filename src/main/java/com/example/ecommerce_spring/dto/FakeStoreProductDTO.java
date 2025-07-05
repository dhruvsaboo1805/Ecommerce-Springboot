package com.example.ecommerce_spring.dto;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FakeStoreProductDTO {
    @SerializedName("product")
    private ProductDTO products;
    private String status;
    private String message;
}
