package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Estados {

	@Id
	@GeneratedValue
	@Column(name = "ID", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "ESTADO", length = 150, nullable = false)
	private String estado;
	
	@Column(name = "UF", length = 2, nullable = false)
	private String uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
