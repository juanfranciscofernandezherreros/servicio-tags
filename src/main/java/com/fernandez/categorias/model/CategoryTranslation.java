package com.fernandez.categorias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorytranslation")
public class CategoryTranslation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String nameCategoryTranslated;
  
  @Column(name = "language_id")
  private Long languageId;
  
  private Long categoryId;
  
  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = 31 * result + ((this.categoryId == null) ? 0 : this.categoryId.hashCode());
    result = 31 * result + ((this.id == null) ? 0 : this.id.hashCode());
    result = 31 * result + ((this.languageId == null) ? 0 : this.languageId.hashCode());
    result = 31 * result + ((this.nameCategoryTranslated == null) ? 0 : this.nameCategoryTranslated.hashCode());
    return result;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    CategoryTranslation other = (CategoryTranslation)obj;
    if (this.categoryId == null) {
      if (other.categoryId != null)
        return false; 
    } else if (!this.categoryId.equals(other.categoryId)) {
      return false;
    } 
    if (this.id == null) {
      if (other.id != null)
        return false; 
    } else if (!this.id.equals(other.id)) {
      return false;
    } 
    if (this.languageId == null) {
      if (other.languageId != null)
        return false; 
    } else if (!this.languageId.equals(other.languageId)) {
      return false;
    } 
    if (this.nameCategoryTranslated == null) {
      if (other.nameCategoryTranslated != null)
        return false; 
    } else if (!this.nameCategoryTranslated.equals(other.nameCategoryTranslated)) {
      return false;
    } 
    return true;
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getNameCategoryTranslated() {
    return this.nameCategoryTranslated;
  }
  
  public void setNameCategoryTranslated(String nameCategoryTranslated) {
    this.nameCategoryTranslated = nameCategoryTranslated;
  }
  
  public Long getLanguageId() {
    return this.languageId;
  }
  
  public void setLanguageId(Long languageId) {
    this.languageId = languageId;
  }
  
  public Long getCategoryId() {
    return this.categoryId;
  }
  
  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

@Override
public String toString() {
	return "CategoryTranslation [id=" + id + ", nameCategoryTranslated=" + nameCategoryTranslated + ", languageId="
			+ languageId + ", categoryId=" + categoryId + "]";
}
  
  
}
