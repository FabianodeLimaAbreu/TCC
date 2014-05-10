package br.com.tio;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Visitantes {

	@Id
	@GeneratedValue
	@Column(name="cod_visitante", length=11, nullable=false)
	private Long id;

	@Column(name="rg_visitante", length=20, nullable=false)
	private String rg;
	
	@Column(name="cpf_visitante", length=11, nullable=true)
	private String cpf;
	
	@Column(name="nome_visitante", length=256, nullable=false)
	private String nome;
	
	@Column(name="cod_emp_visistante", length=11, nullable=false)
	private int cod_emp;
	
	@Column(name="veiculo_visitante", length=50, nullable=true)
	private String veiculo;
	
	@Column(name="placa_visitante", length=20, nullable=true)
	private String palca;
	
	@Column(name="cracha_visitante", length=30, nullable=false)
	private String cracha;
	
	@Column(name="local_acesso_visitante", length=256, nullable=true)
	private String local_acesso;
	
	@Column(name="obs_visitante", length=256, nullable=true)
	private String obs;
	
	@Column(name="assunto_visitante", length=256, nullable=true)
	private String assunto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro_visitante", nullable=false)
	private Calendar data_cadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="entrada_visitante", nullable=false)
	private Calendar data_entrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="saida_visitante", nullable=false)
	private Calendar data_saida;
}

