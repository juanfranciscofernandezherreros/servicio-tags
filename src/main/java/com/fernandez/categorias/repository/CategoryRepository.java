package com.fernandez.categorias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.entities.common.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
