package com.fernandez.categorias.adapter;

import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.model.CategoryTranslation;

public class CategoriesAdapter {

	public static CategoryDTO mapToBlogTranslationResponseDTO(CategoryTranslation categoryTranslation) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryTranslation.getId());
		categoryDTO.setNameCategoryTranslated(categoryTranslation.getNameCategoryTranslated());
		categoryDTO.setCategoryId(categoryTranslation.getCategory().getId());
		categoryDTO.setLanguageId(categoryTranslation.getLanguage().getId());
		categoryDTO.setClave(categoryTranslation.getCategory().getClave());		
		return categoryDTO;
	}

}
