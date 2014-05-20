package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departamentos {
	
	@Id
	@GeneratedValue
	@Column(name = "COD_DPTO", length = 11, nullable = false)
	private Long id;
	
	public String getDesc_dpto() {
		return desc_dpto;
	}

	public void setDesc_dpto(String desc_dpto) {
		this.desc_dpto = desc_dpto;
	}

	public Long getId() {
		return id;
	}

	@Column(name = "DESC_DPTO", length = 256, nullable = false)
	private String desc_dpto;
	
}
