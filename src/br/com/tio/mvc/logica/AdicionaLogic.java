package br.com.tio.mvc.logica;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.tio.Usuarios;
import br.com.tio.Visitantes;
import br.com.tio.jpa.ExecHibernate;

public class AdicionaLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		PrintWriter out = response.getWriter();
		
		ExecHibernate dao = new ExecHibernate();

		try{
			String table = request.getParameter("table");
					
			switch (table) {
			case "Usuarios":
				String dataEmTexto = request.getParameter("val_cartao");
				Calendar val_cartao = null;
				//convertendo data
				try{
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					val_cartao = Calendar.getInstance();
				}catch (ParseException e) {
					out.print("Erro na conversão de data");
					return;
				}
			    String cracha = request.getParameter("cracha");
			    int versao = Integer.parseInt(request.getParameter("versao"));
			    int cod_emp = Integer.parseInt(request.getParameter("cod_emp"));
			    String nome = request.getParameter("nome");
			    String nome_abrev = request.getParameter("nome_abrev");
			    int cod_tip = Integer.parseInt(request.getParameter("cod_tip"));
			    String senha = request.getParameter("senha");
			   
				Usuarios usuario = new Usuarios();
				usuario.setVal_cartao(val_cartao);
				usuario.setCracha(cracha);			
				usuario.setVersao(versao);
				usuario.setCod_emp(cod_emp);
				usuario.setNome(nome);
				usuario.setNome_abrev(nome_abrev);
				usuario.setCod_tip(cod_tip);
				usuario.setSenha(senha);
				
				dao.query(usuario, "adicionar");		
				break;
			default:
				out.println("Opção inválida");
				break;
			}			
		}catch (Exception e) {
			throw new RuntimeException(e);	
		}	
	}
}
