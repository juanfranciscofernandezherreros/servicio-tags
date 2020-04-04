package com.fernandez.categorias.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.services.CategoriesService;

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

}
