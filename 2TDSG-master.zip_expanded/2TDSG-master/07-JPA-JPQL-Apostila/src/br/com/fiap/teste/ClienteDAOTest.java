package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

class ClienteDAOTest {

	private static ClienteDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		dao = new ClienteDAOImpl(em);
	}
	
	@Test
	void getByCpfTest() {
		//98728018736
		Cliente cliente = dao.getByCpf("98728018736");
		assertEquals("98728018736", cliente.getCpf());
	}
	
	@Test
	void countByEstadoTeste() {
		long qtd = dao.countByEstado("SP");
		assertEquals(1, qtd);
	}
	
	@Test
	void getAllByEstadosTeste() {
		List<String> estados = Arrays.asList("SP","PR");
		
		List<Cliente> lista = dao.buscarPorEstados(estados);
		
		for (Cliente cliente : lista) {
			assertTrue(estados.contains(cliente.getEndereco()
											.getCidade().getUf()));
		}
		
	}
	
	@Test
	void getAllByNameAndCityTest() {
		
		List<Cliente> lista = dao.buscar("Leandro","Lon");
		
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Leandro") &&
				cliente.getEndereco().getCidade().getNome().contains("Lon"));
		}
		
	}
	
	@Test
	void getAllByDiaReservaTest() {
		List<Cliente> lista = dao.getAllByDiasReserva(10);
		assertEquals(2, lista.size());
	}
	
	@Test
	void getAllByEstadoTest() {
		
		List<Cliente> lista = dao.getAllByEstado("SP");
		assertNotEquals(0, lista.size());
		
		for (Cliente cliente : lista) {
			
			assertEquals("SP", cliente.getEndereco().getCidade()
					.getUf());
			
			//assertTrue(cliente.getEndereco().getCidade()
			//		.getUf().contains("SP"));
		}
		
	}
	
	@Test
	void getAllByNameTest() {
		List<Cliente> lista = dao.getAllByName("ma");
		assertNotEquals(0, lista.size());
		//validar se os clientes retornados estão corretos
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Ma"));
		}
	}
	
	@Test
	void getAllTest() {
		List<Cliente> lista = dao.getAll();
		assertNotEquals(0, lista.size());
	}

}
