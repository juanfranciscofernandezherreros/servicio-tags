package com.fernandez.categorias.controller.impl;

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
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.blogs.service.ListToPageService;
import com.fernandez.categorias.controller.CategoriesController;
import com.fernandez.categorias.services.CategoriesService;
import com.fernandez.categorias.services.impl.CategoriesServiceImpl;
import com.fernandez.categories.consumer.CategoryDTO;

@RestController
public class CategoriesControllerImpl implements CategoriesController {

	Logger logger = LoggerFactory.getLogger(CategoriesController.class);

	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private ListToPageService listToPageService;

	@Override
	public ResponseEntity<Page<CategoryDTO>> categories(String languageId , Pageable pageable)  {
	
		logger.debug("Start CategoriesController - categories");
		
		List<CategoryDTO> imagesList = new ArrayList<CategoryDTO>();
		
		imagesList = categoriesService.retreiveAll(Long.valueOf(languageId));
						
		logger.debug("End CategoriesController - categories");
		
		return ResponseEntity.ok(listToPageService.convertList2Page(imagesList, pageable));
	
	}	
	
	/*@GetMapping("/v1/translation/{categoryTranslationId}")
	public ResponseEntity<CategoryTranslation> categoryTranslation(@PathVariable("categoryTranslationId") Long categoryTranslationId) {
		
		logger.debug("Start CategoryTranslation");
				
		CategoryTranslation categoryTranslation = categoriesService.findCategoryTranslation(categoryTranslationId);
						
		logger.debug("End CategoryTranslation");
		
		return ResponseEntity.ok(categoryTranslation);	
	}

	
	@GetMapping(value = "/v1/{blogTranslationId}/articles")
	public ResponseEntity<List<CategoryDTO>> categoriesCheck(@PathVariable("blogTranslationId") Long blogTranslationId) {
		logger.debug("Start CategoriesController - categories");
				
		List<CategoryDTO> categoryListDTO = categoriesService.checkIfBlogHasCategory(blogTranslationId);
						
		logger.debug("End CategoriesController - categories");
		
		return ResponseEntity.ok(categoryListDTO);	
  
		
	}
	
	@GetMapping(value = "/v1/articles/{categoryId}")
	public ResponseEntity<List<BlogDTO>> findArticleByCategory(@RequestHeader("accept-language") String language,@PathVariable("categoryId") Long categoryId){
		
		logger.debug("Start CategoriesController - findArticleByCategory");
		
		List<BlogDTO> blogDTOList = new ArrayList<BlogDTO>();
		
		blogDTOList = categoriesService.blogsDTOFilteredByCategory(language,categoryId);
		
		logger.debug("End CategoriesController - findArticleByCategory");

		return ResponseEntity.ok(blogDTOList);	
	}
	
	@GetMapping(value = "/v1/{categoryId}")
	public ResponseEntity<CategoryDTO> findById(@RequestHeader("accept-language") String language,@PathVariable("categoryId") Long categoryId){
		
		logger.debug("Start CategoriesController - findById");

		CategoryDTO categoryDTO = categoriesService.findById(categoryId,language);		
		
		logger.debug("End CategoriesController - findById" + categoryDTO);
		
		return ResponseEntity.ok(categoryDTO);	

	}*/
	
	
	/*@GetMapping(value = "/v1")
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
	
	}	*/
	
}
