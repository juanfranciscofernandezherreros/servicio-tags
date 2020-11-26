package com.fernandez.tags.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tagstranslation")
public class TagsTranslation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nameTagsTranslated;

	@OneToOne
	@JoinColumn(name = "language_id", referencedColumnName = "id")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "tags_id")
	private Tags tags;

	@OneToMany(mappedBy = "tags", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<TagsTranslation> tagsTranslation;

	public TagsTranslation() {
	}

	public TagsTranslation(String nameTagsTranslated, Language language, Tags tags) {
		super();
		this.nameTagsTranslated = nameTagsTranslated;
		this.language = language;
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((nameTagsTranslated == null) ? 0 : nameTagsTranslated.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		TagsTranslation other = (TagsTranslation) obj;
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
		if (nameTagsTranslated == null) {
			if (other.nameTagsTranslated != null)
				return false;
		} else if (!nameTagsTranslated.equals(other.nameTagsTranslated))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameTagsTranslated() {
		return nameTagsTranslated;
	}

	public void setNameTagsTranslated(String nameTagsTranslated) {
		this.nameTagsTranslated = nameTagsTranslated;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}
	
	

	@Override
	public String toString() {
		return "TagsTranslation [id=" + id + ", nameTagsTranslated=" + nameTagsTranslated + ", language=" + language
				+ ", tags=" + tags + "]";
	}

}
