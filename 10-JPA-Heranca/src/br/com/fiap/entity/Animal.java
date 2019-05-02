package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Table(name = "t_animal")
@Entity
@SequenceGenerator(name = "animal", sequenceName = "sq_t_animal", allocationSize = 1)
public class Animal {

	@Id
	@GeneratedValue(generator = "animal", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_animal")
	private int codigo;
	@Column(name = "ds_cor")
	private String cor;
	@Column(name = "nm_animal")
	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Animal(int codigo, String cor, String nome) {
		super();
		this.codigo = codigo;
		this.cor = cor;
		this.nome = nome;
	}

	public Animal(String cor, String nome) {
		super();
		this.cor = cor;
		this.nome = nome;
	}

	public Animal() {

	}
}
