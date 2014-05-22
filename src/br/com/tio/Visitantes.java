package br.com.tio;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Visitantes {

	@Id
	@GeneratedValue
	@Column(name="COD_VISITANTE", length=11, nullable=false)
	private Long id;

	@Column(name="RG_VISITANTE", length=20, nullable=false)
	private String rg;
	
	@Column(name="CPF_VISITANTE", length=11, nullable=true)
	private String cpf;
	
	@Column(name="NOME_VISITANTE", length=256, nullable=false)
	private String nome;
	
	@Column(name="COD_EMP_VISITANTE", length=11, nullable=false)
	private int cod_emp;
	
	@Column(name="VEICULO_VISITANTE", length=50, nullable=true)
	private String veiculo;
	
	@Column(name="PLACA_VISITANTE", length=20, nullable=true)
	private String placa;
	
	@Column(name="CRACHA_VISITANTE", length=30, nullable=false)
	private String cracha;
	
	@Column(name="LOCAL_ACESSO_VISITANTE", length=256, nullable=true)
	private String local_acesso;
	
	@Column(name="OBS_VISITANTE", length=256, nullable=true)
	private String obs;
	
	@Column(name="ASSUNTO_VISITANTE", length=256, nullable=true)
	private String assunto;
	
	@Column(name="DATA_CADASTRO_VISITANTE", nullable=false)
	//@Temporal(TemporalType.DATE)
	//private Calendar data_cadastro;
	private String data_cadastro;
	
	@Column(name="ENTRADA_VISITANTE", nullable=false)
	//@Temporal(TemporalType.DATE)
	//private Calendar data_entrada;
	private String data_entrada;
	
	@Column(name="SAIDA_VISITANTE", nullable=false)
	//@Temporal(TemporalType.DATE)
	//private Calendar data_saida;
	private String data_saida;
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCod_emp() {
		return cod_emp;
	}

	public void setCod_emp(int cod_emp) {
		this.cod_emp = cod_emp;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCracha() {
		return cracha;
	}

	public void setCracha(String cracha) {
		this.cracha = cracha;
	}

	public String getLocal_acesso() {
		return local_acesso;
	}

	public void setLocal_acesso(String local_acesso) {
		this.local_acesso = local_acesso;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}

	public String getData_saida() {
		return data_saida;
	}

	public void setData_saida(String data_saida) {
		this.data_saida = data_saida;
	}

	public Long getId() {
		return id;
	}
}