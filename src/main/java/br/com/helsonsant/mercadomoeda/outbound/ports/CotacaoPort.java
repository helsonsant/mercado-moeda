package br.com.helsonsant.mercadomoeda.outbound.ports;

import br.com.helsonsant.mercadomoeda.domain.CotacaoCompraMoedaEstrangeira;
import br.com.helsonsant.mercadomoeda.domain.CotacaoMoedaEstrangeira;

public interface CotacaoPort {
    CotacaoMoedaEstrangeira getCotacao(String moeda);
}
