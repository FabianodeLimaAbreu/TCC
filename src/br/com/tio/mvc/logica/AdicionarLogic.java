package br.com.tio.mvc.logica;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tio.Cidades;
import br.com.tio.Contatos;
import br.com.tio.Departamentos;
import br.com.tio.Empresas;
import br.com.tio.Estados;
import br.com.tio.Faixas_Acesso;
import br.com.tio.Feriados;
import br.com.tio.Operadores;
import br.com.tio.Perfis;
import br.com.tio.Tipo_Usuario;
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
				
				/*SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				Date date = format.parse(request.getParameter("hora_ini"));
				Time time = new Time(date.getTime());
				*/
				
				faixas_acesso.setId(id);
				faixas_acesso.setHora_ini(request.getParameter("hora_ini"));
				faixas_acesso.setHora_fim(request.getParameter("hora_fim"));
				faixas_acesso.setDesc_faixa(request.getParameter("desc_faixa"));
				
				dao.query(faixas_acesso, acao);
				break;
			case "Feriados":
				Feriados feriados = new Feriados();
				
				feriados.setId(id);
				feriados.setData_feriado(request.getParameter("data_feriado"));
				feriados.setDesc_feriado(request.getParameter("desc_feriado"));
				
				dao.query(feriados, acao);				
				break;		
			case "Operadores":				
				Operadores operadores = new Operadores();
				
				Perfis cod_perf = new Perfis();
				cod_perf.setId(Long.parseLong(request.getParameter("cod_perf")));
				
				Usuarios login = new Usuarios();
				login.setId(Long.parseLong(request.getParameter("login")));
				
				operadores.setId(id);
				operadores.setLogin(login);
				operadores.setPerfis(cod_perf);
				
				/********************SELECT NA USUARIOS PARA DESCOBRIR A SENHA***************************/
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("sfoc");
				EntityManager manager = factory.createEntityManager();
				
				List<?> senha = manager.createQuery("SELECT senha FROM Usuarios WHERE COD_USUARIO = "+ login.getId() + "").getResultList();
				
				manager.close();
				factory.close();

				operadores.setSenha(senha.get(0).toString());
				/****************************************************************************************/
				
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
				Usuarios usuarios = new Usuarios();
				
				Empresas cod_emp = new Empresas();
				cod_emp.setId(Long.parseLong(request.getParameter("cod_emp")));
				
				Tipo_Usuario cod_tip = new Tipo_Usuario();
				cod_tip.setId(Long.parseLong(request.getParameter("cod_tip")));
				
				Cidades cod_cidade = new Cidades();
				cod_cidade.setId(Long.parseLong(request.getParameter("cod_cidade")));
				
				Estados cod_estado = new Estados();
				cod_estado.setId(Long.parseLong(request.getParameter("cod_estado")));
				
				Zonas_Tempo cod_zona_tempo = new Zonas_Tempo();
				cod_zona_tempo.setId(Long.parseLong(request.getParameter("cod_zona_tempo")));
				
				Departamentos cod_depto = new Departamentos();
				cod_depto.setId(Long.parseLong(request.getParameter("cod_depto")));
				
				usuarios.setId(id);
				usuarios.setVal_cartao(request.getParameter("val_cartao"));
				usuarios.setCracha(request.getParameter("cracha"));			
				usuarios.setVersao(Integer.parseInt(request.getParameter("versao")));
				usuarios.setCod_emp(cod_emp);
				usuarios.setNome(request.getParameter("nome"));
				usuarios.setNome_abrev(request.getParameter("nome_abrev"));
				usuarios.setCod_tip(cod_tip);
				usuarios.setSenha(request.getParameter("senha"));
				usuarios.setData_nasc(request.getParameter("data_nasc"));
				usuarios.setRua_lgdro(request.getParameter("rua_lgdro"));
				usuarios.setNum_lgdro(Integer.parseInt(request.getParameter("num_lgdro")));
				usuarios.setBairro(request.getParameter("bairro"));
				usuarios.setCompl_lgdro(request.getParameter("compl_lgdro"));
				usuarios.setCidade_lgdro(cod_cidade);
				usuarios.setEstado_lgdro(cod_estado);
				usuarios.setTel(request.getParameter("tel"));
				usuarios.setRg(request.getParameter("rg"));
				usuarios.setEmail(request.getParameter("email"));
				usuarios.setCod_zona_tempo(cod_zona_tempo);
				usuarios.setCod_depto(cod_depto);				
				
				dao.query(usuarios, acao);		
				break;
			case "Visitantes":
				Visitantes visitantes = new Visitantes();
				
				Empresas cod_emp_visit = new Empresas();
				cod_emp_visit.setId(Long.parseLong(request.getParameter("cod_emp")));
				
				Departamentos cod_dpto = new Departamentos();
				cod_dpto.setId(Long.parseLong(request.getParameter("cod_dpto")));
				
				visitantes.setId(id);
				visitantes.setRg(request.getParameter("rg"));
				visitantes.setNome(request.getParameter("nome"));
				visitantes.setCod_emp(cod_emp_visit);
				visitantes.setNum_tel(request.getParameter("num_tel"));
				if (id == null)
					visitantes.setData_cadastro(getDateTime());
				else {
					EntityManagerFactory factoryVisit = Persistence.createEntityManagerFactory("sfoc");
					EntityManager managerVisit = factoryVisit.createEntityManager();
					
					List<?> data_cadastro = managerVisit.createQuery("SELECT data_cadastro FROM Visitantes WHERE COD_VISITANTE = "+ id + "").getResultList();
					
					managerVisit.close();
					factoryVisit.close();
					visitantes.setData_cadastro(data_cadastro.get(0).toString());
				}	

				visitantes.setData_ultima_ed(getDateTime());
				visitantes.setCod_foto(request.getParameter("cod_foto"));
				visitantes.setObs(request.getParameter("obs"));
				visitantes.setCod_dpto(cod_dpto);
				
				dao.query(visitantes, acao);
				break;
			case "Zonas_Tempo":
				Zonas_Tempo zonas_tempos = new Zonas_Tempo();
				Faixas_Acesso faixa_acesso_1 = new Faixas_Acesso();
				Faixas_Acesso faixa_acesso_2 = new Faixas_Acesso();
				Faixas_Acesso faixa_acesso_3 = new Faixas_Acesso();

				
				zonas_tempos.setId(id);
				
				faixa_acesso_1.setId(Long.parseLong(request.getParameter("cod_faixa_1")));
				zonas_tempos.setCod_faixa_1(faixa_acesso_1);

				faixa_acesso_2.setId(Long.parseLong(request.getParameter("cod_faixa_2")));
				zonas_tempos.setCod_faixa_2(faixa_acesso_2);
				
				faixa_acesso_3.setId(Long.parseLong(request.getParameter("cod_faixa_3")));
				zonas_tempos.setCod_faixa_3(faixa_acesso_3);

				zonas_tempos.setDesc_zona_tempo(request.getParameter("desc_zona"));
				
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
	private String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
}
