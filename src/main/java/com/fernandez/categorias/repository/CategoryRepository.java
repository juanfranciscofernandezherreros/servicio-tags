package com.fernandez.categorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernandez.categorias.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value = "SELECT count(*) FROM blogs_category WHERE blogs_category.category_id=?1 AND blogs_category.language_id=?2", nativeQuery = true)
	Integer countTotalArticlesByCategory(Long categoryId , Long languageId);
}
