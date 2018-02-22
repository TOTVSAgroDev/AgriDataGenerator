package com.totvs.agridatagenerator.framework.generators;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.totvs.agridatagenerator.framework.utils.BooleanUtil;
import com.totvs.agridatagenerator.framework.utils.DateUtil;
import com.totvs.agridatagenerator.framework.utils.ListUtil;
import com.totvs.agridatagenerator.framework.utils.NumberUtil;
import com.totvs.agridatagenerator.vo.CulturaVO;
import com.totvs.agridatagenerator.vo.EquipamentoVO;
import com.totvs.agridatagenerator.vo.FazendaVO;
import com.totvs.agridatagenerator.vo.FuncionarioVO;
import com.totvs.agridatagenerator.vo.GrupoOperativoVO;
import com.totvs.agridatagenerator.vo.InspecaoFitossanitariaPontoVO;
import com.totvs.agridatagenerator.vo.InspecaoFitossanitariaVO;
import com.totvs.agridatagenerator.vo.PragaVO;
import com.totvs.agridatagenerator.vo.ResultadoInspecaoVO;
import com.totvs.agridatagenerator.vo.TalhaoVO;
import com.totvs.agridatagenerator.vo.enums.TipoEquipamentoEnum;
import com.totvs.agridatagenerator.vo.enums.TipoGrupoOperativoEnum;
import com.totvs.agridatagenerator.vo.enums.TipoInspecaoPragaEnum;
import com.totvs.agridatagenerator.vo.enums.TipoPragaEnum;

public abstract class AgriDataGeneratorBO {

	public static List<FazendaVO> gerarFazendas(int max) {
		List<FazendaVO> fazendas = new LinkedList<FazendaVO>();

		long codigo = 0L;

		for (int i = 0; i < max; i++) {
			codigo += 10L;
			FazendaVO fazenda = new FazendaVO(NumberUtil.asString(codigo), "Fazenda #" + codigo);

			fazendas.add(fazenda);
		}

		return fazendas;
	}

	public static List<TalhaoVO> gerarTalhoes(int max, List<CulturaVO> culturas) {
		List<TalhaoVO> talhoes = new LinkedList<TalhaoVO>();

		for (CulturaVO cultura : culturas) {
			talhoes.addAll(AgriDataGeneratorBO.gerarTalhoes(max, cultura));
		}

		return talhoes;
	}

	private static List<TalhaoVO> gerarTalhoes(int max, CulturaVO cultura) {
		List<TalhaoVO> talhoes = new LinkedList<TalhaoVO>();

		long codigo = 1000L;

		for (int i = 0; i < max; i++) {
			codigo += 10L;

			BigDecimal areaMinima = new BigDecimal("25");
			BigDecimal areaMaxima = new BigDecimal("250");

			BigDecimal area = NumberUtil.getRandomBigDecimal(areaMinima, areaMaxima);
			BigDecimal areaProdutiva = BooleanUtil.getRandomBoolean() ? NumberUtil.getRandomBigDecimal(areaMinima, area) : area;

			TalhaoVO talhao = new TalhaoVO(NumberUtil.asString(codigo), cultura, area, areaProdutiva);

			talhoes.add(talhao);
		}

		return talhoes;
	}

	public static List<CulturaVO> gerarCulturas() {
		String[] data = { "Cana-de-Açúcar", "Soja", "Algodão" };

		List<CulturaVO> culturas = new LinkedList<CulturaVO>();

		long codigo = 0L;

		for (String item : data) {
			codigo += 1000L;
			String descricao = new String(item);

			CulturaVO cultura = new CulturaVO(NumberUtil.asString(codigo), descricao);

			culturas.add(cultura);
		}

		ListUtil.shuffle(culturas);

		return culturas;
	}

	public static List<FuncionarioVO> gerarFuncionarios() {
		String[] data = { "Juliana", "Emílio", "Rodrigo", "Leonardo", "Guilherme" };

		List<FuncionarioVO> funcionarios = new LinkedList<FuncionarioVO>();

		long codigo = 10000L;

		for (String item : data) {
			codigo += 10L;
			String descricao = new String(item);

			FuncionarioVO funcionario = new FuncionarioVO(codigo, descricao);

			funcionarios.add(funcionario);
		}

		ListUtil.shuffle(funcionarios);

		return funcionarios;
	}

	public static List<PragaVO> gerarPragas() {
		List<PragaVO> pragas = new LinkedList<PragaVO>();

		long codigo = 1000L;

		pragas.add(new PragaVO(codigo++, "Saúva parda", "Atta capiguara", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 1L));
		pragas.add(new PragaVO(codigo++, "Besouro-pardo", "Bolax flavolineatus", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 1L));
		pragas.add(new PragaVO(codigo++, "Broca-gigante", "Castnia licus", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 2L));
		pragas.add(new PragaVO(codigo++, "Cupim", "Cornitermes cumulans", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 2L));
		pragas.add(new PragaVO(codigo++, "Broca-da-cana", "Diatraea saccharalis", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 3L));
		pragas.add(new PragaVO(codigo++, "Lagarta-elasmo", "Elasmopalpus lignosellus", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 3L));
		pragas.add(new PragaVO(codigo++, "Cascudo-preto", "Euetheola humilis", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 4L));
		pragas.add(new PragaVO(codigo++, "Cigarrinha-das-raízes", "Mahanarva fimbriolata", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 4L));
		pragas.add(new PragaVO(codigo++, "Curuquerê-dos-capinzais", "Mocis latipes", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 5L));
		pragas.add(new PragaVO(codigo++, "Cigarrinha-das-folhas", "Mahanarva posticata", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 5L));
		pragas.add(new PragaVO(codigo++, "Piolho", "Thrips tabaci", TipoPragaEnum.INSETO, TipoInspecaoPragaEnum.NUMERO_INDIVIDUOS, 6L));

		pragas.add(new PragaVO(codigo++, "Podridão-negra", "Ceratocystis paradoxa", TipoPragaEnum.DOENCA, TipoInspecaoPragaEnum.PLANTAS_ATACADAS, 1L));
		pragas.add(new PragaVO(codigo++, "Podridão Vermelha", "Colletotrichum falcatum", TipoPragaEnum.DOENCA, TipoInspecaoPragaEnum.PLANTAS_ATACADAS, 2L));
		pragas.add(new PragaVO(codigo++, "Nematóide", "Helicotylenchus dihystera", TipoPragaEnum.DOENCA, TipoInspecaoPragaEnum.PLANTAS_ATACADAS, 3L));
		pragas.add(new PragaVO(codigo++, "Nematóide-das-galhas", "Meloidogyne incognita", TipoPragaEnum.DOENCA, TipoInspecaoPragaEnum.PLANTAS_ATACADAS, 4L));

		pragas.add(new PragaVO(codigo++, "Espinheiro", "Acacia farnesiana", TipoPragaEnum.ERVA_DANINHA, TipoInspecaoPragaEnum.PRESENCA, 1L));
		pragas.add(new PragaVO(codigo++, "Serra-goela", "Acacia paniculata", TipoPragaEnum.ERVA_DANINHA, TipoInspecaoPragaEnum.PRESENCA, 2L));
		pragas.add(new PragaVO(codigo++, "Carrapicho ", "Aeschynomene selloi", TipoPragaEnum.ERVA_DANINHA, TipoInspecaoPragaEnum.PRESENCA, 3L));
		pragas.add(new PragaVO(codigo++, "Ambrosia-americana", "Ambrosia elatior", TipoPragaEnum.ERVA_DANINHA, TipoInspecaoPragaEnum.PRESENCA, 4L));

		ListUtil.shuffle(pragas);

		return pragas;
	}

	public static List<EquipamentoVO> gerarEquipamentos() {
		List<EquipamentoVO> equipamentos = new LinkedList<EquipamentoVO>();

		GrupoOperativoVO caminhao = new GrupoOperativoVO("10", "Caminhão", TipoGrupoOperativoEnum.PRINCIPAL);
		GrupoOperativoVO trator = new GrupoOperativoVO("20", "Trator", TipoGrupoOperativoEnum.PRINCIPAL);
		GrupoOperativoVO plantadeira = new GrupoOperativoVO("30", "Plantadeira", TipoGrupoOperativoEnum.PRINCIPAL);
		GrupoOperativoVO colheitadeira = new GrupoOperativoVO("40", "Colheitadeira", TipoGrupoOperativoEnum.PRINCIPAL);
		GrupoOperativoVO implemento = new GrupoOperativoVO("50", "Implemento", TipoGrupoOperativoEnum.AUXILIAR);

		long codigo = 10000;

		for (int i = 0; i < 20; i++) {
			codigo += 10L;

			TipoEquipamentoEnum tipo = BooleanUtil.getRandomBoolean() ? TipoEquipamentoEnum.PROPRIO : TipoEquipamentoEnum.TERCEIRO;
			BigDecimal ultimoHorimetro = BooleanUtil.getRandomBoolean() ? NumberUtil.getRandomBigDecimal(new BigDecimal("10000"), new BigDecimal("100000")) : BigDecimal.ZERO;
			Date dataUltimaManutencao = BooleanUtil.getRandomBoolean() ? DateUtil.getRandomDate(180) : null;
			boolean disponivel = BooleanUtil.getRandomBoolean();

			EquipamentoVO equipamento = new EquipamentoVO(NumberUtil.asString(codigo), "Caminhão #" + i + 1, tipo, caminhao, ultimoHorimetro, dataUltimaManutencao, disponivel);

			equipamentos.add(equipamento);
		}

		codigo = 20000;

		for (int i = 0; i < 20; i++) {
			codigo += 10L;

			TipoEquipamentoEnum tipo = BooleanUtil.getRandomBoolean() ? TipoEquipamentoEnum.PROPRIO : TipoEquipamentoEnum.TERCEIRO;
			BigDecimal ultimoHorimetro = BooleanUtil.getRandomBoolean() ? NumberUtil.getRandomBigDecimal(new BigDecimal("10000"), new BigDecimal("100000")) : BigDecimal.ZERO;
			Date dataUltimaManutencao = BooleanUtil.getRandomBoolean() ? DateUtil.getRandomDate(180) : null;
			boolean disponivel = BooleanUtil.getRandomBoolean();

			EquipamentoVO equipamento = new EquipamentoVO(NumberUtil.asString(codigo), "Trator #" + i + 1, tipo, trator, ultimoHorimetro, dataUltimaManutencao, disponivel);

			equipamentos.add(equipamento);
		}

		codigo = 30000;

		for (int i = 0; i < 20; i++) {
			codigo += 10L;

			TipoEquipamentoEnum tipo = BooleanUtil.getRandomBoolean() ? TipoEquipamentoEnum.PROPRIO : TipoEquipamentoEnum.TERCEIRO;
			BigDecimal ultimoHorimetro = BooleanUtil.getRandomBoolean() ? NumberUtil.getRandomBigDecimal(new BigDecimal("10000"), new BigDecimal("100000")) : BigDecimal.ZERO;
			Date dataUltimaManutencao = BooleanUtil.getRandomBoolean() ? DateUtil.getRandomDate(180) : null;
			boolean disponivel = BooleanUtil.getRandomBoolean();

			EquipamentoVO equipamento = new EquipamentoVO(NumberUtil.asString(codigo), "Plantadeira #" + i + 1, tipo, plantadeira, ultimoHorimetro, dataUltimaManutencao, disponivel);

			equipamentos.add(equipamento);
		}

		codigo = 40000;

		for (int i = 0; i < 20; i++) {
			codigo += 10L;

			TipoEquipamentoEnum tipo = BooleanUtil.getRandomBoolean() ? TipoEquipamentoEnum.PROPRIO : TipoEquipamentoEnum.TERCEIRO;
			BigDecimal ultimoHorimetro = BooleanUtil.getRandomBoolean() ? NumberUtil.getRandomBigDecimal(new BigDecimal("10000"), new BigDecimal("100000")) : BigDecimal.ZERO;
			Date dataUltimaManutencao = BooleanUtil.getRandomBoolean() ? DateUtil.getRandomDate(180) : null;
			boolean disponivel = BooleanUtil.getRandomBoolean();

			EquipamentoVO equipamento = new EquipamentoVO(NumberUtil.asString(codigo), "Colheitadeira #" + i + 1, tipo, colheitadeira, ultimoHorimetro, dataUltimaManutencao, disponivel);

			equipamentos.add(equipamento);
		}

		codigo = 50000;

		for (int i = 0; i < 20; i++) {
			codigo += 10L;

			TipoEquipamentoEnum tipo = BooleanUtil.getRandomBoolean() ? TipoEquipamentoEnum.PROPRIO : TipoEquipamentoEnum.TERCEIRO;
			BigDecimal ultimoHorimetro = BooleanUtil.getRandomBoolean() ? NumberUtil.getRandomBigDecimal(new BigDecimal("10000"), new BigDecimal("100000")) : BigDecimal.ZERO;
			Date dataUltimaManutencao = BooleanUtil.getRandomBoolean() ? DateUtil.getRandomDate(180) : null;
			boolean disponivel = BooleanUtil.getRandomBoolean();

			EquipamentoVO equipamento = new EquipamentoVO(NumberUtil.asString(codigo), "Implemento #" + i + 1, tipo, implemento, ultimoHorimetro, dataUltimaManutencao, disponivel);

			equipamentos.add(equipamento);
		}

		ListUtil.shuffle(equipamentos);

		return equipamentos;
	}

	public static void gerarInspecoesFitossanitarias(List<TalhaoVO> talhoes, int max, int maxPontos, int maxPragas, List<FuncionarioVO> funcionarios, List<PragaVO> pragas) {
		for (TalhaoVO talhao : talhoes) {
			int numeroInspecoesFitossanitarias = BooleanUtil.getRandomBoolean(0.9d) ? NumberUtil.getRandom(1, max) : 0;

			if (numeroInspecoesFitossanitarias > 0) {
				for (int i = 0; i < numeroInspecoesFitossanitarias; i++) {
					Date dataInspecao = DateUtil.getRandomDate(60);
					FuncionarioVO funcionario = ListUtil.getRandom(funcionarios);
					boolean apontamentoFinalizado = BooleanUtil.getRandomBoolean();

					InspecaoFitossanitariaVO inspecaoFitossanitaria = new InspecaoFitossanitariaVO(dataInspecao, funcionario, apontamentoFinalizado);

					int numeroPontosInspecoesFitossanitarias = NumberUtil.getRandom(5, maxPontos);

					for (int j = 0; j < numeroPontosInspecoesFitossanitarias; j++) {
						InspecaoFitossanitariaPontoVO ponto = new InspecaoFitossanitariaPontoVO(j + 1L);

						int numeroPragasPonto = NumberUtil.getRandom(1, maxPragas);

						for (int k = 0; k < numeroPragasPonto; k++) {
							PragaVO praga = ListUtil.getRandom(pragas);
							ResultadoInspecaoVO resultadoInspecao = null;

							switch (praga.getTipoInspecaoPraga()) {
							case PRESENCA:
								resultadoInspecao = new ResultadoInspecaoVO(BooleanUtil.getRandomBoolean());
								break;
							case PLANTAS_ATACADAS:
								int numeroPlantasInspecionadas = NumberUtil.getRandom(2, 10);
								int numeroPlantasAtacadas = NumberUtil.getRandom(1, numeroPlantasInspecionadas);

								resultadoInspecao = new ResultadoInspecaoVO(new Long(numeroPlantasAtacadas), new Long(numeroPlantasInspecionadas));
								break;
							case NUMERO_INDIVIDUOS:
								resultadoInspecao = new ResultadoInspecaoVO(NumberUtil.getRandomAsLong(1, 20));
								break;
							}

							ponto.addResultadoInspecao(praga, resultadoInspecao);
						}

						inspecaoFitossanitaria.addPonto(ponto);
					}

					talhao.addInspecaoFitossanitaria(inspecaoFitossanitaria);
				}
			}
		}
	}

	public static void relacionarFazendasEquipamentos(List<FazendaVO> fazendas, List<EquipamentoVO> equipamentos) {
		for (EquipamentoVO equipamento : equipamentos) {
			ListUtil.getRandom(fazendas).addEquipamento(equipamento);
		}
	}

	public static void relacionarFazendasTalhoes(List<FazendaVO> fazendas, List<TalhaoVO> talhoes) {
		for (TalhaoVO talhao : talhoes) {
			ListUtil.getRandom(fazendas).addTalhao(talhao);
		}
	}

}
