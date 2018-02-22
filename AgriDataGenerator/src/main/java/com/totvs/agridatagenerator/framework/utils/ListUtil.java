package com.totvs.agridatagenerator.framework.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class ListUtil {

	public static boolean isNullOrEmpty(List<?> value) {
		return value == null || value.isEmpty();
	}

	public static boolean isNotNullOrEmpty(List<?> value) {
		return !ListUtil.isNullOrEmpty(value);
	}

	public static void shuffle(List<?> value) {
		Collections.shuffle(value, new Random(System.nanoTime()));
	}

	public static <T> T getRandom(List<T> value) {
		if (ListUtil.isNotNullOrEmpty(value)) {
			return value.get(NumberUtil.getRandom(0, value.size()));
		}

		return null;
	}

}
