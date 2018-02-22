package com.totvs.agridatagenerator.framework.loggers;

import java.util.List;
import com.totvs.agridatagenerator.framework.utils.DateUtil;
import com.totvs.agridatagenerator.vo.EquipamentoVO;
import com.totvs.agridatagenerator.vo.FazendaVO;
import com.totvs.agridatagenerator.vo.InspecaoFitossanitariaPontoVO;
import com.totvs.agridatagenerator.vo.InspecaoFitossanitariaVO;
import com.totvs.agridatagenerator.vo.PragaVO;
import com.totvs.agridatagenerator.vo.TalhaoVO;

public abstract class AgriDataLoggerBO {

	public static void log(List<FazendaVO> fazendas) {
		for (FazendaVO fazenda : fazendas) {
			System.out.println(fazenda.getDescricao());

			System.out.println("  > Equipamentos");
			for (EquipamentoVO equipamento : fazenda.getEquipamentos()) {
				System.out.println("    >> " + equipamento.getCodigo() + " - " + equipamento.getModelo() + " - " + equipamento.getGrupoOperativo().getDescricao() + " (" + equipamento.getGrupoOperativo().getTipo().getValue() + ") - " + equipamento.getTipo().getValue() + " - " + equipamento.getUltimoHorimetro() + " - " + DateUtil.format(equipamento.getDataUltimaManutencao()));
			}

			System.out.println("  > Talhões");
			for (TalhaoVO talhao : fazenda.getTalhoes()) {
				System.out.println("    >> " + talhao.getCodigo() + " (" + talhao.getCultura().getDescricao() + ") - " + talhao.getAreaProdutiva() + "/" + talhao.getArea());

				if (talhao.hasInspecoesFitossanitarias()) {
					System.out.println("       >>> Inspeções Fitossanitárias");

					for (InspecaoFitossanitariaVO inspecaoFitossanitaria : talhao.getInspecoesFitossanitarias()) {
						System.out.println("           " + DateUtil.format(inspecaoFitossanitaria.getDataInspecao()) + " - " + inspecaoFitossanitaria.getFuncionario().getNome() + " - " + inspecaoFitossanitaria.getPontos().size() + " pontos");

						if (inspecaoFitossanitaria.hasPontos()) {
							for (InspecaoFitossanitariaPontoVO ponto : inspecaoFitossanitaria.getPontos()) {
								System.out.println("             " + ponto.getNumeroPonto());

								for (PragaVO praga : ponto.getResultadoInspecao().keySet()) {
									System.out.println("               " + praga.getCodigo() + " - " + praga.getDescricao() + " - " + ponto.getResultadoInspecao().get(praga).getResultado());
								}
							}
						}
					}
				}
			}
		}
	}

}
