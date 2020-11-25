package com.fernandez.categorias.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.categorias.controller.CategoriasController;
import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.services.CategoriesService;

@RestController
public class CategoriesControllerImpl implements CategoriasController {

	@Autowired
	private CategoriesService categoriesService;

	@Override
	public ResponseEntity<Page<CategoryDTO>> findAllCategories(@RequestHeader("accept-language") String acceptLanguage , Pageable pageable) {
		Page<CategoryDTO> listBlogs = categoriesService.findAll(acceptLanguage, pageable);
		return ResponseEntity.ok(listBlogs);
	}

	@Override
	public ResponseEntity<CategoryDTO> findById(@PathVariable("categoryTranslationId") Long categoryTranslationId) {
		CategoryDTO categoryDTO = categoriesService.findById(categoryTranslationId);
		return ResponseEntity.ok(categoryDTO);

	}

}
