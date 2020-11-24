package com.fernandez.categorias.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fernandez.categorias.dto.CategoryDTO;

public interface CategoriesService {

	Page<CategoryDTO> retreiveAll(String acceptLanguage,Pageable pageable);

	CategoryDTO findById(Long categoryId);


}
