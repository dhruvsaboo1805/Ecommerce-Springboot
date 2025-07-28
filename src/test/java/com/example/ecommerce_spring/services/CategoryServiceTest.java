package com.example.ecommerce_spring.services;


import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.entity.Category;
import com.example.ecommerce_spring.repository.ICategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService_DB categoryServiceDb;

    @Test
    @DisplayName("Should create a new category successfully")
    void createCategory_shouldCreateCategoryAndTest() {

        // arrange
        Category category = Category.builder().name("Electronics").build();
        category.setId(1L);

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // act
        CategoryDTO result = categoryServiceDb.createCategory( new CategoryDTO());

        // assert
        assertEquals("Electronics", result.getName());
        verify(categoryRepository, times(1)).save(any(Category.class));

    }

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldGiveAllTheCategories() throws IOException {
        //arrange
        List<Category> categories = new ArrayList<>();
        Category cat1 = Category.builder().name("Electronics").build();
        cat1.setId(1L);
        Category cat2 = Category.builder().name("Books").build();
        cat2.setId(2L);

        categories.add(cat1);
        categories.add(cat2);

        when(categoryRepository.findAll()).thenReturn(categories);

        //act
        List<CategoryDTO> result = categoryServiceDb.getAllCategories();

        //assert
        assertEquals(2 , result.size());
        verify(categoryRepository, times(1)).findAll();

    }

    @Test
    void deleteCategory_shouldDeleteCategoryById() throws Exception {

        Long cattId = 1L;
        Category category = Category.builder().name("Electronics").build();
        when(categoryRepository.findById(cattId)).thenReturn(Optional.of(category));

        //act
        CategoryDTO result = categoryServiceDb.deleteCategory(cattId);

        //assert
        assertEquals("Electronics" , result.getName());

    }
}
