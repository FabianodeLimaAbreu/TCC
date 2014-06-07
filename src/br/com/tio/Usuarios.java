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
	
	@Column(name = "DT_NASC_USUARIO", nullable = false)
	private String data_nasc;
	
	@Column(name = "RUA_LGDRO_USUARIO", length = 256, nullable = false)
	private String rua_lgdro;
	
	@Column(name = "NUMERO_LGDRO_USUARIO", length = 11, nullable = false)
	private int num_lgdro;
	
	@Column(name = "BAIRRO_LGDRO_USUARIO", length = 256, nullable = false)
	private String bairro;
	
	@Column(name = "COMPLEMENTO_LGDRO_USUARIO", length = 256, nullable = true)
	private String compl_lgdro;
	
	@OneToOne
	@JoinColumn(name = "CIDADE_LGDRO_USUARIO")
	private Cidades cidade_lgdro;
	
	@OneToOne
	@JoinColumn(name = "ESTADO_LGDRO_USUARIO")
	private Estados estado_lgdro;
	
	@Column(name = "TELEFONE_USUARIO", length = 45, nullable = false)
	private String tel;
	
	@Column(name = "RG_USUARIO", length = 20, nullable = false)
	private String rg;
	
	@Column(name = "EMAIL_USUARIO", length = 256, nullable = false)
	private String email;
	
	@OneToOne
	@JoinColumn(name = "COD_ZONA_TEMPO_USUARIO")
	private Zonas_Tempo cod_zona_tempo;
	
	@OneToOne
	@JoinColumn(name = "COD_DEPTO_USUARIO")
	private Departamentos cod_depto;	
	
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

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getRua_lgdro() {
		return rua_lgdro;
	}

	public void setRua_lgdro(String rua_lgdro) {
		this.rua_lgdro = rua_lgdro;
	}

	public int getNum_lgdro() {
		return num_lgdro;
	}

	public void setNum_lgdro(int num_lgdro) {
		this.num_lgdro = num_lgdro;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCompl_lgdro() {
		return compl_lgdro;
	}

	public void setCompl_lgdro(String compl_lgdro) {
		this.compl_lgdro = compl_lgdro;
	}

	public Cidades getCidade_lgdro() {
		return cidade_lgdro;
	}

	public void setCidade_lgdro(Cidades cidade_lgdro) {
		this.cidade_lgdro = cidade_lgdro;
	}

	public Estados getEstado_lgdro() {
		return estado_lgdro;
	}

	public void setEstado_lgdro(Estados estado_lgdro) {
		this.estado_lgdro = estado_lgdro;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Zonas_Tempo getCod_zona_tempo() {
		return cod_zona_tempo;
	}

	public void setCod_zona_tempo(Zonas_Tempo cod_zona_tempo) {
		this.cod_zona_tempo = cod_zona_tempo;
	}

	public Departamentos getCod_depto() {
		return cod_depto;
	}

	public void setCod_depto(Departamentos cod_depto) {
		this.cod_depto = cod_depto;
	}
}
