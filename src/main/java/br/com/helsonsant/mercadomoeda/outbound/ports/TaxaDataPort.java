package br.com.helsonsant.mercadomoeda.outbound.ports;

import br.com.helsonsant.mercadomoeda.domain.Taxa;

import java.util.List;

public interface TaxaDataPort {
    void addTaxa(Taxa taxa);
    List<Taxa> getTaxas();
    Taxa getTaxa(String segmento);
    void deleteTaxa(String segmento);
}
