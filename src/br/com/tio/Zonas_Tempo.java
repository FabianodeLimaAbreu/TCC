package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Zonas_Tempo {

	@Id
	@GeneratedValue
	@Column(name = "COD_ZONA", length = 11, nullable = false)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "COD_FAIXA_1")
	private Faixas_Acesso cod_faixa_1;
	
	@OneToOne
	@JoinColumn(name = "COD_FAIXA_2")
	private Faixas_Acesso cod_faixa_2;
	
	@OneToOne
	@JoinColumn(name = "COD_FAIXA_3")
	private Faixas_Acesso cod_faixa_3;
	
	@Column(name = "DESC_ZONA_TEMPO", length = 256, nullable = false)
	private String desc_zona_tempo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Faixas_Acesso getCod_faixa_1() {
		return cod_faixa_1;
	}

	public void setCod_faixa_1(Faixas_Acesso cod_faixa_1) {
		this.cod_faixa_1 = cod_faixa_1;
	}

	public Faixas_Acesso getCod_faixa_2() {
		return cod_faixa_2;
	}

	public void setCod_faixa_2(Faixas_Acesso cod_faixa_2) {
		this.cod_faixa_2 = cod_faixa_2;
	}

	public Faixas_Acesso getCod_faixa_3() {
		return cod_faixa_3;
	}

	public void setCod_faixa_3(Faixas_Acesso cod_faixa_3) {
		this.cod_faixa_3 = cod_faixa_3;
	}

	public String getDesc_zona_tempo() {
		return desc_zona_tempo;
	}

	public void setDesc_zona_tempo(String desc_zona_tempo) {
		this.desc_zona_tempo = desc_zona_tempo;
	}
}
