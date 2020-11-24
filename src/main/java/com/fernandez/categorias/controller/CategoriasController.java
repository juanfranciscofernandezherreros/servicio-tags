package com.fernandez.categorias.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fernandez.categorias.dto.CategoryDTO;

public interface CategoriasController {
	
	@GetMapping(value = "/public/v1")
	ResponseEntity<Page<CategoryDTO>> findAllCategories(@RequestHeader("accept-language") String acceptLanguage , Pageable pageable);

	@GetMapping(value = "/public/v1/categoryTranslation/{categoryTranslationId}")
	ResponseEntity<CategoryDTO> findById(@PathVariable("categoryTranslationId") Long categoryTranslationId);
	
}
