package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.dto.CategoryWithProductDTO;
import com.example.ecommerce_spring.dto.ProductDTO;
import com.example.ecommerce_spring.entity.Category;
import com.example.ecommerce_spring.entity.Product;
import com.example.ecommerce_spring.mapper.CategoryMapper;
import com.example.ecommerce_spring.mapper.ProductMapper;
import com.example.ecommerce_spring.repository.ICategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class CategoryService_DB implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    public CategoryService_DB(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category cat : categoryRepository.findAll()) {
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

        // just trying to debugging by print statements
        System.out.println("Looking for category name: " + name);

        Optional<Category> optionalCategory = categoryRepository.findByName(name);

        System.out.println("Found? " + optionalCategory.isPresent());

        Category category = optionalCategory
                .orElseThrow(() -> new Exception("Category with given name not found " + name));

        return CategoryMapper.todto(category);
    }

    @Override
    public List<CategoryWithProductDTO> getCategoryWithProduct(Long id) throws Exception {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("category not found with passed id = " + id));

        List<ProductDTO> productDTOs = category.getProducts()
                .stream()
                .map(ProductMapper::todto)
                .toList();

        return Collections.singletonList(CategoryMapper.tocategoryWithProductDTO(category, productDTOs));

    }

    @Override
    public CategoryDTO deleteCategory(Long id) throws Exception {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Category id not found " + id));

        categoryRepository.delete(category);
        return CategoryMapper.todto(category);
    }
}
