package com.fernandez.categorias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categorytranslation")
public class CategoryTranslation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nameCategoryTranslated;

	@OneToOne
	@JoinColumn(name = "language_id", referencedColumnName = "id")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "category_translation")
	private Category category;

	public CategoryTranslation() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((nameCategoryTranslated == null) ? 0 : nameCategoryTranslated.hashCode());
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
		CategoryTranslation other = (CategoryTranslation) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (nameCategoryTranslated == null) {
			if (other.nameCategoryTranslated != null)
				return false;
		} else if (!nameCategoryTranslated.equals(other.nameCategoryTranslated))
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

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryTranslation [id=" + id + ", nameCategoryTranslated=" + nameCategoryTranslated + ", language="
				+ language + ", category=" + category + "]";
	}

}
