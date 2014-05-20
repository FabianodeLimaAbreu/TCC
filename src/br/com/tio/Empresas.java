package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Empresas {

	@Id
	@GeneratedValue
	@Column(name = "COD_EMP", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "RAZAO_SOCIAL_EMP", length = 256, nullable = false)
	private String razao_social;

	@Column(name = "NOME_FANTASIA_EMP", length = 256, nullable = false)
	private String nome_fantasia;
	
	@Column(name = "TELEFONE_EMP", length = 20, nullable = true)
	private String telefone;
	
	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

}
