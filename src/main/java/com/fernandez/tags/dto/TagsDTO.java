package com.fernandez.tags.dto;

public class TagsDTO {

	private Long id;
	private Long tagsTranslationId;
	private String clave;
	private String nameTagsTranslated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTagsTranslationId() {
		return tagsTranslationId;
	}

	public void setTagsTranslationId(Long tagsTranslationId) {
		this.tagsTranslationId = tagsTranslationId;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNameTagsTranslated() {
		return nameTagsTranslated;
	}

	public void setNameTagsTranslated(String nameTagsTranslated) {
		this.nameTagsTranslated = nameTagsTranslated;
	}

	@Override
	public String toString() {
		return "TagsDTO [id=" + id + ", tagsTranslationId=" + tagsTranslationId + ", clave=" + clave
				+ ", nameTagsTranslated=" + nameTagsTranslated + "]";
	}

}
