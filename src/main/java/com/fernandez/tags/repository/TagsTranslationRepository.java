package com.fernandez.tags.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fernandez.tags.model.Language;
import com.fernandez.tags.model.TagsTranslation;

@Repository
public interface TagsTranslationRepository extends PagingAndSortingRepository<TagsTranslation, Long> {

	public Page<TagsTranslation> findAllByLanguage(Language language,Pageable pageable);
}
