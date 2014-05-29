package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tipo_Usuario {

	@Id
	@GeneratedValue
	@Column(name = "COD_TIP_USUARIO", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "DESC_TIP_USUARIO", length = 30, nullable = false)
	private String desc_usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc_usuario() {
		return desc_usuario;
	}

	public void setDesc_usuario(String desc_usuario) {
		this.desc_usuario = desc_usuario;
	}
}
