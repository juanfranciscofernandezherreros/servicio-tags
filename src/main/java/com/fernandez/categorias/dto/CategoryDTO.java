package com.fernandez.categorias.dto;

public class CategoryDTO {

	private Long id;
	private String nameCategoryTranslated;
	private Integer total;
	private Long categoryId;
	private Long languageId;
	private String clave;
	private boolean hasCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCategoryTranslated() {
		return nameCategoryTranslated;
	}

	public void setNameCategoryTranslated(String nameCategoryTranslated) {
		this.nameCategoryTranslated = nameCategoryTranslated;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isHasCategory() {
		return hasCategory;
	}

	public void setHasCategory(boolean hasCategory) {
		this.hasCategory = hasCategory;
	}

	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", nameCategoryTranslated=" + nameCategoryTranslated + ", total=" + total
				+ ", categoryId=" + categoryId + ", languageId=" + languageId + ", clave=" + clave + ", hasCategory="
				+ hasCategory + "]";
	}

}
