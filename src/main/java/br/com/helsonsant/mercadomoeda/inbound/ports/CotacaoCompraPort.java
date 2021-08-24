package br.com.helsonsant.mercadomoeda.inbound.ports;

import br.com.helsonsant.mercadomoeda.domain.CotacaoCompraMoedaEstrangeira;
import br.com.helsonsant.mercadomoeda.domain.CotacaoMoedaEstrangeira;
import br.com.helsonsant.mercadomoeda.domain.MoedaEstrangeira;

public interface CotacaoCompraPort {
    CotacaoCompraMoedaEstrangeira getCotacaoCompraMoedaEstrangeira(CotacaoCompraMoedaEstrangeira cotacao);
}
