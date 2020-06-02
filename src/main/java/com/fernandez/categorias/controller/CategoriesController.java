package com.fernandez.categorias.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fernandez.categories.consumer.CategoryDTO;

public interface CategoriesController {

	@GetMapping(value = "/public/v1/language/{languageId}")
	ResponseEntity<Page<CategoryDTO>> categories(@PathVariable("languageId") String languageId,Pageable pageable);

}
