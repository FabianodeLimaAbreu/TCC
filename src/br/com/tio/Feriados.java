package br.com.tio;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Feriados {

	@Id
	@GeneratedValue
	@Column(name = "COD_FERIADO", length = 11, nullable = false)
	private Long id;
	
	@Column(name = "DATA_FERIADO", nullable = false)
	//@Temporal(TemporalType.DATE)
	//private Calendar data_feriado;
	private String data_feriado;
	
	@Column(name = "DESC_FERIADO", length = 256, nullable = false)
	private String desc_feriado;

	public String getData_feriado() {
		return data_feriado;
	}

	public void setData_feriado(String data_feriado) {
		this.data_feriado = data_feriado;
	}

	public String getDesc_feriado() {
		return desc_feriado;
	}

	public void setDesc_feriado(String desc_feriado) {
		this.desc_feriado = desc_feriado;
	}

	public Long getId() {
		return id;
	}

}
