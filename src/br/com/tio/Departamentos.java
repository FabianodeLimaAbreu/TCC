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
	
	@Column(name = "DESC_DPTO", length = 256, nullable = false)
	private String desc_dpto;
	
}
