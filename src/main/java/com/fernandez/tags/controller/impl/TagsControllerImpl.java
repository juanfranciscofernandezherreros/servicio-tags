package com.fernandez.tags.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.tags.controller.TagsController;
import com.fernandez.tags.dto.TagsDTO;
import com.fernandez.tags.services.TagsService;

@RestController
public class TagsControllerImpl implements TagsController{
	
	@Autowired
	private TagsService tagsService;
	
	@Override
	public ResponseEntity<Page<TagsDTO>> findAllTags(@RequestHeader("accept-language") String acceptLanguage,@PageableDefault(page = 0, size = 5) Pageable pageable) {
		Page<TagsDTO> listBlogs = tagsService.findAll(acceptLanguage,pageable);
		return ResponseEntity.ok(listBlogs);
	}

}
