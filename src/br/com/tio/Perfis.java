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
	private String nome_perfil;
	
	@Column(name = "DESC_PERF", length = 256, nullable = false)
	private String desc_perfil;
}
