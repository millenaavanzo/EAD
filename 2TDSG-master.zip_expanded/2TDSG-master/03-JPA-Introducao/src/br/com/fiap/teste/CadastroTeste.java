package br.com.fiap.teste;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Tipo;
import br.com.fiap.entity.Zoologico;

public class CadastroTeste {

	public static void main(String[] args) {
		//Criar um gerenciador de entidades (Entity Manager)
		//Primeiro criar a fabrica de entity manager
		EntityManagerFactory fabrica =        		//persistence.xml
			Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Depois, a fabrica cria o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar um zoo
		Zoologico zoo = new Zoologico("Zoo São Paulo", 10, 
				Tipo.PRIVADO, new Date(), new Date(), 
				Calendar.getInstance(), false, null);
		
		em.persist(zoo);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}







