package com.fernandez.categorias.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.fernandez.entities.common.model.CategoryTranslation;

@Repository
public interface CategoriesTranslationRepository extends CrudRepository<CategoryTranslation, Long> {

	public List<CategoryTranslation> findByLanguageId(long idLanguage);
	
	public Page<CategoryTranslation> findByLanguageId(long idLanguage,Pageable pageable);

	public CategoryTranslation findByLanguageIdAndCategoryId(Long categoryId, Long languageId);
}
