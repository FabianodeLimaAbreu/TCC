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
}
