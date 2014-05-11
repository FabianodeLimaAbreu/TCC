package br.com.tio.mvc.logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BuscarLogic {

	public List<String> buscar(Object objeto, Long id){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
		EntityManager manager = factory.createEntityManager();

		List<String> lista = manager.createQuery("SELECT t FROM "+ objeto +" as t").getResultList();
		
		manager.close();
		factory.close();
		
		return lista;
	}
}
