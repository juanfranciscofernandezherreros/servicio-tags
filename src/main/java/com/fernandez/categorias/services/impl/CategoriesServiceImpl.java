package com.fernandez.categorias.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernandez.categorias.adapter.CategoriasAdapter;
import com.fernandez.categorias.dto.CategoryDTO;
import com.fernandez.categorias.model.Categories;
import com.fernandez.categorias.model.CategoryTranslation;
import com.fernandez.categorias.repository.CategoriesRepository;
import com.fernandez.categorias.repository.CategoriesTranslationRepository;
import com.fernandez.categorias.repository.CategoryRepository;
import com.fernandez.categorias.services.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoriesTranslationRepository categoriesRepository;

	@Autowired
	private CategoriasAdapter categoriasAdapter;

	@Autowired
	private CategoriesRepository categorieRepository;

	@Override
	public List<CategoryDTO> retreiveAll(Long languageId) {
		List<CategoryTranslation> categoriesTranslation = categoriesRepository.findAllByLanguageId(languageId);
		List<CategoryDTO> categoryList = categoriesTranslation.stream().map(x -> category2DTOWithTotal(x, languageId))
				.collect(Collectors.toList());
		return categoryList;
	}

	private CategoryDTO category2DTOWithTotal(CategoryTranslation ct, Long languageId) {
		CategoryDTO categoryDTO = categoriasAdapter.category2DTO(ct);
		categoryDTO.setTotal(categoryRepository.countTotalArticlesByCategory(categoryDTO.getCategoryId(), languageId));
		return categoryDTO;

	}

	@Override
	public CategoryDTO findById(Long categoryId, Long languageId) {
		logger.debug("CategoriesService - findById :" + categoryId + "languageId" + languageId);
		CategoryTranslation categoryTranslation = categoriesRepository
				.findByLanguageIdAndCategoryId(Long.valueOf(languageId), categoryId);
		logger.debug("EndCategoriesService - findById :" + categoryTranslation);
		CategoryDTO categoryDTO = categoriasAdapter.category2DTO(categoryTranslation);
		categoryDTO.setTotal(categoryRepository.countTotalArticlesByCategory(categoryTranslation.getCategoryId(),
				categoryTranslation.getLanguageId()));
		return categoryDTO;
	}

	@Override
	public List<Categories> retreiveAllCategories() {
		Long parent= (long) 0 ;
		List<Categories> categories = new ArrayList<Categories>();
		List<Categories> findAllParents = categorieRepository.findAllParents();
		generateTree(findAllParents,parent);
		return categories;
	}


	private void generateTree(List<Categories> categories,Long parent) {
		
		
		for (Categories category : categories) {
			System.out.println("Parent" + category);		
			List<Categories> childs = categorieRepository.findAllChildsByParentId(Long.valueOf(category.getParentId()));	
			System.out.println("Child" + childs);
			generateTree(childs, category.getParentId());	
			break;
		}			

		

	}

	public CategoryTranslation findCategoryTranslation(Long categoryIdTranslation) {
		return categoriesRepository.findById(categoryIdTranslation).get();
	}

	

}
