package br.com.helsonsant.mercadomoeda.service;

import br.com.helsonsant.mercadomoeda.domain.Taxa;

import java.util.List;

public interface TaxaPort {
    void createTaxa(Taxa taxa);
    void saveTaxa(Taxa taxa);
    List<Taxa> taxas();
    Taxa getTaxa(String segmento);
    void deleteTaxa(String segmento);
}
