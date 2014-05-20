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
import br.com.tio.Feriados;
import br.com.tio.Operadores;
import br.com.tio.Perfis;
import br.com.tio.Usuarios;
import br.com.tio.Visitantes;
import br.com.tio.Zonas_Tempo;
import br.com.tio.jpa.ExecHibernate;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class AdicionarLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		PrintWriter out = response.getWriter();
		
		ExecHibernate dao = new ExecHibernate();
		
		String dataEmTexto, cadastroEmTexto, entradaEmTexto, saidaEmTexto;

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
				Departamentos departamentos = new Departamentos();
				departamentos.setDesc_dpto(request.getParameter("desc_dpto"));
				
				dao.query(departamentos, "adicionar");				
				break;
			case "Empresas":		
				Empresas empresas = new Empresas();
				
				empresas.setRazao_social(request.getParameter("razao_social"));
				empresas.setNome_fantasia(request.getParameter("nome_fantasia"));
				empresas.setTelefone(request.getParameter("telefone"));
				
				dao.query(empresas, "adicionar");
				break;
			case "Feriados":
				Feriados feriados = new Feriados();
				
				dataEmTexto = request.getParameter("data_feriado");
				Calendar data_feriado = null;
				try {
					Date date = new SimpleDateFormat("dd/MM;yyyy").parse(dataEmTexto);
					data_feriado = Calendar.getInstance();
					data_feriado.setTime(date);					
				} catch (ParseException e) {
					out.print("Erro na conversão de data");
				}
				
				feriados.setData_feriado(data_feriado);
				feriados.setDesc_feriado(request.getParameter("desc_feriado"));
				
				dao.query(feriados, "adicionar");				
				break;		
			case "Operadores":
				Operadores operadores = new Operadores();
				
				operadores.setLogin(Integer.parseInt(request.getParameter("login")));
				operadores.setSenha(request.getParameter("senha"));
				operadores.setCod_perf(Integer.parseInt(request.getParameter("cod_perf")));
				
				dao.query(operadores, "adicionar");				
				break;
			case "Perfis":
				Perfis perfis = new Perfis();
				
				perfis.setNome(request.getParameter("nome"));
				perfis.setDesc_perfil(request.getParameter("desc_perfil"));
				
				dao.query(perfis, "adicionar");				
				break;
			case "Usuarios":
				dataEmTexto = request.getParameter("val_cartao");
				Calendar val_cartao = null;
				//convertendo data
				try{
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					val_cartao = Calendar.getInstance();
					val_cartao.setTime(date);
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
			case "Visitantes":
				Visitantes visitantes = new Visitantes();

				cadastroEmTexto = request.getParameter("data_cadastro");
				Calendar data_cadastro = null;
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(cadastroEmTexto);
					data_cadastro = Calendar.getInstance();
					data_cadastro.setTime(date);
				} catch (ParseException e) {
					out.print("Erro na conversão de data");
				}
				
				entradaEmTexto = request.getParameter("data_entrada");
				Calendar data_entrada = null;
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(entradaEmTexto);
					data_entrada = Calendar.getInstance();
					data_entrada.setTime(date);
				} catch (ParseException e) {
					out.print("Erro na conversão de data");
				}				
				
				saidaEmTexto = request.getParameter("data_saida");
				Calendar data_saida = null;
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(saidaEmTexto);
					data_saida = Calendar.getInstance();
					data_saida.setTime(date);
				} catch (ParseException e) {
					out.print("Erro na conversão de data");
				}									
								
				visitantes.setRg(request.getParameter("rg"));
				visitantes.setCpf(request.getParameter("cpf"));
				visitantes.setNome(request.getParameter("nome"));
				visitantes.setCod_emp(Integer.parseInt(request.getParameter("cod_emp")));
				visitantes.setVeiculo(request.getParameter("veiculo"));
				visitantes.setPlaca(request.getParameter("placa"));
				visitantes.setCracha(request.getParameter("cracha"));
				visitantes.setLocal_acesso(request.getParameter("local_acesso"));
				visitantes.setObs(request.getParameter("obs"));
				visitantes.setAssunto("assunto");
				visitantes.setData_cadastro(data_cadastro);
				visitantes.setData_entrada(data_entrada);
				visitantes.setData_entrada(data_saida);
				
				dao.query(visitantes, "adicionar");
				break;
			case "Zonas_Tempo":
				Zonas_Tempo zonas_tempos = new Zonas_Tempo();
				
				zonas_tempos.setDesc_zona(request.getParameter("desc_zona"));
				zonas_tempos.setSegunda(request.getParameter("segunda"));
				zonas_tempos.setTerca(request.getParameter("terca"));
				zonas_tempos.setQuarta(request.getParameter("quarta"));
				zonas_tempos.setQuinta(request.getParameter("quinta"));
				zonas_tempos.setSexta(request.getParameter("sexta"));
				zonas_tempos.setSabado(request.getParameter("sabado"));
				zonas_tempos.setDomingo(request.getParameter("domingo"));
				
				dao.query(zonas_tempos, "adicionar");
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
