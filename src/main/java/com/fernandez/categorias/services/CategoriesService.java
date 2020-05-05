package com.fernandez.categorias.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fernandez.blogs.consumer.BlogDTO;
import com.fernandez.blogs.consumer.BlogsFeignClient;
import com.fernandez.categorias.adapter.CategoriesAdapter;
import com.fernandez.categorias.repository.CategoriesTranslationRepository;
import com.fernandez.categorias.repository.CategoryRepository;
import com.fernandez.categories.consumer.CategoryDTO;
import com.fernandez.entities.common.model.BlogsCategory;
import com.fernandez.entities.common.model.BlogsTranslation;
import com.fernandez.entities.common.model.Category;
import com.fernandez.entities.common.model.CategoryTranslation;
import com.fernandez.entities.common.model.Language;
import com.fernandez.languages.consumer.LanguageFeignClient;

@Service
public class CategoriesService {
	
	Logger logger = LoggerFactory.getLogger(CategoriesService.class);
	
	@Autowired
	private LanguageFeignClient languageConsumer;
	
	@Autowired
	private CategoryRepository categoryRepository;	
	
	@Autowired
	private CategoriesTranslationRepository categoriesRepository;
	
	@Autowired
	private CategoriesAdapter categoriesAdapter;

	@Autowired
	private BlogsFeignClient blogsFeignClient;
	
	public List<CategoryDTO> retreiveAll(String iso2Language) {
		logger.debug("Llamada al servicio de idiomas");
		Language language = languageConsumer.obtenerIdiomaPorIso2(iso2Language);
		logger.debug("Fin llamada al servicio de idiomas --- : " + language );
		List<CategoryTranslation> categoriesTranslation = categoriesRepository.findByLanguageId(language.getId());		
		logger.debug("Lista de categorias traducidas --- : " + categoriesTranslation );
		List<CategoryDTO> categoryListDTO =  categoriesAdapter.convertList2DTO(categoriesTranslation);		
		return categoryListDTO;
	}
	
	public CategoryDTO findById(Long categoryId,String languageId) {
		logger.debug("CategoriesService - findById :" + categoryId + "languageId" + languageId);
		logger.debug("Llamada al servicio de idiomas");
		Language language = languageConsumer.obtenerIdiomaPorIso2(languageId);
		logger.debug("Fin llamada al servicio de idiomas --- : " + language );
		CategoryTranslation categoryTranslation = categoriesRepository.findByLanguageIdAndCategoryId(language.getId(),categoryId);
		logger.debug("EndCategoriesService - findById :" + categoryTranslation);
		CategoryDTO categoryDTO =  categoriesAdapter.category2DTO(categoryTranslation);
		categoryDTO.setTotal(categoryRepository.countTotalArticlesByCategory(categoryTranslation.getCategoryId(),categoryTranslation.getLanguageId()));
		return categoryDTO;
	}
	
	public List<BlogDTO> blogsDTOFilteredByCategory(String language,Long categoryId){	
		Language languages = languageConsumer.obtenerIdiomaPorIso2(language);
		CategoryTranslation categoryTranslationRepository = categoriesRepository.findByLanguageIdAndCategoryId(languages.getId(),categoryId);
		Optional<Category> category = categoryRepository.findById(categoryTranslationRepository.getCategoryId());
		List<BlogDTO>  blogsDtoList = new ArrayList<BlogDTO>();
		if(category.isPresent()) {
			blogsDtoList = blogsFeignClient.buscarBlogsPorCategoria(language, categoryId);
		}
		return blogsDtoList;
	}
	
	public Page<CategoryTranslation> retreiveAllPaginated(String iso2Language,Pageable pageable) {
		logger.debug("Llamada al servicio de idiomas");
		Language language = languageConsumer.obtenerIdiomaPorIso2(iso2Language);
		logger.debug("Fin llamada al servicio de idiomas --- : " + language );
		Page<CategoryTranslation> categoriesTranslation = categoriesRepository.findByLanguageId(language.getId(),pageable);
		logger.debug("Lista de categorias traducidas paginadas --- : " + categoriesTranslation );
		return categoriesTranslation;
	}

}
