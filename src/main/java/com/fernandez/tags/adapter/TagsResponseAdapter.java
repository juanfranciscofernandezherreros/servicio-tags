package com.fernandez.tags.adapter;

import java.util.ArrayList;
import java.util.List;

import com.fernandez.tags.dto.TagsDTO;
import com.fernandez.tags.model.TagsTranslation;


public class TagsResponseAdapter {

	public static List<TagsDTO> mapToTagsDTO(List<TagsTranslation> tagsTranslationList) {
		List<TagsDTO> categoriesDTO = new ArrayList<TagsDTO>();
		for (TagsTranslation tagsTranslation : tagsTranslationList) {
			categoriesDTO.add(mapToTagDTO(tagsTranslation));
		}
		return categoriesDTO;
	}

	public static TagsDTO mapToTagDTO(TagsTranslation tagsTranslation) {
		TagsDTO tagDTO = new TagsDTO();
		tagDTO.setId(tagsTranslation.getTags().getId());
		tagDTO.setClave(tagsTranslation.getTags().getClave());
		tagDTO.setTagsTranslationId(tagsTranslation.getId());
		tagDTO.setNameTagsTranslated(tagsTranslation.getNameTagsTranslated());
		return tagDTO;
	}
}
