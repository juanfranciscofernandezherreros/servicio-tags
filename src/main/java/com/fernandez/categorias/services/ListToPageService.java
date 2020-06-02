package com.fernandez.categorias.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListToPageService {
	
	public Page convertList2Page(List list, Pageable pageable);

}
