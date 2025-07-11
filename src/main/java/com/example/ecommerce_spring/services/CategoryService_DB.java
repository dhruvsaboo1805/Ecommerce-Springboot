package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.entity.Category;
import com.example.ecommerce_spring.mapper.CategoryMapper;
import com.example.ecommerce_spring.repository.ICategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CategoryService_DB implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    public CategoryService_DB(ICategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dtos = new ArrayList<>();
        for(Category cat : categoryRepository.findAll()) {
            dtos.add(CategoryMapper.todto(cat));
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category cat = CategoryMapper.toEntity(categoryDTO);
        Category saved = categoryRepository.save(cat);
        return CategoryMapper.todto(saved);
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new Exception("Category with given name not found" + name));
        return CategoryMapper.todto(category);
    }
}
