package com.fernandez.tags.utils;
public class LanguageUtils {

	public static Long convertFromHeaderToLong(String acceptLanguage) {
		Long languageId;
		switch (acceptLanguage) {
		case "es-es":
			languageId = 1l;
			break;
		case "fr-fr":
			languageId = 2l;
			break;
		default:
			throw new IllegalArgumentException("Invalid language  :  " + acceptLanguage);
		}
		return languageId;

	}

}