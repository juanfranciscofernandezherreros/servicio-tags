package com.fernandez.categorias.services.impl;

import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fernandez.categorias.adapter.CategoriesAdapter;
import com.fernandez.categorias.constants.ErrorsConstant;
import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.exception.CategoriesNotFoundException;
import com.fernandez.categorias.model.CategoryTranslation;
import com.fernandez.categorias.model.Language;
import com.fernandez.categorias.repository.CategoryRepository;
import com.fernandez.categorias.repository.CategoryTranslationRepository;
import com.fernandez.categorias.repository.LanguageRepository;
import com.fernandez.categorias.services.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);

	@Autowired
	private CategoryTranslationRepository categoryTranslationRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Page<CategoryDTO> retreiveAll(String acceptLanguage, Pageable pageable) {
		Page<CategoryDTO> dtoPage;
		Language language = languageRepository.findByIso2(acceptLanguage.toLowerCase());
		Page<CategoryTranslation> pageCategoryTranslation = categoryTranslationRepository.findAllByLanguage(language,pageable);
		dtoPage = mapToBlogTranslationResponseDTO(pageCategoryTranslation);
		return dtoPage;
	}

	@Override
	public CategoryDTO findById(Long categoryTranslationId) {
		CategoryDTO categoryDTO = new CategoryDTO();
		Optional<CategoryTranslation> categoryTranslation = categoryTranslationRepository.findById(categoryTranslationId);
		if (categoryTranslation.isPresent()) {
			categoryDTO = CategoriesAdapter.mapToBlogTranslationResponseDTO(categoryTranslation.get());
		}else {
			throw new CategoriesNotFoundException(ErrorsConstant.CATEGORYNOTFOUND,ErrorsConstant.MESSAGECATEGORYNOTFOUND + "[id=" + categoryTranslationId + "]");
		}
		return categoryDTO;
	}

	private Page<CategoryDTO> mapToBlogTranslationResponseDTO(Page<CategoryTranslation> blogsTranslation) {
		Page<CategoryDTO> dtoPage;
		dtoPage = blogsTranslation.map(new Function<CategoryTranslation, CategoryDTO>() {
			@Override
			public CategoryDTO apply(CategoryTranslation categoryTranslation) {
				CategoryDTO categoryDTO = CategoriesAdapter.mapToBlogTranslationResponseDTO(categoryTranslation);
				categoryDTO.setTotal(null);
				return categoryDTO;
			}
		});
		return dtoPage;
	}

}
