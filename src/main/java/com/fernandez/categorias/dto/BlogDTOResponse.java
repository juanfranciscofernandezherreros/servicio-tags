package com.fernandez.categorias.dto;

import java.util.ArrayList;

public class BlogDTOResponse {

	private Long id;
	
	private String title;

	private String descripcionArticulo;

	private String content;

	private Long blogsId;

	private Long languageId;

	private String image;

	private String createDate;

	private String updateDate;

	private Long userId;

	private String urlSeo;
	
	private String username;
	
	private ArrayList<CategoryDTO>  categoriesList ;
	
	private Long totalComentarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getBlogsId() {
		return blogsId;
	}

	public void setBlogsId(Long blogsId) {
		this.blogsId = blogsId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUrlSeo() {
		return urlSeo;
	}

	public void setUrlSeo(String urlSeo) {
		this.urlSeo = urlSeo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<CategoryDTO> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(ArrayList<CategoryDTO> categoriesList) {
		this.categoriesList = categoriesList;
	}

	public Long getTotalComentarios() {
		return totalComentarios;
	}

	public void setTotalComentarios(Long totalComentarios) {
		this.totalComentarios = totalComentarios;
	}

	@Override
	public String toString() {
		return "BlogDTOResponse [id=" + id + ", title=" + title + ", descripcionArticulo=" + descripcionArticulo
				+ ", content=" + content + ", blogsId=" + blogsId + ", languageId=" + languageId + ", image=" + image
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", userId=" + userId + ", urlSeo="
				+ urlSeo + ", username=" + username + ", categoriesList=" + categoriesList + ", totalComentarios="
				+ totalComentarios + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getDescripcionArticulo()=" + getDescripcionArticulo() + ", getContent()=" + getContent()
				+ ", getBlogsId()=" + getBlogsId() + ", getLanguageId()=" + getLanguageId() + ", getImage()="
				+ getImage() + ", getCreateDate()=" + getCreateDate() + ", getUpdateDate()=" + getUpdateDate()
				+ ", getUserId()=" + getUserId() + ", getUrlSeo()=" + getUrlSeo() + ", getUsername()=" + getUsername()
				+ ", getCategoriesList()=" + getCategoriesList() + ", getTotalComentarios()=" + getTotalComentarios()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

		
}
