package com.fernandez.tags.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tags implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clave;

	@OneToMany(mappedBy = "tags", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<TagsTranslation> tagsTranslation;

	public Tags() {
		super();
	}

	public Tags(String clave, List<TagsTranslation> tagsTranslation) {
		super();
		this.clave = clave;
		this.tagsTranslation = tagsTranslation;
	}

	public Tags(String clave) {
		super();
		this.clave = clave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tagsTranslation == null) ? 0 : tagsTranslation.hashCode());
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
		Tags other = (Tags) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tagsTranslation == null) {
			if (other.tagsTranslation != null)
				return false;
		} else if (!tagsTranslation.equals(other.tagsTranslation))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<TagsTranslation> getTagsTranslation() {
		return tagsTranslation;
	}

	public void setTagsTranslation(List<TagsTranslation> tagsTranslation) {
		this.tagsTranslation = tagsTranslation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Tags [id=" + id + ", clave=" + clave + ", tagsTranslation=" + tagsTranslation + "]";
	}

}
