package br.com.fiap.entity;

import java.io.Serializable;

public class ConsultaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroCRM;
	private int codigoPaciente;
	private int dataConsulta;
	public int getNumeroCRM() {
		return numeroCRM;
	}
	public void setNumeroCRM(int numeroCRM) {
		this.numeroCRM = numeroCRM;
	}
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public int getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(int dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoPaciente;
		result = prime * result + dataConsulta;
		result = prime * result + numeroCRM;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPK other = (ConsultaPK) obj;
		if (codigoPaciente != other.codigoPaciente)
			return false;
		if (dataConsulta != other.dataConsulta)
			return false;
		if (numeroCRM != other.numeroCRM)
			return false;
		return true;
	}
	

}
