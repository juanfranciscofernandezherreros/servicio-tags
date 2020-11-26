package com.fernandez.tags.services.impl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<TagsDTO> findAll(String acceptLanguage) {		
		Language language = languageRepository.findByIso2(acceptLanguage.toLowerCase());
		List<TagsTranslation> tagsTranslationList = tagsTranslationRepository.findAllByLanguage(language);
		List<TagsTranslation> copy = new ArrayList<>(tagsTranslationList);
		List<TagsDTO> tagsDtoList = TagsResponseAdapter.mapToTagsDTO(tagsTranslationList);
		return tagsDtoList;
	}

}
