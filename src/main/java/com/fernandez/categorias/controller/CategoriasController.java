package com.fernandez.categorias.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.model.Categories;

public interface CategoriasController {
	
	@GetMapping(value = "/public/v1/language/{languageId}")
	ResponseEntity<Page<CategoryDTO>> findAllCategorias(String languageId, Pageable pageable);

	@GetMapping(value = "/public/v1/category/{categoryId}/language/{languageId}")
	ResponseEntity<CategoryDTO> findById(String languageId, Long categoryId);
	
}
