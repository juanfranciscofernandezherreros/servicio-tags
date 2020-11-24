package com.fernandez.categorias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.categorias.model.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

	Language findByIso2(String acceptLanguage);

	boolean existsByIso2(String language);

}
