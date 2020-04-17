package com.fernandez.categorias.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fernandez.categorias.adapter.CategoriesAdapter;
import com.fernandez.categorias.repository.CategoriesTranslationRepository;
import com.fernandez.categorias.repository.CategoryRepository;
import com.fernandez.categories.consumer.CategoryDTO;
import com.fernandez.entities.common.model.CategoryTranslation;
import com.fernandez.entities.common.model.Language;
import com.fernandez.languages.consumer.LanguageConsumer;

@Service
public class CategoriesService {
	
	Logger logger = LoggerFactory.getLogger(CategoriesService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoriesTranslationRepository categoriesRepository;
	
	@Autowired
	private CategoriesAdapter categoriesAdapter;
	
	public List<CategoryDTO> retreiveAll(String iso2Language) {
		LanguageConsumer languageConsumer = new LanguageConsumer();
		logger.debug("Llamada al servicio de idiomas");
		Language language = languageConsumer.obtenerIdiomaPorIso2(iso2Language);
		logger.debug("Fin llamada al servicio de idiomas --- : " + language );
		List<CategoryTranslation> categoriesTranslation = categoriesRepository.findByLanguageId(language.getId());		
		logger.debug("Lista de categorias traducidas --- : " + categoriesTranslation );
		return categoriesAdapter.convertList2DTO(categoriesTranslation);
	}
	
	public CategoryDTO findById(Long categoryId,String languageId) {
		logger.debug("CategoriesService - findById :" + categoryId + "languageId" + languageId);
		LanguageConsumer languageConsumer = new LanguageConsumer();
		logger.debug("Llamada al servicio de idiomas");
		Language language = languageConsumer.obtenerIdiomaPorIso2(languageId);
		logger.debug("Fin llamada al servicio de idiomas --- : " + language );
		CategoryTranslation categoryTranslation = categoriesRepository.findByLanguageIdAndCategoryId(language.getId(),categoryId);
		logger.debug("EndCategoriesService - findById :" + categoryTranslation);
		return categoriesAdapter.category2DTO(categoryTranslation);
	}
	
	public Page<CategoryTranslation> retreiveAllPaginated(String iso2Language,Pageable pageable) {
		LanguageConsumer languageConsumer = new LanguageConsumer();
		logger.debug("Llamada al servicio de idiomas");
		Language language = languageConsumer.obtenerIdiomaPorIso2(iso2Language);
		logger.debug("Fin llamada al servicio de idiomas --- : " + language );
		Page<CategoryTranslation> categoriesTranslation = categoriesRepository.findByLanguageId(language.getId(),pageable);
		logger.debug("Lista de categorias traducidas paginadas --- : " + categoriesTranslation );
		return categoriesTranslation;
	}

}
