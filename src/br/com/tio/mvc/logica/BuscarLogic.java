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
		String json;
		
		try{
			String table = request.getParameter("table");
			
			if (table.equals("Visitantes")) {		
				String rg = request.getParameter("rg");	
				if (rg.equals("")) {
					rg = null;
				}
				json = dao.buscar(table, rg);
			} else {
				json = dao.buscar(table, null);
			}
			
			out.print(json);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
	
