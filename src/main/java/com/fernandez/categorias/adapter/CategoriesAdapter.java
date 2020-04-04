package com.fernandez.categorias.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fernandez.categorias.common.model.CategoryTranslation;
import com.fernandez.categorias.dto.CategoryDTO;

@Component
public class CategoriesAdapter {

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

	private CategoryDTO category2DTO(CategoryTranslation categoryTranslation) {
		
		logger.debug("Start CategoriesAdapter - category2DTO" + categoryTranslation);
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryTranslation.getId());
		categoryDTO.setNameCategory(categoryTranslation.getNameCategoryTranslated());
		categoryDTO.setCategoryId(categoryTranslation.getCategoryId());
		logger.debug("End CategoriesAdapter - category2DTO" + categoryDTO);
		
		return categoryDTO;
	}

}
