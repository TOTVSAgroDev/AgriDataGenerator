package com.totvs.agridatagenerator.framework.utils;

import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.totvs.agridatagenerator.vo.FazendaVO;

public abstract class JsonUtil {

	private static final GsonBuilder GSON_BUILDER = new GsonBuilder().disableHtmlEscaping().setDateFormat("dd/MM/yyyy HH:mm:ss").enableComplexMapKeySerialization().setPrettyPrinting();
	private static final Gson GSON;

	static {
		GSON = GSON_BUILDER.create();
	}

	public static String asJson(Object value) {
		if (value != null) {
			try {
				return GSON.toJson(value);
			} catch (Exception e) {
			}
		}

		return StringUtil.EMPTY;
	}

	public static <T> List<T> fromJson(String json, Class<T> klass) {
		return GSON.fromJson(json, new TypeToken<List<FazendaVO>>() {
		}.getType());
	}

}
