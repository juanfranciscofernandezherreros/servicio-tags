package com.fernandez.categorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernandez.categorias.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	
	@Query(value = "SELECT * FROM categories WHERE parent_id = 0 ORDER BY category", nativeQuery = true)
	List<Categories> findAllParents();

	@Query(value = "SELECT * FROM categories WHERE parent_id != ?1 ORDER BY category", nativeQuery = true)
	List<Categories> findAllChildsByParentId(Long parentId);
}
