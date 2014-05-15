package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departamentos {
	
	@Id
	@GeneratedValue
	@Column(name="cod_dpto", length=11, nullable=false)
	private Long id;
	
	@Column(length=256, nullable=false)
	private String desc_depto;
	
}
