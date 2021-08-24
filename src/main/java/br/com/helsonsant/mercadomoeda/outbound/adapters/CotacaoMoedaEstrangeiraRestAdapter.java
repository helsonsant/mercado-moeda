package br.com.helsonsant.mercadomoeda.outbound.adapters;

import br.com.helsonsant.mercadomoeda.domain.CotacaoMoedaEstrangeira;
import br.com.helsonsant.mercadomoeda.outbound.ports.CotacaoPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CotacaoMoedaEstrangeiraRestAdapter implements CotacaoPort {
    @Value("${service.cotacao-api}")
    private String cotacaoApi;

    @Override
    public CotacaoMoedaEstrangeira getCotacao(String moeda) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CotacaoMoedaEstrangeira> response = restTemplate.getForEntity(cotacaoApi + moeda + "-BRL",  CotacaoMoedaEstrangeira.class);

        System.out.println("response: " + response.toString());
        return response.getBody();
    }
}
