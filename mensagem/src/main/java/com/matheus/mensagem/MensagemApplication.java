package com.matheus.mensagem;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MensagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensagemApplication.class, args);
		System.out.println("Primeiro projeto spring boot");
	}
	//CRUD

	@PostConstruct //Manipula o código e as dependências de forma automatizada.
	public static void criarRegistro(){
		System.out.println("Criação de um Registro");
	}

	@PostConstruct
	public static void lerRegistro(){
		System.out.println("Leitura de um Registro");
	}

	@PostConstruct
	public static void atualizarRegistro(){
		System.out.println("Atualização de um Registro");
	}

	@PostConstruct
	public static void deletarRegistro(){
		System.out.println("Exclusão de um Registro");
	}


}
