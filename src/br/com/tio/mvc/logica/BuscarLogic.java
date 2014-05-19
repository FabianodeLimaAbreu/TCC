package br.com.tio.mvc.logica;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.tio.jpa.ExecHibernate;

public class BuscarLogic implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
	
		ExecHibernate dao = new ExecHibernate();
		PrintWriter out = response.getWriter();
		
		try{
			String table = request.getParameter("table");
				
			String json = dao.buscar(table);
			
			out.print(json);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
	
