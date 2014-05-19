package br.com.tio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tio.Contatos;
import br.com.tio.Departamentos;
import br.com.tio.Usuarios;
import br.com.tio.Visitantes;

import com.google.gson.Gson;

//@Repository
public class ExecHibernate {
	
	/******************** ADICIONAR E DELETAR ********************/ 
	public boolean query(Object objeto, String op){
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
					default:
						System.out.println("Comando "+ op +" inexistente: ");
						break;
					}
				manager.getTransaction().commit();

			manager.close();
			factory.close();

			return true;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}	

	/******************** BUSCAR ********************/	
	public String buscar(String tabela){	
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
			EntityManager manager = factory.createEntityManager();

			Gson gson = new Gson();
			
			List<String> retornada = manager.createQuery("SELECT t FROM "+ tabela +" as t").getResultList();
			
			String json = gson.toJson(retornada);
			
			manager.close();
			factory.close();
			
			return json;		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	/******************** DELETAR ********************/	
	public boolean deletar(String table, Long id){
		boolean result = false;
		Object encontrada = new Object();
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();	
		
			switch (table) {
			case "Contatos":
				encontrada = manager.find(Contatos.class, id);								
				break;				
			case "Usuarios":
				encontrada = manager.find(Usuarios.class, id);
				break;
			case "Visitantes":
				encontrada = manager.find(Visitantes.class, id);
				break;
			case "Departamentos":
				encontrada = manager.find(Departamentos.class, id);
				break;				
			default:
				System.out.println("Classe "+ table +" inexistente: ");
				break;
			}

			manager.remove(encontrada);
			
			manager.getTransaction().commit();
			result = true;

			manager.close();
			factory.close();			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}				
		return result;
	}
}