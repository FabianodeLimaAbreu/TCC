package br.com.tio.mvc.logica;

import java.io.PrintWriter;
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
	
		ExecHibernate dao = new ExecHibernate();
		
		try{
			String table = request.getParameter("table");
			PrintWriter out = response.getWriter();
				
			String json = dao.buscar(table);
			
			out.print(json);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
	
