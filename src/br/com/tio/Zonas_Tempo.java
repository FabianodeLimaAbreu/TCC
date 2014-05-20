package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Zonas_Tempo {

	@Id
	@GeneratedValue
	@Column(name = "COD_ZONA", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "DESC_ZONA", length = 256, nullable = false)
	private String desc_zona;
	
	@Column(name = "SEGUNDA", length = 6, nullable = true)
	private String segunda;
	
	@Column(name = "TERCA", length = 6, nullable = true)
	private String terca;

	@Column(name = "QUARTA", length = 6, nullable = true)
	private String quarta;

	@Column(name = "QUINTA", length = 6, nullable = true)
	private String quinta;

	@Column(name = "SEXTA", length = 6, nullable = true)
	private String sexta;

	@Column(name = "SABADO", length = 6, nullable = true)
	private String sabado;

	@Column(name = "DOMINGO", length = 6, nullable = true)
	private String domingo;

	public String getDesc_zona() {
		return desc_zona;
	}

	public void setDesc_zona(String desc_zona) {
		this.desc_zona = desc_zona;
	}

	public String getSegunda() {
		return segunda;
	}

	public void setSegunda(String segunda) {
		this.segunda = segunda;
	}

	public String getTerca() {
		return terca;
	}

	public void setTerca(String terca) {
		this.terca = terca;
	}

	public String getQuarta() {
		return quarta;
	}

	public void setQuarta(String quarta) {
		this.quarta = quarta;
	}

	public String getQuinta() {
		return quinta;
	}

	public void setQuinta(String quinta) {
		this.quinta = quinta;
	}

	public String getSexta() {
		return sexta;
	}

	public void setSexta(String sexta) {
		this.sexta = sexta;
	}

	public String getSabado() {
		return sabado;
	}

	public void setSabado(String sabado) {
		this.sabado = sabado;
	}

	public String getDomingo() {
		return domingo;
	}

	public void setDomingo(String domingo) {
		this.domingo = domingo;
	}

	public Long getId() {
		return id;
	}
}
