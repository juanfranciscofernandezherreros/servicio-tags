package com.fernandez.tags.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.tags.model.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

	Language findByIso2(String acceptLanguage);

	boolean existsByIso2(String language);

}
