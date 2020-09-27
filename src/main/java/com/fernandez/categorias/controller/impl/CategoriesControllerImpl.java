package com.fernandez.categorias.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.categorias.controller.CategoriasController;
import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.model.Categories;
import com.fernandez.categorias.services.CategoriesService;
import com.fernandez.categorias.services.ListToPageService;

@RestController
public class CategoriesControllerImpl implements CategoriasController {

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private ListToPageService listToPageService;

	@Override
	public ResponseEntity<Page<CategoryDTO>> findAllCategorias(@PathVariable("languageId") String languageId,
			Pageable pageable) {

		List<CategoryDTO> imagesList = new ArrayList<CategoryDTO>();

		imagesList = categoriesService.retreiveAll(Long.valueOf(languageId));

		return ResponseEntity.ok(listToPageService.convertList2Page(imagesList, pageable));

	}

	@Override
	public ResponseEntity<CategoryDTO> findById(@PathVariable("languageId") String languageId,
			@PathVariable("categoryId") Long categoryId) {

		CategoryDTO categoryDTO = categoriesService.findById(categoryId, Long.valueOf(languageId));

		return ResponseEntity.ok(categoryDTO);

	}

}
