package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * T_IMOVEL
 * 		*cd_imovel (NUMBER) (PK) (SEQUENCE SQ_T_IMOVEL)
 * 		*ds_tipo (VARCHAR) (Enum...)
 * 		vl_area (NUMBER)
 * 		dt_construcao (DATE)
 * 		*ds_logradouro (VARCHAR(100))  
 */

@Entity
@Table(name="T_IMOVEL")
@SequenceGenerator(name="imovel",sequenceName="SQ_T_IMOVEL",allocationSize=1)
public class Imovel {

	@Id
	@Column(name="cd_imovel")
	@GeneratedValue(generator="imovel",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo",nullable=false)
	private TipoImovel tipo;
	
	@Column(name="vl_area")
	private int area;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_construcao")
	private Calendar dataConstrucao;
	
	@Column(name="ds_logradouro",nullable=false, length=100)
	private String logradouro;

	public Imovel() {
		super();
	}
	
	public Imovel(TipoImovel tipo, int area, Calendar dataConstrucao, String logradouro) {
		super();
		this.tipo = tipo;
		this.area = area;
		this.dataConstrucao = dataConstrucao;
		this.logradouro = logradouro;
	}

	public Imovel(int codigo, TipoImovel tipo, int area, Calendar dataConstrucao, String logradouro) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.area = area;
		this.dataConstrucao = dataConstrucao;
		this.logradouro = logradouro;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoImovel getTipo() {
		return tipo;
	}

	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Calendar getDataConstrucao() {
		return dataConstrucao;
	}

	public void setDataConstrucao(Calendar dataConstrucao) {
		this.dataConstrucao = dataConstrucao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
}





