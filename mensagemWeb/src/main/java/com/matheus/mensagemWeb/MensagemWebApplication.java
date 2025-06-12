package com.matheus.mensagemWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MensagemWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensagemWebApplication.class, args);
	}

	//CRUD
	//Onde tudo começa, é o barra padrão que traz cada um dos links abaixo para os métodos.
	@GetMapping("/")
	public  String init(){
		return(
				"<a href=\"criarRegistro\">Criar Registro</a><br />" +
				"<a href=\"lerRegistro\">Ler Registro</a><br />" +
				"<a href=\"atualizarRegistro\">Atualizar Registro</a><br />" +
				"<a href=\"deletarRegistro\">Excluir Registro</a><br />");
	}

	@GetMapping("/criarRegistro")
	public String criarRegistro(){
		return ("Criação de um Registro");
	}

	@GetMapping("/lerRegistro")
	public String lerRegistro(){
		return ("Leitura de um Registro");
	}

	@GetMapping("/atualizarRegistro")
	public String atualizarRegistro(){
		return ("Atualização de um Registro");
	}

	@GetMapping("/deletarRegistro")
	public String deletarRegistro(){
		return ("Exclusão de um Registro");
	}

}
