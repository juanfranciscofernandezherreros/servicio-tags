package com.fernandez.tags.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fernandez.tags.dto.TagsDTO;


public interface TagsController {
	
	@GetMapping(value = "/public/v1")
	ResponseEntity<Page<TagsDTO>> findAllTags(@RequestHeader("accept-language") String acceptLanguage,@PageableDefault(page=0, size=5) Pageable pageable);
	
}
