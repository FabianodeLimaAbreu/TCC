package br.com.tio.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tio.Contato;
import br.com.tio.Tarefa;

//@Repository
public class ExecHibernate {

	public static void main(String[] args) {	
		Contato contato = new Contato();
		Tarefa tarefa = new Tarefa();
		contato.setNome("Gabriel");
		tarefa.setDescricao("teste descricao");
		ExecHibernate dao = new ExecHibernate();
		dao.query(contato, "adicionar");
		dao.query(tarefa, "adicionar");
	}

	public void query(Object contato, String op){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
		EntityManager manager = factory.createEntityManager();
		
		try{
			manager.getTransaction().begin();
				switch (op) {
				case "adicionar":
					manager.persist(contato);
				    break;
				case "alterar":					
					manager.merge(contato);
					break; 
				case "remover":
					Contato encontrada = manager.find(Contato.class, ((Contato) contato).getId());
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