package br.com.tio.mvc.logica;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.Contatos;
import br.com.tio.Usuarios;
import br.com.tio.jpa.ExecHibernate;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class AdicionarLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		PrintWriter out = response.getWriter();
		
		ExecHibernate dao = new ExecHibernate();

		try{
			String table = request.getParameter("table");
			
			switch (table) {
			case "Contatos":
				String nomeContato = request.getParameter("nome");
				
				Contatos contatos = new Contatos();
				contatos.setNome(nomeContato);
				
				dao.query(contatos, "adicionar");
				break;
			case "Usuarios":
				String dataEmTexto = request.getParameter("val_cartao");
				Calendar val_cartao = null;
				//convertendo data
				try{
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					val_cartao = Calendar.getInstance();
				}catch (ParseException e) {
					out.print("Erro na conversão de data");
				}
			    String cracha = request.getParameter("cracha");
			    int versao = Integer.parseInt(request.getParameter("versao"));
			    int cod_emp = Integer.parseInt(request.getParameter("cod_emp"));
			    String nome = request.getParameter("nome");
			    String nome_abrev = request.getParameter("nome_abrev");
			    int cod_tip = Integer.parseInt(request.getParameter("cod_tip"));
			    String senha = request.getParameter("senha");
			   
				Usuarios usuarios = new Usuarios();
				usuarios.setVal_cartao(val_cartao);
				usuarios.setCracha(cracha);			
				usuarios.setVersao(versao);
				usuarios.setCod_emp(cod_emp);
				usuarios.setNome(nome);
				usuarios.setNome_abrev(nome_abrev);
				usuarios.setCod_tip(cod_tip);
				usuarios.setSenha(senha);
				
				dao.query(usuarios, "adicionar");		
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
