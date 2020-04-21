package com.fernandez.categorias.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.fernandez.categorias.repository.CategoryRepository;
import com.fernandez.categories.consumer.CategoryDTO;
import com.fernandez.entities.common.model.CategoryTranslation;

@Component
public class CategoriesAdapter {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	Logger logger = LoggerFactory.getLogger(CategoriesAdapter.class);

	public List<CategoryDTO> convertList2DTO(List<CategoryTranslation> categoriesTranslation) {

		logger.debug("Start CategoriesAdapter - convertList2DTO");

		List<CategoryDTO> categoriesList = new ArrayList<CategoryDTO>();
		for (CategoryTranslation categoryTranslation : categoriesTranslation) {
			CategoryDTO categoryDTO = category2DTO(categoryTranslation);
			categoriesList.add(categoryDTO);
		}
		
		logger.debug("End CategoriesAdapter - convertList2DTO");

		return categoriesList;
	}

	public CategoryDTO category2DTO(CategoryTranslation categoryTranslation) {

		logger.debug("Start CategoriesAdapter - category2DTO" + categoryTranslation);

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryTranslation.getId());
		categoryDTO.setNameCategory(categoryTranslation.getNameCategoryTranslated());
		categoryDTO.setCategoryId(categoryTranslation.getCategoryId());
		categoryDTO.setTotal(categoryRepository.countTotalArticlesByCategory(categoryTranslation.getCategoryId(),categoryTranslation.getLanguageId()));
		logger.debug("End CategoriesAdapter - category2DTO" + categoryDTO);

		return categoryDTO;
	}

	public Page<CategoryDTO> convert2Page(Page<CategoryTranslation> categoriesTranslation) {
		logger.debug("Start CategoriesAdapter - convert2Page");
		List<CategoryDTO> categoriesList = new ArrayList<CategoryDTO>();
		for (CategoryTranslation categoryTranslation : categoriesTranslation) {
			categoriesList.add(category2DTO(categoryTranslation));
		}
		Page<CategoryDTO> page = new PageImpl<>(categoriesList);
		logger.debug("Start CategoriesAdapter - convert2Page");
		return page;
	}

}
