package com.fernandez.categorias.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandez.categorias.adapter.CategoriesAdapter;
import com.fernandez.categorias.repository.CategoriesTranslationRepository;
import com.fernandez.categorias.repository.CategoryRepository;
import com.fernandez.categorias.services.CategoriesService;
import com.fernandez.categories.consumer.CategoryDTO;
import com.fernandez.entities.common.model.CategoryTranslation;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoriesTranslationRepository categoriesRepository;

	@Autowired
	private CategoriesAdapter categoriesAdapter;

	public List<CategoryDTO> retreiveAll(Long languageId) {
		List<CategoryTranslation> categoriesTranslation = categoriesRepository.findByLanguageId(languageId);	
		List<CategoryDTO> categoryList = categoriesTranslation
		        .stream()
		        .map(x -> category2DTOWithTotal(x,languageId))                
		        .collect(Collectors.toList());
		return categoryList;
	}
	
	private CategoryDTO category2DTOWithTotal(CategoryTranslation ct,Long languageId) {
	    CategoryDTO categoryDTO = categoriesAdapter.category2DTO(ct);
	    categoryDTO.setTotal(categoryRepository.countTotalArticlesByCategory(categoryDTO.getCategoryId(),languageId)
	    );
	return categoryDTO;
	
	}

	/*
	 * public CategoryDTO findById(Long categoryId, String languageId) {
	 * logger.debug("CategoriesService - findById :" + categoryId + "languageId" +
	 * languageId); logger.debug("Llamada al servicio de idiomas"); Language
	 * language = languageConsumer.obtenerIdiomaPorIso2(languageId);
	 * logger.debug("Fin llamada al servicio de idiomas --- : " + language);
	 * CategoryTranslation categoryTranslation =
	 * categoriesRepository.findByLanguageIdAndCategoryId(language.getId(),
	 * categoryId); logger.debug("EndCategoriesService - findById :" +
	 * categoryTranslation); CategoryDTO categoryDTO =
	 * categoriesAdapter.category2DTO(categoryTranslation);
	 * categoryDTO.setTotal(categoryRepository.countTotalArticlesByCategory(
	 * categoryTranslation.getCategoryId(), categoryTranslation.getLanguageId()));
	 * return categoryDTO; }
	 * 
	 * public List<BlogDTO> blogsDTOFilteredByCategory(String language, Long
	 * categoryId) { Language languages =
	 * languageConsumer.obtenerIdiomaPorIso2(language); CategoryTranslation
	 * categoryTranslationRepository =
	 * categoriesRepository.findByLanguageIdAndCategoryId(languages.getId(),
	 * categoryId); Optional<Category> category =
	 * categoryRepository.findById(categoryTranslationRepository.getCategoryId());
	 * List<BlogDTO> blogsDtoList = new ArrayList<BlogDTO>(); if
	 * (category.isPresent()) { blogsDtoList =
	 * findBlog.findAllBlogsByCategory(language, categoryId).getBody(); } return
	 * blogsDtoList; }
	 */

	/*
	 * public Page<CategoryTranslation> retreiveAllPaginated(Long languageId,
	 * Pageable pageable) { Page<CategoryTranslation> categoriesTranslation =
	 * categoriesRepository.findByLanguageId(languageId,pageable);
	 * logger.debug("Lista de categorias traducidas paginadas --- : " +
	 * categoriesTranslation); return categoriesTranslation; }
	 */

	/*
	 * public List<CategoryDTO> checkIfBlogHasCategory(Long blogTranslationId) {
	 * BlogsTranslation blogTranslation =
	 * findBlog.retreiveBlogTranslationId(blogTranslationId).getBody(); Language
	 * language =
	 * languageConsumer.obtenerIdiomaPorIdentificador(blogTranslation.getLanguageId(
	 * )); BlogDTO blogs = findBlog.findBlogByBlogTranslationId(blogTranslationId,
	 * language.getIso2()).getBody(); List<CategoryTranslation>
	 * categoriesTranslation =
	 * categoriesRepository.findByLanguageId(blogTranslation.getLanguageId());
	 * logger.debug("Lista de categorias traducidas --- : " +
	 * categoriesTranslation); List<CategoryDTO> categoryListDTO =
	 * categoriesAdapter.convertList2DTO(categoriesTranslation); // Set
	 * Set<CategoryDTO> hSet = new HashSet<CategoryDTO>(); List<CategoryDTO>
	 * tmpListBlogCategory = new ArrayList<CategoryDTO>(); List<CategoryDTO>
	 * tmpListBlogCategory1 = new ArrayList<CategoryDTO>();
	 * 
	 * for (CategoryDTO categoryDTO : categoryListDTO) { categoryDTO.setTotal(null);
	 * tmpListBlogCategory.add(categoryDTO); } for (CategoryDTO categoryDTOList :
	 * blogs.getCategoriesListDTO()) { categoryDTOList.setTotal(null);
	 * tmpListBlogCategory1.add(categoryDTOList); } // Sort List by id
	 * 
	 * List<CategoryDTO> sortedList = tmpListBlogCategory.stream()
	 * .sorted(Comparator.comparingLong(CategoryDTO::getCategoryId)).collect(
	 * Collectors.toList()); sortedList.forEach(System.out::println);
	 * 
	 * List<CategoryDTO> sortedList1 = tmpListBlogCategory1.stream()
	 * .sorted(Comparator.comparingLong(CategoryDTO::getCategoryId)).collect(
	 * Collectors.toList()); sortedList1.forEach(System.out::println);
	 * 
	 * // Storing the comparison output in ArrayList<String> ArrayList<CategoryDTO>
	 * al3 = new ArrayList<CategoryDTO>(); for (CategoryDTO temp : sortedList) {
	 * if(sortedList1.contains(temp)) { CategoryDTO categoryDTO = new CategoryDTO();
	 * categoryDTO.setId(temp.getCategoryId());
	 * categoryDTO.setNameCategoryTranslated(temp.getNameCategoryTranslated());
	 * categoryDTO.setHasCategory(true); al3.add(categoryDTO); }else { CategoryDTO
	 * categoryDTO1 = new CategoryDTO(); categoryDTO1.setId(temp.getCategoryId());
	 * categoryDTO1.setNameCategoryTranslated(temp.getNameCategoryTranslated());
	 * categoryDTO1.setHasCategory(false); al3.add(categoryDTO1); } } return al3;
	 * 
	 * 
	 * }
	 * 
	 * public CategoryTranslation findCategoryTranslation(Long
	 * categoryIdTranslation) { return
	 * categoriesRepository.findById(categoryIdTranslation).get(); }
	 */

}
