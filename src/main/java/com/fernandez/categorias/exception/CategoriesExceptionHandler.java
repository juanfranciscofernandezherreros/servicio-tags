package com.fernandez.categorias.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fernandez.categorias.constants.ErrorsConstant;
import com.fernandez.categorias.dto.CategoriesApiErrorDto;

@ControllerAdvice
public class CategoriesExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ CategoriesNotFoundException.class })
	public ResponseEntity<CategoriesApiErrorDto> blogTranslationUrlNotFound(final CategoriesNotFoundException ex) {
		final CategoriesApiErrorDto apiError = new CategoriesApiErrorDto(HttpStatus.NOT_FOUND,
				ErrorsConstant.CATEGORYNOTFOUND, ex.getLocalizedMessage());
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
