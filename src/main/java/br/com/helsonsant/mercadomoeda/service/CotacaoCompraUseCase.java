package br.com.helsonsant.mercadomoeda.service;

import br.com.helsonsant.mercadomoeda.domain.CotacaoCompraMoedaEstrangeira;
import br.com.helsonsant.mercadomoeda.domain.CotacaoMoedaEstrangeira;
import br.com.helsonsant.mercadomoeda.domain.MoedaEstrangeira;
import br.com.helsonsant.mercadomoeda.domain.Taxa;
import br.com.helsonsant.mercadomoeda.inbound.ports.CotacaoCompraPort;
import br.com.helsonsant.mercadomoeda.outbound.ports.CotacaoPort;
import br.com.helsonsant.mercadomoeda.outbound.ports.TaxaDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CotacaoCompraUseCase implements CotacaoCompraPort {
    private final TaxaDataPort taxaData;
    private final CotacaoPort cotacaoMoedaEstrangeira;
    private MoedaEstrangeira moeda;

    @Autowired
    public CotacaoCompraUseCase(TaxaDataPort taxaData, CotacaoPort cotacaoMoedaEstrangeira){
        this.taxaData = taxaData;
        this.cotacaoMoedaEstrangeira = cotacaoMoedaEstrangeira;
    }

    @Override
    public CotacaoCompraMoedaEstrangeira getCotacaoCompraMoedaEstrangeira(CotacaoCompraMoedaEstrangeira cotacao) {
        CotacaoMoedaEstrangeira cotacaoMoeda = cotacaoMoedaEstrangeira.getCotacao(cotacao.getMoeda());
        Taxa taxa = this.taxaData.getTaxa(cotacao.getSegmento());
        cotacao.setTaxa(taxa.getTaxa());
        double valorCotacaoMoeda;
        if (cotacao.getMoeda().equalsIgnoreCase("USD")){
            valorCotacaoMoeda = Double.valueOf(cotacaoMoeda.getUsdBrl().getHigh());
        } else {
            valorCotacaoMoeda = Double.valueOf(cotacaoMoeda.getEurBrl().getHigh());
        }
        cotacao.setValorEmReais(cotacao.getQuantidade() * 1.0 * valorCotacaoMoeda * (1 + cotacao.getTaxa()));
        return cotacao;
    }

}
