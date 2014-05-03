package br.com.tio.contatos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class JpaSfoc {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
	EntityManager manager = factory.createEntityManager();

	public void adicionar(Object objeto){
		manager.persist(objeto);
	}

}
