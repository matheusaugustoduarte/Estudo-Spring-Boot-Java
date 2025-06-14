package com.matheus.servidorpublico.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheus.servidorpublico.model.ServidorPublico;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class ServidorPublicoServiceImpl implements ServidorPublicoService{

    // Constante de não pode ser alterada e ainda somente usada dentro da classe por conta do modificado private.
    private final String SERVIDOR = "/data/servidorpublico.json";

    @Override
    public List<ServidorPublico> listAll() {

        try {
            // TypeReference é classe usada para lidar com informações genericas em tempo de execução, usar para manipular arquivos JSON.
            TypeReference<List<ServidorPublico>> typeref = new TypeReference<List<ServidorPublico>>(){};

            // InputStream lida com dados em formato byte, ler esses formatos.
            // getResourceAsStream permite ler arquivo dentro do Java.
            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

            List<ServidorPublico> servidorepublicos = new ObjectMapper().readValue(inputStream, typeref);

            return servidorepublicos;

        } catch (Exception e) {
            System.out.println("Exceção "+e.getMessage());
            return null;
        }

    }

    @Override
    public Optional<ServidorPublico> listByMatricula(long matricula) {
        try {
            // TypeReference é classe usada para lidar com informações genericas em tempo de execução, usar para manipular arquivos JSON.
            TypeReference<List<ServidorPublico>> typeref = new TypeReference<List<ServidorPublico>>(){};

            // InputStream lida com dados em formato byte, ler esses formatos.
            // getResourceAsStream permite ler arquivo dentro do Java.
            InputStream inputStream = TypeReference.class.getResourceAsStream(SERVIDOR);

            List<ServidorPublico> servidorespublicos = new ObjectMapper().readValue(inputStream, typeref);

            Optional<ServidorPublico> servidorEncontrado = servidorespublicos.stream()
                    .filter(servidor -> servidor.matricula().equals(Long.valueOf(matricula)))
                    .findFirst();

            return servidorEncontrado;


        } catch (Exception e) {
            System.out.println("Exceção "+e.getMessage());
            return null;
        }
    }
}
