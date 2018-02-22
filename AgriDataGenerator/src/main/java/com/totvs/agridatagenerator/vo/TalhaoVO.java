package com.totvs.agridatagenerator.vo;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import com.totvs.agridatagenerator.framework.utils.ListUtil;
import com.totvs.agridatagenerator.framework.vo.AbstractVO;

public class TalhaoVO extends AbstractVO {

	private String codigo;

	private CulturaVO cultura;

	private BigDecimal area;
	private BigDecimal areaProdutiva;

	private List<InspecaoFitossanitariaVO> inspecoesFitossanitarias;

	public TalhaoVO(String codigo, CulturaVO cultura, BigDecimal area, BigDecimal areaProdutiva) {
		super();

		this.codigo = codigo;
		this.cultura = cultura;
		this.area = area;
		this.areaProdutiva = areaProdutiva;
	}

	public String getCodigo() {
		return codigo;
	}

	public CulturaVO getCultura() {
		return cultura;
	}

	public BigDecimal getArea() {
		return area;
	}

	public BigDecimal getAreaProdutiva() {
		return areaProdutiva;
	}

	public List<InspecaoFitossanitariaVO> getInspecoesFitossanitarias() {
		if (inspecoesFitossanitarias == null) {
			inspecoesFitossanitarias = new LinkedList<InspecaoFitossanitariaVO>();
		}

		return inspecoesFitossanitarias;
	}

	public void addInspecaoFitossanitaria(InspecaoFitossanitariaVO inspecaoFitossanitaria) {
		this.getInspecoesFitossanitarias().add(inspecaoFitossanitaria);
	}

	public boolean hasInspecoesFitossanitarias() {
		return ListUtil.isNotNullOrEmpty(this.getInspecoesFitossanitarias());
	}

	@Override
	public String toString() {
		return "TalhaoVO [codigo=" + codigo + ", cultura=" + cultura + ", area=" + area + ", areaProdutiva=" + areaProdutiva + "]";
	}

}
