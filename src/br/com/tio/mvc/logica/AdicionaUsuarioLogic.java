package br.com.tio.mvc.logica;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.Contato;
import br.com.tio.jpa.ExecHibernate;

public class AdicionaUsuarioLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		
		Contato contato = new Contato();
		ExecHibernate dao = new ExecHibernate();
		
		contato.setNome(nome);
		contato.setEmail(email);
		
		dao.query(contato, "adicionar");		

		RequestDispatcher rd = request.getRequestDispatcher(null);
		//response.setStatus(200);
	}
}
