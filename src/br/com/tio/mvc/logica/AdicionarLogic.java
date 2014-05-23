package br.com.tio.mvc.logica;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.Contatos;
import br.com.tio.Departamentos;
import br.com.tio.Empresas;
import br.com.tio.Faixas_Acesso;
import br.com.tio.Feriados;
import br.com.tio.Operadores;
import br.com.tio.Perfis;
import br.com.tio.Usuarios;
import br.com.tio.Visitantes;
import br.com.tio.Zonas_Tempo;
import br.com.tio.jpa.ExecHibernate;

public class AdicionarLogic implements Logica{
	public void executa(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		
		PrintWriter out = response.getWriter();
		
		ExecHibernate dao = new ExecHibernate();
		String acao;

		try{
			String table = request.getParameter("table");
			Long id = Long.parseLong(request.getParameter("id"));
			
			if (id == 0) {
				id = null;
				acao = "adicionar"; 
			} else {
				acao = "editar";
			}				
			
			switch (table) {
			case "Contatos":
				String nomeContato = request.getParameter("nome");
				
				Contatos contatos = new Contatos();
				
				contatos.setId(id);
				contatos.setNome(nomeContato);		
				
				dao.query(contatos, acao);
				break;
			case "Departamentos":				
				Departamentos departamentos = new Departamentos();
				
				departamentos.setId(id);
				departamentos.setDesc_dpto(request.getParameter("desc_dpto"));
				
				dao.query(departamentos, acao);				
				break;
			case "Empresas":		
				Empresas empresas = new Empresas();
				
				empresas.setId(id);
				empresas.setRazao_social(request.getParameter("razao_social"));
				empresas.setNome_fantasia(request.getParameter("nome_fantasia"));
				empresas.setTelefone(request.getParameter("telefone"));
				
				dao.query(empresas, acao);
				break;
			case "Faixas_Acesso":
				Faixas_Acesso faixas_acesso = new Faixas_Acesso();
				
				faixas_acesso.setId(id);
				faixas_acesso.setHora_ini(request.getParameter("hora_ini"));
				faixas_acesso.setHora_fim(request.getParameter("hora_fim"));
				
				dao.query(faixas_acesso, acao);
				break;
			case "Feriados":
				Feriados feriados = new Feriados();
				
				/*dataEmTexto = request.getParameter("data_feriado");
				Calendar data_feriado = null;
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					data_feriado = Calendar.getInstance();
					data_feriado.setTime(date);					
				} catch (ParseException e) {
					out.print("Erro na conversão de data");
				}*/
				
				feriados.setId(id);
				feriados.setData_feriado(request.getParameter("data_feriado"));
				feriados.setDesc_feriado(request.getParameter("desc_feriado"));
				
				dao.query(feriados, acao);				
				break;		
			case "Operadores":
				Operadores operadores = new Operadores();
				
				operadores.setId(id);
				operadores.setLogin(Integer.parseInt(request.getParameter("login")));
				operadores.setSenha(request.getParameter("senha"));
				operadores.setCod_perf(Integer.parseInt(request.getParameter("cod_perf")));
				
				dao.query(operadores, acao);				
				break;
			case "Perfis":
				Perfis perfis = new Perfis();
				
				perfis.setId(id);
				perfis.setNome(request.getParameter("nome"));
				perfis.setDesc_perfil(request.getParameter("desc_perfil"));
				
				dao.query(perfis, acao);				
				break;
			case "Usuarios":
				/*dataEmTexto = request.getParameter("val_cartao");
				Calendar val_cartao = null;
				//convertendo data
				try{
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					val_cartao = Calendar.getInstance();
					val_cartao.setTime(date);
				}catch (ParseException e) {
					out.print("Erro na conversão de data");
				}*/			
				Usuarios usuarios = new Usuarios();
				
				usuarios.setId(id);
				usuarios.setVal_cartao(request.getParameter("val_cartao"));
				usuarios.setCracha(request.getParameter("cracha"));			
				usuarios.setVersao(Integer.parseInt(request.getParameter("versao")));
				usuarios.setCod_emp(Integer.parseInt(request.getParameter("cod_emp")));
				usuarios.setNome(request.getParameter("nome"));
				usuarios.setNome_abrev(request.getParameter("nome_abrev"));
				usuarios.setCod_tip(Integer.parseInt(request.getParameter("cod_tip")));
				usuarios.setSenha(request.getParameter("senha"));
				
				dao.query(usuarios, acao);		
				break;
			case "Visitantes":
				Visitantes visitantes = new Visitantes();
				//Foi retirado todos os tratamentos de data com Calendar dessa classe
				
				visitantes.setId(id);
				visitantes.setRg(request.getParameter("rg"));
				visitantes.setCpf(request.getParameter("cpf"));
				visitantes.setNome(request.getParameter("nome"));
				visitantes.setCod_emp(Integer.parseInt(request.getParameter("cod_emp")));
				visitantes.setVeiculo(request.getParameter("veiculo"));
				visitantes.setPlaca(request.getParameter("placa"));
				visitantes.setCracha(request.getParameter("cracha"));
				visitantes.setLocal_acesso(request.getParameter("local_acesso"));
				visitantes.setObs(request.getParameter("obs"));
				visitantes.setAssunto(request.getParameter("assunto"));
				visitantes.setData_cadastro(request.getParameter("data_cadastro"));
				visitantes.setData_entrada(request.getParameter("data_entrada"));
				visitantes.setData_entrada(request.getParameter("data_saida"));
				
				dao.query(visitantes, acao);
				break;
			case "Zonas_Tempo":
				Zonas_Tempo zonas_tempos = new Zonas_Tempo();
				
				zonas_tempos.setId(id);
				zonas_tempos.setDesc_zona(request.getParameter("desc_zona"));
				zonas_tempos.setSegunda(request.getParameter("segunda"));
				zonas_tempos.setTerca(request.getParameter("terca"));
				zonas_tempos.setQuarta(request.getParameter("quarta"));
				zonas_tempos.setQuinta(request.getParameter("quinta"));
				zonas_tempos.setSexta(request.getParameter("sexta"));
				zonas_tempos.setSabado(request.getParameter("sabado"));
				zonas_tempos.setDomingo(request.getParameter("domingo"));
				
				dao.query(zonas_tempos, acao);
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
