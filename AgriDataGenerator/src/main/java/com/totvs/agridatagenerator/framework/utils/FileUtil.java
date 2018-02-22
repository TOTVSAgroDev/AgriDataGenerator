package com.totvs.agridatagenerator.framework.utils;

import java.io.File;
import java.nio.charset.Charset;
import com.google.common.io.Files;

public abstract class FileUtil {

	public static String readFile(String file, Charset charset) {
		try {
			return Files.asCharSource(new File(file), charset).read();
		} catch (Exception e) {
		}

		return StringUtil.EMPTY;
	}

	public static boolean writeFile(String file, String content, Charset charset) {
		try {
			Files.asCharSink(new File(file), charset).write(content);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
