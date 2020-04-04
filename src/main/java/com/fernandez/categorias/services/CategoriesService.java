package com.fernandez.categorias.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandez.categorias.adapter.CategoriesAdapter;
import com.fernandez.categorias.common.model.CategoryTranslation;
import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.repository.CategoriesTranslationRepository;
import com.fernandez.languages.common.model.Language;
import com.fernandez.languages.consumer.LanguageConsumer;

@Service
public class CategoriesService {
	
	Logger logger = LoggerFactory.getLogger(CategoriesService.class);
	
	@Autowired
	private CategoriesTranslationRepository categoriesRepository;
	
	@Autowired
	private CategoriesAdapter languageAdapter;
	
	public List<CategoryDTO> retreiveAll(String iso2Language) {
		LanguageConsumer languageConsumer = new LanguageConsumer();
		logger.debug("Llamada al servicio de idiomas");
		Language language = languageConsumer.obtenerIdiomaPorIso2(iso2Language);
		logger.debug("Fin llamada al servicio de idiomas --- : " + language );
		List<CategoryTranslation> categoriesTranslation = categoriesRepository.findByLanguageId(language.getId());
		logger.debug("Lista de categorias traducidas --- : " + categoriesTranslation );
		return languageAdapter.convertList2DTO(categoriesTranslation);
	}

}
