package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	@Column(name = "COD_PERF_OPERADOR", length = 11, nullable = false)
	private int cod_perf;

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

	public int getCod_perf() {
		return cod_perf;
	}

	public void setCod_perf(int cod_perf) {
		this.cod_perf = cod_perf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
