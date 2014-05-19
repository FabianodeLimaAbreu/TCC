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
	@Column(name="COD_VISITANTE", length=11, nullable=false)
	private Long id;

	@Column(name="RG_VISITANTE", length=20, nullable=false)
	private String rg;
	
	@Column(name="CPF_VISITANTE", length=11, nullable=true)
	private String cpf;
	
	@Column(name="NOME_VISITANTE", length=256, nullable=false)
	private String nome;
	
	@Column(name="COD_EMP_VISITANTE", length=11, nullable=false)
	private int cod_emp;
	
	@Column(name="VEICULO_VISITANTE", length=50, nullable=true)
	private String veiculo;
	
	@Column(name="PLACA_VISITANTE", length=20, nullable=true)
	private String palca;
	
	@Column(name="CRACHA_VISITANTE", length=30, nullable=false)
	private String cracha;
	
	@Column(name="LOCAL_ACESSO_VISITANTE", length=256, nullable=true)
	private String local_acesso;
	
	@Column(name="OBS_VISITANTE", length=256, nullable=true)
	private String obs;
	
	@Column(name="ASSUNTO_VISITANTE", length=256, nullable=true)
	private String assunto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_CADASTRO_VISITANTE", nullable=false)
	private Calendar data_cadastro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ENTRADA_VISITANTE", nullable=false)
	private Calendar data_entrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="SAIDA_VISITANTE", nullable=false)
	private Calendar data_saida;
}