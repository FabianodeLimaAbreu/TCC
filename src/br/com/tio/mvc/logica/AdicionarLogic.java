package br.com.tio.mvc.logica;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.Contatos;
import br.com.tio.Departamentos;
import br.com.tio.Empresas;
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
			case "Departamentos":
				String desc_dpto = request.getParameter("desc_dpto");
				
				Departamentos departamentos = new Departamentos();
				departamentos.setDesc_dpto(desc_dpto);
				
				dao.query(departamentos, "adicionar");				
				break;
			case "Empresas":		
				Empresas empresas = new Empresas();
				
				empresas.setRazao_social(request.getParameter("razao_social"));
				empresas.setNome_fantasia(request.getParameter("nome_fantasia"));
				empresas.setTelefone(request.getParameter("telefone"));
			
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
			   
				Usuarios usuarios = new Usuarios();
				usuarios.setVal_cartao(val_cartao);
				usuarios.setCracha(request.getParameter("cracha"));			
				usuarios.setVersao(Integer.parseInt(request.getParameter("versao")));
				usuarios.setCod_emp(Integer.parseInt(request.getParameter("cod_emp")));
				usuarios.setNome(request.getParameter("nome"));
				usuarios.setNome_abrev(request.getParameter("nome_abrev"));
				usuarios.setCod_tip(Integer.parseInt(request.getParameter("cod_tip")));
				usuarios.setSenha(request.getParameter("senha"));
				
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
