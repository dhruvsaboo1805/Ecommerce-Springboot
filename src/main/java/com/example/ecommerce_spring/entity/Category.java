package com.example.ecommerce_spring.entity;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Product> products;
}
