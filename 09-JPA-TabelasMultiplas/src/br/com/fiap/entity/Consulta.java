package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_consulta")
@IdClass(ConsultaPK.class)
public class Consulta {

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Column(name = "nr_crm")
	private Medico medico;

	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Column(name = "cd_paciente")
	private Paciente paciente;

	@Id
	@Column(name = "dt_contulta")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataConsulta;

	@Column(name = "vl_consulta")
	private double valorConsulta;

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Calendar getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Calendar dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	@Column(name = "st_convenio")
	private boolean convenio;

	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

}
