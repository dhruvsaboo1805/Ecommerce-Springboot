package com.example.ecommerce_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Category extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY)
    private List<Product> products;
}
