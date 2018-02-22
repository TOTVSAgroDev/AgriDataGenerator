package com.totvs.agridatagenerator.main;

import java.util.List;
import com.google.common.base.Charsets;
import com.totvs.agridatagenerator.framework.generators.AgriDataGeneratorBO;
import com.totvs.agridatagenerator.framework.utils.FileUtil;
import com.totvs.agridatagenerator.framework.utils.JsonUtil;
import com.totvs.agridatagenerator.vo.CulturaVO;
import com.totvs.agridatagenerator.vo.EquipamentoVO;
import com.totvs.agridatagenerator.vo.FazendaVO;
import com.totvs.agridatagenerator.vo.FuncionarioVO;
import com.totvs.agridatagenerator.vo.PragaVO;
import com.totvs.agridatagenerator.vo.TalhaoVO;

public class Main {
	public static void main(String[] args) {
		try {

			List<CulturaVO> culturas = AgriDataGeneratorBO.gerarCulturas();

			List<TalhaoVO> talhoes = AgriDataGeneratorBO.gerarTalhoes(20, culturas);

			List<FazendaVO> fazendas = AgriDataGeneratorBO.gerarFazendas(10);

			AgriDataGeneratorBO.relacionarFazendasTalhoes(fazendas, talhoes);

			List<EquipamentoVO> equipamentos = AgriDataGeneratorBO.gerarEquipamentos();

			AgriDataGeneratorBO.relacionarFazendasEquipamentos(fazendas, equipamentos);

			// #####

			List<FuncionarioVO> funcionarios = AgriDataGeneratorBO.gerarFuncionarios();

			List<PragaVO> pragas = AgriDataGeneratorBO.gerarPragas();

			// #####

			AgriDataGeneratorBO.gerarInspecoesFitossanitarias(talhoes, 10, 20, 5, funcionarios, pragas);

			// #####

			String json = JsonUtil.asJson(fazendas);
			FileUtil.writeFile("C:\\Users\\guilherme.farto\\Desktop\\farm-dataset.json", json, Charsets.UTF_8);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
