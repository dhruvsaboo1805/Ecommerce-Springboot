package com.example.ecommerce_spring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FakeStoreCategoryResponseDTO {
    private String status;
    private String message;
    private List<String> categories;

}
