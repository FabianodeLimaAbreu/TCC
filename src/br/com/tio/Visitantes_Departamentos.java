package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Visitantes_Departamentos {
	
	@Id
	@GeneratedValue
	@Column(name = "COD_DPTO", length = 11, nullable = false)
	private Long id_dpto;
	
	@Column(name = "COD_VISITANTE", length = 11, nullable = false)
	private Long id_vist;
	
}
