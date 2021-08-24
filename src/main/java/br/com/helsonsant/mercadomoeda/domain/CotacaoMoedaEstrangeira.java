package br.com.helsonsant.mercadomoeda.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CotacaoMoedaEstrangeira {
    @JsonProperty("USDBRL")
    UsdBrl usdBrl;
    @JsonProperty("EURBRL")
    EurBrl eurBrl;
}

