package br.com.tio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Operadores {

	@Id
	@GeneratedValue
	@Column(name = "COD_OPERADOR", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "LOGIN_OPERADOR", length = 11, nullable = false)
	private int login;
	
	@Column(name = "SENHA_OPERADOR", length = 20, nullable = false)
	private String senha;
	
	//@Column(name = "COD_PERF_OPERADOR", length = 11, nullable = false)
	//private int cod_perf_aux;
	
	@OneToOne
	@JoinColumn(name="COD_PERF_OPERADOR")
	private Perfis perfis;

	public Perfis getPerfis() {
		return perfis;
	}
	
	public void setPerfis(Perfis perfis) {
		this.perfis = perfis; 
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}
