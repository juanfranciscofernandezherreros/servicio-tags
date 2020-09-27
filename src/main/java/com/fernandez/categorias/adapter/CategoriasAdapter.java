package com.fernandez.categorias.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.model.CategoryTranslation;

@Component
public class CategoriasAdapter {
	
	Logger logger = LoggerFactory.getLogger(CategoriasAdapter.class);
	
	public List<CategoryDTO> convertList2DTO(List<CategoryTranslation> categoriesTranslation) {

		logger.debug("Start CategoriasAdapter - convertList2DTO");

		List<CategoryDTO> categoriesList = new ArrayList<CategoryDTO>();
		for (CategoryTranslation categoryTranslation : categoriesTranslation) {
			CategoryDTO categoryDTO = category2DTO(categoryTranslation);
			categoriesList.add(categoryDTO);
		}
		
		logger.debug("End CategoriasAdapter - convertList2DTO");

		return categoriesList;
	}

	public CategoryDTO category2DTO(CategoryTranslation categoryTranslation) {

		logger.debug("Start CategoriasAdapter - category2DTO" + categoryTranslation);

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryTranslation.getId());
		categoryDTO.setNameCategoryTranslated(categoryTranslation.getNameCategoryTranslated());
		categoryDTO.setCategoryId(categoryTranslation.getCategoryId());
		categoryDTO.setLanguageId(categoryTranslation.getLanguageId());
		logger.debug("End CategoriasAdapter - category2DTO" + categoryDTO);

		return categoryDTO;
	}

	public Page<CategoryDTO> convert2Page(Page<CategoryTranslation> categoriesTranslation) {
		logger.debug("Start CategoriasAdapter - convert2Page");
		List<CategoryDTO> categoriesList = new ArrayList<CategoryDTO>();
		for (CategoryTranslation categoryTranslation : categoriesTranslation) {
			categoriesList.add(category2DTO(categoryTranslation));
		}
		Page<CategoryDTO> page = new PageImpl<>(categoriesList);
		logger.debug("Start CategoriasAdapter - convert2Page");
		return page;
	}

}
