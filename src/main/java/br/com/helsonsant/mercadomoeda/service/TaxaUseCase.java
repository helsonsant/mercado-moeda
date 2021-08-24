package br.com.helsonsant.mercadomoeda.service;

import br.com.helsonsant.mercadomoeda.domain.Taxa;
import br.com.helsonsant.mercadomoeda.outbound.ports.TaxaDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxaUseCase implements TaxaPort {
    private TaxaDataPort taxaData;

    @Autowired
    public TaxaUseCase(TaxaDataPort taxaData) {
        this.taxaData = taxaData;
    }

    @Override
    public void createTaxa(Taxa taxa) {
        taxaData.addTaxa(taxa);
    }

    @Override
    public void saveTaxa(Taxa taxa) {
        taxaData.addTaxa(taxa);
    }

    @Override
    public List<Taxa> taxas() {
        return taxaData.getTaxas();
    }

    @Override
    public Taxa getTaxa(String segmento) {
        return taxaData.getTaxa(segmento);
    }

    @Override
    public void deleteTaxa(String segmento) {
        taxaData.deleteTaxa(segmento);
    }
}
