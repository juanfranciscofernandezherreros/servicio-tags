package com.fernandez.categorias.exception;

public class CategoriesException extends RuntimeException {

	private static final long serialVersionUID = -3871307704776209630L;

	private final String errorCode;

	public CategoriesException(String errorCode, String msg) {
		this(errorCode, msg, null);
	}

	public CategoriesException(String errorCode, String msg, Throwable cause) {
		super(msg, cause);
		this.errorCode = errorCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
