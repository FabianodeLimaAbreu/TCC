package br.com.tio;

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
	
	@OneToOne
	@JoinColumn(name = "LOGIN_OPERADOR")
	private Usuarios login;
	
	@Column(name = "SENHA_OPERADOR", length = 20, nullable = false)
	private String senha;
	
	@OneToOne
	@JoinColumn(name="COD_PERF_OPERADOR")
	private Perfis perfis;

	public Perfis getPerfis() {
		return perfis;
	}
	
	public void setPerfis(Perfis perfis) {
		this.perfis = perfis; 
	}

	public Usuarios getLogin() {
		return login;
	}

	public void setLogin(Usuarios login) {
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
