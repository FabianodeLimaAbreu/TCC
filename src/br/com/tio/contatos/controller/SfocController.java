package br.com.tio.contatos.controller;

import javax.persistence.Persistence;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tio.contatos.jpa.JpaSfoc;

@Controller
public class SfocController {
	
	private final JpaSfoc manager;
	
	@Autowired
	public SfocController(JpaSfoc manager){
		this.manager = manager;
	}
	
	@RequestMapping("adicionar")
	public String adiciona(Object objeto){
		manager.adicionar(objeto);
		//response.setStatus(200);
		return "principal";
	}	
}
