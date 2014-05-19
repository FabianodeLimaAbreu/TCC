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
}
