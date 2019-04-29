package br.com.fiao.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.entity.Consulta;

public class ConsultaDAOImpl extends GenericDAOImpl<Consulta,Integer> implements ConsultaDAO{

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
