package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> getAll() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente",Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cliente> getAllByName(String name) {
		return em.createQuery("from Cliente c where upper(c.nome) like :n",Cliente.class)
				.setParameter("n", "%" + name.toUpperCase() + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> getAllByEstado(String estado) {
		return em.createQuery(
			"from Cliente c where c.endereco.cidade.uf = :P",Cliente.class)
			.setParameter("P", estado)
			.getResultList();
	}

	@Override
	public List<Cliente> getAllByDiasReserva(int dias) {
		return em.createQuery(
			"select r.cliente from Reserva r where r.numeroDias = :d",Cliente.class)
			.setParameter("d", dias)
			.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :D "
				+ "and c.endereco.cidade.nome like :P",Cliente.class)
				.setParameter("D", "%" + nome + "%")
				.setParameter("P", "%" + cidade + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {		
		return em.createQuery("from Cliente c where "
				+ "c.endereco.cidade.uf in :estados",Cliente.class)
				.setParameter("estados", estados)
				.getResultList();
	}

	@Override
	public long countByEstado(String estado) {
		return em.createQuery("select count(c) from Cliente "
				+ "c where c.endereco.cidade.uf = :S",Long.class)
				.setParameter("S", estado)
				.getSingleResult();
	}

	@Override
	public Cliente getByCpf(String cpf) {
		return em.createNamedQuery("Cliente.porCpf",Cliente.class)
				.setParameter("cpf", cpf)
				.getSingleResult();
	}

}










