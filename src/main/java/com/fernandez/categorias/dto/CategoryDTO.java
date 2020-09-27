 package com.fernandez.categorias.dto;

public class CategoryDTO {

	private Long id;
	private String nameCategoryTranslated;
	private Integer total;
	private Long categoryId;
	private Long languageId;
	private String clave;
	private boolean hasCategory;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + (hasCategory ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((languageId == null) ? 0 : languageId.hashCode());
		result = prime * result + ((nameCategoryTranslated == null) ? 0 : nameCategoryTranslated.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDTO other = (CategoryDTO) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (hasCategory != other.hasCategory)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		if (nameCategoryTranslated == null) {
			if (other.nameCategoryTranslated != null)
				return false;
		} else if (!nameCategoryTranslated.equals(other.nameCategoryTranslated))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
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
