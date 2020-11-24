package com.fernandez.categorias.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.categorias.model.Category;
import com.fernandez.categorias.model.CategoryTranslation;
import com.fernandez.categorias.model.Language;

@Repository
public interface CategoryTranslationRepository extends PagingAndSortingRepository<CategoryTranslation, Long> {
	
	public CategoryTranslation findByLanguageAndCategory(Category category, Language language);

	public Page<CategoryTranslation> findAllByLanguage(Language language,Pageable pageable);
}
