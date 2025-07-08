package com.example.ecommerce_spring.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Category extends BaseEntity{
    private String name;
}
