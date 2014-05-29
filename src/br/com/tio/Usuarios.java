package br.com.tio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue
	@Column(name="COD_USUARIO", length=11, nullable=false)
	private Long id;
	
	@Column(name="VALIDADE_CARTAO_USUARIO", nullable=true)
	private String val_cartao;
	
	@Column(name="CRACHA_USUARIO", length=30, nullable=false)
	private String cracha;
	
	@Column(name = "VERSAO", length=11, nullable=true)
	private int versao;
	
	@OneToOne
	@JoinColumn(name = "COD_EMP_USUARIO")
	private Empresas cod_emp;
	
	@Column(name="NOME_USUARIO", length=256, nullable=false)
	private String nome;
	
	@Column(name="NOME_ABREV_USUARIO", length=45, nullable=false)
	private String nome_abrev;
	
	@OneToOne
	@JoinColumn(name = "COD_TIP_USUARIO")
	private Tipo_Usuario cod_tip;
	
	@Column(name="SENHA_USUARIO", length=20, nullable=true)
	private String senha;
	
	public String getVal_cartao() {
		return val_cartao;
	}

	public void setVal_cartao(String val_cartao) {
		this.val_cartao = val_cartao;
	}

	public String getCracha() {
		return cracha;
	}

	public void setCracha(String cracha) {
		this.cracha = cracha;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	public Empresas getCod_emp() {
		return cod_emp;
	}

	public void setCod_emp(Empresas cod_emp) {
		this.cod_emp = cod_emp;
	}

	public Tipo_Usuario getCod_tip() {
		return cod_tip;
	}

	public void setCod_tip(Tipo_Usuario cod_tip) {
		this.cod_tip = cod_tip;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_abrev() {
		return nome_abrev;
	}

	public void setNome_abrev(String nome_abrev) {
		this.nome_abrev = nome_abrev;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
