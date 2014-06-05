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
		String cod = "";
		
		try{
			String table = request.getParameter("table");
			
			if (table.equals("Visitantes")) {		
				cod = request.getParameter("rg");	

			} else if (table.equals("Cidades")) {
				cod = request.getParameter("cod_estado");				
			
			}
			/*if (cod.equals("")) 
				cod = null;*/
			
			json = dao.buscar(table, cod);			
			
			out.print(json);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
	
