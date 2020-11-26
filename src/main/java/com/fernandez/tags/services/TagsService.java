package com.fernandez.tags.services;

import java.util.List;

import com.fernandez.tags.dto.TagsDTO;

public interface TagsService {

	List<TagsDTO> findAll(String acceptLanguage);

}
