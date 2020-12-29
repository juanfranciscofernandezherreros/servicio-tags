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

	private String slug;

	@OneToMany(mappedBy = "tags", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<TagsTranslation> tagsTranslation;

	public TagsTranslation() {
		super();
	}

	public TagsTranslation(Long id, String nameTagsTranslated,
			Language language, Tags tags, String slug,
			List<TagsTranslation> tagsTranslation) {
		super();
		this.id = id;
		this.nameTagsTranslated = nameTagsTranslated;
		this.language = language;
		this.tags = tags;
		this.slug = slug;
		this.tagsTranslation = tagsTranslation;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<TagsTranslation> getTagsTranslation() {
		return tagsTranslation;
	}

	public void setTagsTranslation(List<TagsTranslation> tagsTranslation) {
		this.tagsTranslation = tagsTranslation;
	}

	@Override
	public String toString() {
		return "TagsTranslation [id=" + id + ", nameTagsTranslated="
				+ nameTagsTranslated + ", language=" + language + ", tags="
				+ tags + ", slug=" + slug + ", tagsTranslation="
				+ tagsTranslation + "]";
	}

}
