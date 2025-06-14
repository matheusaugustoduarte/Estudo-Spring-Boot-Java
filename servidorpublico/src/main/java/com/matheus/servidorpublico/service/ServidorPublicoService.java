package com.matheus.servidorpublico.service;

import com.matheus.servidorpublico.model.ServidorPublico;
import java.util.List;
import java.util.Optional;

public interface ServidorPublicoService {
    // Retorna uma lista de objeto da classe (ServidorPublico) que é o model.
    List<ServidorPublico> listAll();

    // Busca um único objeto ServidorPublico pela matrícula e o retorno encapsula em um Optional.
    Optional<ServidorPublico> listByMatricula(long matricula);

}
