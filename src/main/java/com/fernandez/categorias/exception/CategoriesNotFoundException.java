package com.fernandez.categorias.exception;

import com.fernandez.categorias.constants.ErrorsConstant;

public class CategoriesNotFoundException extends CategoriesException {

    private static final long serialVersionUID = -3871307704776209630L;

    public CategoriesNotFoundException(String msg) {
        this(ErrorsConstant.CATEGORYNOTFOUND, msg);
    }
    
    public CategoriesNotFoundException(String errorCode, String msg) {
        this(errorCode, msg, null);
    }

    public CategoriesNotFoundException(String errorCode, String msg, Throwable cause) {
        super(errorCode, msg, cause);
    }
}

