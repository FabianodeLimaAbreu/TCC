package br.com.tio.mvc.logica;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.Usuarios;
import br.com.tio.VisitantesAux;
import br.com.tio.jpa.ExecHibernate;

public class AdicionaLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		ExecHibernate dao = new ExecHibernate();

		try{
			String table = request.getParameter("table");
					
			switch (table) {
			case "Usuarios":
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
			
				Usuarios contato = new Usuarios();
				contato.setNome(nome);
				contato.setEmail(email);
				
				dao.query(contato, "adicionar");		
				break;
			case "VisitantesAux":
				String nome_visitante = request.getParameter("visitante");
				String qtd = request.getParameter("qtd");
				int qtd_int = Integer.parseInt(qtd);
				
				VisitantesAux visitante = new VisitantesAux();
				visitante.setVisitante(nome_visitante);
				visitante.setQtd(qtd_int);
				
				dao.query(visitante, "adicionar");				
				break;
			default:
				
				break;
			}			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
}
