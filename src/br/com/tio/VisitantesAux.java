package br.com.tio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VisitantesAux {

@Id
@GeneratedValue
private Long id;

private String visitante;
private int qtd;
public String getVisitante() {
	return visitante;
}
public void setVisitante(String visitante) {
	this.visitante = visitante;
}
public int getQtd() {
	return qtd;
}
public void setQtd(int qtd) {
	this.qtd = qtd;
}
public Long getId() {
	return id;
}
}
