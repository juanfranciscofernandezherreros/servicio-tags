package com.fernandez.tags.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.tags.model.Language;
import com.fernandez.tags.model.TagsTranslation;

@Repository
public interface TagsTranslationRepository extends PagingAndSortingRepository<TagsTranslation, Long> {

	@Query(value="SELECT * FROM TagsTranslation t WHERE t.language_id=?1 ORDER BY RAND() LIMIT 15", nativeQuery = true)
	public List<TagsTranslation> findAllByLanguage(Language language);
}
