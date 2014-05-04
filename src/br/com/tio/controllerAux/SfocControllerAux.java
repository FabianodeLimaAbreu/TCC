package br.com.tio.controllerAux;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SfocControllerAux {

	@RequestMapping("/principal")
	public String principal(){
		System.out.println("Executando Spring");
		return "principal";
	}
}
