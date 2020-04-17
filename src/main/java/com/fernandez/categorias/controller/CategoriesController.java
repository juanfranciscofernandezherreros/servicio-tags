package com.fernandez.categorias.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.categorias.services.CategoriesService;
import com.fernandez.categories.consumer.CategoryDTO;
import com.fernandez.entities.common.model.CategoryTranslation;

@RestController
public class CategoriesController {
	
	Logger logger = LoggerFactory.getLogger(CategoriesController.class);

	@Autowired
	private CategoriesService categoriesService;

	@GetMapping(value = "/v1")
	public ResponseEntity<List<CategoryDTO>> categories(@RequestHeader("accept-language") String language) throws URISyntaxException {
	
		logger.debug("Start CategoriesController - categories");
		
		List<CategoryDTO> imagesList = new ArrayList<CategoryDTO>();
		
		if(language!=null) {
			imagesList = categoriesService.retreiveAll(language);
		}else {
			imagesList = categoriesService.retreiveAll("es-ES");
		}
		
		logger.debug("End CategoriesController - categories");
		
		return ResponseEntity.ok(imagesList);	
	
	}	
	
	@GetMapping(value = "/v1/{categoryId}")
	public ResponseEntity<CategoryDTO> findById(@RequestHeader("accept-language") String language,@PathVariable("categoryId") Long categoryId){
		
		logger.debug("Start CategoriesController - findById");

		CategoryDTO categoryDTO = categoriesService.findById(categoryId,language);		
		
		logger.debug("End CategoriesController - findById" + categoryDTO);
		
		return ResponseEntity.ok(categoryDTO);	

	}
	
	
	@GetMapping(value = "/v2")
	public ResponseEntity<Page<CategoryTranslation>> categoriesPaginated(@RequestHeader("accept-language") String language , Pageable pageable) throws URISyntaxException {
	
		logger.debug("Start CategoriesController - categoriesPaginated");
		
		Page<CategoryTranslation> categoriesTranslationList = null;

		if(language!=null) {
			categoriesTranslationList = categoriesService.retreiveAllPaginated(language,pageable);
		}else {
			categoriesTranslationList = categoriesService.retreiveAllPaginated("es-ES",pageable);
		}

		logger.debug("End CategoriesController - categoriesPaginated");
		
		return ResponseEntity.ok(categoriesTranslationList);	
	
	}	

}
