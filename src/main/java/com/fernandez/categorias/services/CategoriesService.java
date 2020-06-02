package com.fernandez.categorias.services;

import java.util.List;

import com.fernandez.categories.consumer.CategoryDTO;

public interface CategoriesService {

	List<CategoryDTO> retreiveAll(Long languageId);

}
