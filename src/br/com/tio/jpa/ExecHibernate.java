package br.com.tio.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tio.Usuarios;

//@Repository
public class ExecHibernate {

	public void query(Object objeto, String op){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
		EntityManager manager = factory.createEntityManager();
		
		try{
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
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		manager.close();
		factory.close();
	}	
}