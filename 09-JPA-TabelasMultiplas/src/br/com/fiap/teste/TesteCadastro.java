package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiao.dao.impl.ConsultaDAOImpl;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TesteCadastro {
private static ConsultaDAO dao;
	
	@BeforeAll
	public static void init() {
	EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	dao = new ConsultaDAOImpl(em);
	}
	
	@Test
	void cadastrar() {
		//FAZER OS CONSTRUTORES CREATE E COMMIT
		Paciente p = new Paciente(1,"maira","Av. Paulista");
		Medico m = new Medico(1234, "evelyn","Nada");
		Consulta c = new Consulta(1234,1,new GregorianCalendar(""))
		
		
		
		fail("Not yet implemented");
	}

}
