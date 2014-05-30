package br.com.tio.mvc.logica;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.jpa.ExecHibernate;

public class DeletarLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		ExecHibernate dao = new ExecHibernate();
		//PrintWriter out = response.getWriter();
		
		try {
			String table = request.getParameter("table");
			String idS = request.getParameter("id");
			
			//String table = "Faixas_Acesso";
			//String idS = "7";
			Long id = Long.parseLong(idS);
			
			boolean result = dao.deletar(table, id);
			
			//out.print(result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
}
