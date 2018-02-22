package com.totvs.agridatagenerator.framework.utils;

public abstract class StringUtil {

	public static final String EMPTY = "";

	public static boolean isEmptyOrNull(String value) {
		return value == null || EMPTY.equals(value);
	}

	public static boolean isNotEmptyOrNull(String value) {
		return !StringUtil.isEmptyOrNull(value);
	}

}
