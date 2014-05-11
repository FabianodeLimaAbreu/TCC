package br.com.tio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tio.Usuarios;

//@Repository
public class ExecHibernate {

	public void query(Object objeto, String op){
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
			EntityManager manager = factory.createEntityManager();
	
				manager.getTransaction().begin();
					switch (op) {					
					case "adicionar":
						manager.persist(objeto);
					    break;
					case "alterar":					
						manager.merge(objeto);
						break; 
					case "remover":
						Usuarios encontrada = manager.find(Usuarios.class, ((Usuarios) objeto).getId());
						manager.remove(encontrada);
						break;
					default:
						System.out.println("Comando "+ op +" inexistente: ");
						break;
					}
				manager.getTransaction().commit();

			manager.close();
			factory.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}	

	public List<String> buscar(Object objeto){
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
			EntityManager manager = factory.createEntityManager();

			List<String> lista = manager.createQuery("SELECT t FROM "+ objeto +" as t").getResultList();
			
			manager.close();
			factory.close();
			
			return lista;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}