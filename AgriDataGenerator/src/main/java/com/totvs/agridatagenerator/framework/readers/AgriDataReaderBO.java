package com.totvs.agridatagenerator.framework.readers;

import java.nio.charset.Charset;
import java.util.List;
import com.totvs.agridatagenerator.framework.utils.FileUtil;
import com.totvs.agridatagenerator.framework.utils.JsonUtil;
import com.totvs.agridatagenerator.vo.FazendaVO;

public class AgriDataReaderBO {

	public static List<FazendaVO> readFrom(String file, Charset charset) {
		try {
			String json = FileUtil.readFile(file, charset);

			List<FazendaVO> fazendas = JsonUtil.fromJson(json, FazendaVO.class);

			return fazendas;
		} catch (Exception e) {
		}

		return null;
	}

}
