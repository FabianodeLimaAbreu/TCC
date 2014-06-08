package br.com.tio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="visitantes")
public class Visitantes {

	@Id
	@GeneratedValue
	@Column(name="COD_VISITANTE", length=11, nullable=false)
	private Long id;

	@Column(name="RG_VISITANTE", length=20, nullable=false)
	private String rg;
	
	@Column(name="NOME_VISITANTE", length=256, nullable=false)
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "COD_EMP_VISITANTE")
	private Empresas cod_emp;
	
	@Column(name = "TELEFONE_VISITANTE", length = 20, nullable = false)
	private String num_tel;
	
	@Column(name="DATA_CADASTRO_VISITANTE", nullable=false)
	private String data_cadastro;

	@Column(name = "DATA_ULTIMA_ED", nullable = false)
	private String data_ultima_ed;
	
	@Column(name = "COD_FOTO_VISITANTE", length = 256, nullable = true)
	private String cod_foto;
	
	@Column(name="OBS_VISITANTE", length=256, nullable=true)
	private String obs;
	
	@OneToOne
	@JoinColumn(name = "COD_DPTO")
	private Departamentos cod_dpto;
	
	public Departamentos getCod_dpto() {
		return cod_dpto;
	}

	public void setCod_dpto(Departamentos cod_dpto) {
		this.cod_dpto = cod_dpto;
	}

	/*	@OneToMany(mappedBy = "cod_dpto", cascade = CascadeType.ALL)
	private List<Visitantes_Departamentos> vist_dpto;	

	public List<Visitantes_Departamentos> getVist_dpto() {
		return vist_dpto;
	}

	public void setVist_dpto(List<Visitantes_Departamentos> vist_dpto) {
		this.vist_dpto = vist_dpto;
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empresas getCod_emp() {
		return cod_emp;
	}

	public void setCod_emp(Empresas cod_emp) {
		this.cod_emp = cod_emp;
	}

	public String getNum_tel() {
		return num_tel;
	}

	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}

	public String getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getData_ultima_ed() {
		return data_ultima_ed;
	}

	public void setData_ultima_ed(String data_ultima_ed) {
		this.data_ultima_ed = data_ultima_ed;
	}

	public String getCod_foto() {
		return cod_foto;
	}

	public void setCod_foto(String cod_foto) {
		this.cod_foto = cod_foto;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
}