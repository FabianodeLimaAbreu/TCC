package br.com.tio.mvc.logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.Contatos;
import br.com.tio.Usuarios;
import br.com.tio.jpa.ExecHibernate;

public class BuscarLogic implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
	//public static void main(String[] args){	
		ExecHibernate dao = new ExecHibernate();
		//Usuarios usuarios = new Usuarios();
		
		try{
			//String table = request.getParameter("table");
			
		String lista = dao.buscar("Contatos");
				
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
	
