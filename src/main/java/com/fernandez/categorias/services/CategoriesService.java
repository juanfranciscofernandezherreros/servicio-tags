package com.fernandez.categorias.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fernandez.categorias.dto.CategoryDTO;

public interface CategoriesService {


	CategoryDTO findById(Long categoryId);

	Page<CategoryDTO> findAll(String acceptLanguage, Pageable pageable);


}
