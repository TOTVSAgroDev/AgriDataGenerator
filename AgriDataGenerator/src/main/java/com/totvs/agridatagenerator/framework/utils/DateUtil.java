package com.totvs.agridatagenerator.framework.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateUtil {

	public static final String DATE_PATTERN = "dd/MM/yyyy";
	public static final String TIME_PATTERN = "HH:mm:ss";
	public static final String FULL_DATE_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

	public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);
	public static final DateFormat TIME_FORMAT = new SimpleDateFormat(TIME_PATTERN);
	public static final DateFormat FULL_DATE_FORMAT = new SimpleDateFormat(FULL_DATE_PATTERN);

	public static boolean isEmptyOrNull(Date value) {
		return value == null;
	}

	public static boolean isNotEmptyOrNull(Date value) {
		return !DateUtil.isEmptyOrNull(value);
	}

	public static Date parse(String value) {
		if (StringUtil.isNotEmptyOrNull(value)) {
			try {
				return DATE_FORMAT.parse(value);
			} catch (ParseException e) {
			}
		}

		return null;
	}

	public static Date parse(String value, String pattern) {
		if (StringUtil.isNotEmptyOrNull(value)) {
			try {
				return new SimpleDateFormat(pattern).parse(value);
			} catch (ParseException e) {
			}
		}

		return null;
	}

	public static String format(Date value) {
		if (DateUtil.isNotEmptyOrNull(value)) {
			return DATE_FORMAT.format(value);
		}

		return null;
	}

	public static String format(Date value, String pattern) {
		if (DateUtil.isNotEmptyOrNull(value)) {
			return new SimpleDateFormat(pattern).format(value);
		}

		return null;
	}

	public static Date getRandomDate(int days) {
		Date actualDate = new Date();

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(actualDate);
		calendar.set(Calendar.DAY_OF_YEAR, -days);

		long beginTime = calendar.getTimeInMillis();
		long endTime = actualDate.getTime();

		long diff = endTime - beginTime + 1;

		calendar.setTime(new Date(beginTime + (long) (Math.random() * diff)));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

}
