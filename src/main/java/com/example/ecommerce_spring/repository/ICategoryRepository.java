package com.example.ecommerce_spring.repository;

import com.example.ecommerce_spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category , Long> {

}
