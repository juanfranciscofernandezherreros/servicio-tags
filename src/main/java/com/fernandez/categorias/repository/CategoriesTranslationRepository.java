package com.fernandez.categorias.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.categorias.model.CategoryTranslation;

@Repository
public interface CategoriesTranslationRepository extends CrudRepository<CategoryTranslation, Long> {
	
	public CategoryTranslation findByLanguageIdAndCategoryId(Long categoryId, Long languageId);

	public List<CategoryTranslation> findAllByLanguageId(Long languageId);
}
