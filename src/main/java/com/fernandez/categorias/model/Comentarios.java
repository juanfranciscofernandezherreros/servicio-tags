package com.fernandez.categorias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comentarios")
public class Comentarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contenido;
	
	private Long blogTranslationId;
	
	private Long userId;

	private boolean isRespuesta;
	
	private Long comentarioIdRespuesta;

	private Long userIdRespuesta;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogTranslationId == null) ? 0 : blogTranslationId.hashCode());
		result = prime * result + ((comentarioIdRespuesta == null) ? 0 : comentarioIdRespuesta.hashCode());
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isRespuesta ? 1231 : 1237);
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userIdRespuesta == null) ? 0 : userIdRespuesta.hashCode());
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
		Comentarios other = (Comentarios) obj;
		if (blogTranslationId == null) {
			if (other.blogTranslationId != null)
				return false;
		} else if (!blogTranslationId.equals(other.blogTranslationId))
			return false;
		if (comentarioIdRespuesta == null) {
			if (other.comentarioIdRespuesta != null)
				return false;
		} else if (!comentarioIdRespuesta.equals(other.comentarioIdRespuesta))
			return false;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isRespuesta != other.isRespuesta)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userIdRespuesta == null) {
			if (other.userIdRespuesta != null)
				return false;
		} else if (!userIdRespuesta.equals(other.userIdRespuesta))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Long getBlogTranslationId() {
		return blogTranslationId;
	}

	public void setBlogTranslationId(Long blogTranslationId) {
		this.blogTranslationId = blogTranslationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isRespuesta() {
		return isRespuesta;
	}

	public void setRespuesta(boolean isRespuesta) {
		this.isRespuesta = isRespuesta;
	}

	public Long getComentarioIdRespuesta() {
		return comentarioIdRespuesta;
	}

	public void setComentarioIdRespuesta(Long comentarioIdRespuesta) {
		this.comentarioIdRespuesta = comentarioIdRespuesta;
	}

	public Long getUserIdRespuesta() {
		return userIdRespuesta;
	}

	public void setUserIdRespuesta(Long userIdRespuesta) {
		this.userIdRespuesta = userIdRespuesta;
	}

	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", contenido=" + contenido + ", blogTranslationId=" + blogTranslationId
				+ ", userId=" + userId + ", isRespuesta=" + isRespuesta + ", comentarioIdRespuesta="
				+ comentarioIdRespuesta + ", userIdRespuesta=" + userIdRespuesta + "]";
	}
	
	
	
	
}
