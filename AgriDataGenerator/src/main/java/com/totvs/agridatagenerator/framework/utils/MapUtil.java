package com.totvs.agridatagenerator.framework.utils;

import java.util.Map;

public abstract class MapUtil {

	public static boolean isNullOrEmpty(Map<?, ?> value) {
		return value == null || value.isEmpty();
	}

	public static boolean isNotNullOrEmpty(Map<?, ?> value) {
		return !MapUtil.isNullOrEmpty(value);
	}

}
