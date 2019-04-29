package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	Cliente getByCpf(String cpf);
	
	long countByEstado(String estado);
	
	List<Cliente> getAll();
	
	List<Cliente> getAllByName(String name);
	
	List<Cliente> getAllByEstado(String estado);
	
	List<Cliente> getAllByDiasReserva(int dias);

	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
}