package com.fernandez.categorias.services;

import java.util.List;

import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.model.Categories;

public interface CategoriesService {

	List<CategoryDTO> retreiveAll(Long languageId);

	CategoryDTO findById(Long categoryId, Long languageId);

	List<Categories> retreiveAllCategories();

}
