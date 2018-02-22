package com.totvs.agridatagenerator.framework.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public abstract class NumberUtil {

	public static Long asLong(String value) {
		if (StringUtil.isNotEmptyOrNull(value)) {
			try {
				return Long.valueOf(value);
			} catch (Exception e) {
			}
		}

		return null;
	}

	public static String asString(Long value) {
		if (value != null) {
			try {
				return Long.toString(value);
			} catch (Exception e) {
			}
		}

		return StringUtil.EMPTY;
	}

	public static BigDecimal getRandomBigDecimal(BigDecimal min, BigDecimal max) {
		return NumberUtil.getRandomBigDecimal(min, max, 2);
	}

	public static BigDecimal getRandomBigDecimal(BigDecimal min, BigDecimal max, int scale) {
		BigDecimal value = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));

		if (value != null) {
			value = value.setScale(scale, RoundingMode.HALF_UP);
		}

		return value;
	}

	public static int getRandom(int min, int max) {
		return new Random().nextInt((max - min)) + min;
	}

	public static long getRandomAsLong(int min, int max) {
		return new Long(NumberUtil.getRandom(min, max));
	}

}
