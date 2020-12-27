package com.fernandez.tags.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fernandez.tags.dto.TagsDTO;

public interface TagsService {

	Page<TagsDTO> findAll(String acceptLanguage,Pageable pageable);

}
