package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.dao.impl.ImovelDAOImpl;
import br.com.fiap.entity.Imovel;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		ImovelDAO dao = new ImovelDAOImpl(em);
		
		//Pesquisar um imóvel
		Imovel imovel = dao.consultar(1);
		//Exibir alguns dados
		System.out.println(imovel.getLogradouro());
		System.out.println(imovel.getArea());
		
		em.close();
		fabrica.close();
	}
	
}