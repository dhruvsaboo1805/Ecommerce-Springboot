package com.example.ecommerce_spring.services;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.dto.CategoryWithProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
      List<CategoryDTO> getAllCategories() throws IOException;
      CategoryDTO createCategory(CategoryDTO categoryDTO);
      CategoryDTO getByName(String name) throws Exception;
      List<CategoryWithProductDTO> getCategoryWithProduct(Long id) throws Exception;
}
