package br.com.helsonsant.mercadomoeda.outbound.adapters;

import br.com.helsonsant.mercadomoeda.domain.Taxa;
import br.com.helsonsant.mercadomoeda.outbound.TaxaH2Repository;
import br.com.helsonsant.mercadomoeda.outbound.ports.TaxaDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class H2DataAdapter implements TaxaDataPort {

    private TaxaH2Repository repository;

    @Autowired
    public H2DataAdapter(TaxaH2Repository repository) {
        this.repository = repository;
    }

    @Override
    public void addTaxa(Taxa taxa) {
        repository.save(taxa);
    }

    @Override
    public List<Taxa> getTaxas() {
        return repository.findAll();
    }

    @Override
    public Taxa getTaxa(String segmento) {
        return repository.findById(segmento).orElse(null);
    }

    @Override
    public void deleteTaxa(String segmento) {
        Taxa taxa = repository.findById(segmento).orElse(null);
        if (taxa != null){
            repository.delete(taxa);
        }
    }
}
