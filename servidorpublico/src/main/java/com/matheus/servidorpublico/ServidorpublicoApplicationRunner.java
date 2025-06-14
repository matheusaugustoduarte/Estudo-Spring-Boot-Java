package com.matheus.servidorpublico;

import com.matheus.servidorpublico.model.ServidorPublico;
import com.matheus.servidorpublico.service.ServidorPublicoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Configuration
public class ServidorpublicoApplicationRunner implements CommandLineRunner {

    private ServidorPublicoService servidorService;

    @Autowired
    public void setServidorService(ServidorPublicoService servidorService) {
        this.servidorService = servidorService;
    }

    @PostConstruct
    public void listAll(){
        List<ServidorPublico> servidorespublicos = servidorService.listAll();

        if (servidorespublicos.size() != 0){

            System.out.println("##################################################");
            servidorespublicos.forEach(
                    servidor -> {
                        System.out.println(servidor.matricula());
                        System.out.println(servidor.nome());
                        System.out.println(servidor.foto());
                        System.out.println(servidor.orgao());
                    }
            );

        }else{
            System.out.println("Arquivo JSON vazio.");
        }
    }

    @PostConstruct
    public void listByMatricula(){
        long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula procurada: "));
        Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);

        if (servidorEncontrado.isPresent()){
            System.out.println();
            System.out.println("##################################################");
            System.out.println(servidorEncontrado.get().matricula());
            System.out.println(servidorEncontrado.get().nome());
            System.out.println(servidorEncontrado.get().foto());
            System.out.println(servidorEncontrado.get().orgao());
        }
        else{
            System.out.println("Não existe servidor para a matrícula informada.");
        }
    }

    public void run(String... args) throws Exception{

    }
}
