package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Perfis {

	@Id
	@GeneratedValue
	@Column(name = "COD_PERFIL", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "NOME_PERF", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "DESC_PERF", length = 256, nullable = false)
	private String desc_perfil;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome_perfil) {
		this.nome = nome_perfil;
	}

	public String getDesc_perfil() {
		return desc_perfil;
	}

	public void setDesc_perfil(String desc_perfil) {
		this.desc_perfil = desc_perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
