package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cidades {

	@Id
	@GeneratedValue
	@Column(name = "ID", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "ESTADO_ID", length = 11, nullable = false)
	private int estado;
	
	@Column(name = "UF", length = 5, nullable = false)
	private String uf;
	
	@Column(name = "CIDADE", length = 150, nullable = false)
	private String cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}	
}
