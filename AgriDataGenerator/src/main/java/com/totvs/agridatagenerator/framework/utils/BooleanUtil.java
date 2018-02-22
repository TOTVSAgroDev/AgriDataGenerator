package com.totvs.agridatagenerator.framework.utils;

public abstract class BooleanUtil {

	public static boolean getRandomBoolean() {
		return BooleanUtil.getRandomBoolean(0.5d);
	}

	public static boolean getRandomBoolean(double limit) {
		return Math.random() < limit;
	}

}
