package com.fernandez.categorias.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.entities.common.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	@Query(value = "SELECT count(*) FROM blogs_category WHERE blogs_category.category_id=?1 AND blogs_category.language_id=?2", nativeQuery = true)
	Integer countTotalArticlesByCategory(Long categoryId , Long languageId);
}
