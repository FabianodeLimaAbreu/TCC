package br.com.tio;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Faixas_Acesso {

	@Id
	@GeneratedValue
	@Column(name = "COD_FAIXA", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "HORA_INICIO_FAIXA", nullable = false)
	@Temporal(TemporalType.TIME)
	private Time hora_ini;
	
	@Column(name = "HORA_FIM_FAIXA", nullable = false)
	@Temporal(TemporalType.TIME)
	private Time hora_fim;	
}