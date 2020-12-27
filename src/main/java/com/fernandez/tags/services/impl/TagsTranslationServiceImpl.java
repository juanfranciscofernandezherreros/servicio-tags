package com.fernandez.tags.services.impl;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fernandez.tags.adapter.TagsResponseAdapter;
import com.fernandez.tags.dto.TagsDTO;
import com.fernandez.tags.model.Language;
import com.fernandez.tags.model.TagsTranslation;
import com.fernandez.tags.repository.LanguageRepository;
import com.fernandez.tags.repository.TagsTranslationRepository;
import com.fernandez.tags.services.TagsService;

@Service
public class TagsTranslationServiceImpl implements TagsService {

	Logger logger = LoggerFactory.getLogger(TagsTranslationServiceImpl.class);

	@Autowired
	private TagsTranslationRepository tagsTranslationRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Page<TagsDTO> findAll(String acceptLanguage,Pageable pageable) {
		Page<TagsDTO> dtoPage = null;
		Language language = languageRepository.findByIso2(acceptLanguage.toLowerCase());
		Page<TagsTranslation> pageTagsTranslations = tagsTranslationRepository.findAllByLanguage(language,pageable);
		dtoPage = mapToTagTranslationResponseDTO(pageTagsTranslations);			
		return dtoPage;
	}
	
	private Page<TagsDTO> mapToTagTranslationResponseDTO(Page<TagsTranslation> tagsTranslation) {
		Page<TagsDTO> dtoPage;
		dtoPage = tagsTranslation.map(new Function<TagsTranslation, TagsDTO>() {
			@Override
			public TagsDTO apply(TagsTranslation tagsTranslation) {
				TagsDTO tagsTranslationReponseDTO = TagsResponseAdapter.mapToTagDTO(tagsTranslation);
				return tagsTranslationReponseDTO;
			}
		});
		return dtoPage;
	}

}
