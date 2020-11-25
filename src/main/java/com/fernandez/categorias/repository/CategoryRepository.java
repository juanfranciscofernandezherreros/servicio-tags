package com.fernandez.categorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernandez.categorias.model.Category;
import com.fernandez.categorias.model.CategoryTranslation;
import com.fernandez.categorias.model.Language;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value = "SELECT count(*) FROM blogs_categories WHERE blogs_categories.category_id=?1 AND blogs_categories.language_id=?2", nativeQuery = true)
	Integer countTotalArticlesByCategory(CategoryTranslation category , Language language);
}
