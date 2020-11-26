package com.fernandez.tags.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fernandez.tags.dto.TagsDTO;


public interface TagsController {
	
	@GetMapping(value = "/public/v1")
	ResponseEntity<List<TagsDTO>> findAllTags(@RequestHeader("accept-language") String acceptLanguage);
	
}
