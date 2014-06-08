package br.com.tio;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Faixas_Acesso {
	
	@Id
	@GeneratedValue
	@Column(name = "COD_FAIXA", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "HORA_INICIO_FAIXA", length = 10, nullable = false)
	private String hora_ini;
	
	@Column(name = "HORA_FIM_FAIXA", length = 10, nullable = false)
	private String hora_fim;
	
	@Column(name = "DESC_FAIXA", length = 256, nullable = true)
	private String desc_faixa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHora_ini() {
		return hora_ini;
	}

	public void setHora_ini(String hora_ini) {
		this.hora_ini = hora_ini;
	}

	public String getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(String hora_fim) {
		this.hora_fim = hora_fim;
	}

	public String getDesc_faixa() {
		return desc_faixa;
	}

	public void setDesc_faixa(String desc_faixa) {
		this.desc_faixa = desc_faixa;
	}
}
