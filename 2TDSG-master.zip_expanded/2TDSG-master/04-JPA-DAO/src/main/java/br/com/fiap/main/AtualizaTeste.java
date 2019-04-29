package br.com.fiap.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.dao.impl.ImovelDAOImpl;
import br.com.fiap.entity.Imovel;
import br.com.fiap.entity.TipoImovel;
import br.com.fiap.excecao.CommitException;

public class AtualizaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		ImovelDAO dao = new ImovelDAOImpl(em); 
				
		Imovel imovel =	new Imovel(1, TipoImovel.APARTAMENTO, 50, 
				Calendar.getInstance(), "Av Paulista");
		
		try {
			dao.atualizar(imovel);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}



