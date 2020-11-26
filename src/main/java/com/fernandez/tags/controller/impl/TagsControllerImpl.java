package com.fernandez.tags.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fernandez.tags.controller.TagsController;
import com.fernandez.tags.dto.TagsDTO;
import com.fernandez.tags.services.TagsService;

@RestController
public class TagsControllerImpl implements TagsController{
	
	@Autowired
	private TagsService tagsService;
	
	@Override
	public ResponseEntity<List<TagsDTO>> findAllTags(String acceptLanguage) {
		List<TagsDTO> listBlogs = tagsService.findAll(acceptLanguage);
		return ResponseEntity.ok(listBlogs);
	}

}
