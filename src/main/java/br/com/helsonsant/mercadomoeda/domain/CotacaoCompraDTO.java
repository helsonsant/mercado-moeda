package br.com.helsonsant.mercadomoeda.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "CotacaoCompraDTO", description = "Objeto Cotação de Compra")
public class CotacaoCompraDTO {
    @NotNull
    @ApiModelProperty(value = "Segmento do cliente", example = "Varejo, Personnalite, Private", required = true)
    private String segmento;
    @NotNull
    @ApiModelProperty(value = "Moeda a ser cotacao", example = "USD, EUR", required = true)
    private String moeda;
    @NotNull
    @ApiModelProperty(value = "Quantidade de moeda desejada", example = "1000", required = true)
    private int quantidade;
    @ApiModelProperty(value = "Taxa utilizada na compra", example = "0.5", required = false)
    private double taxa;
    @ApiModelProperty(value = "Valor em reais da compra", example = "5300.50", required = false)
    private double valorEmReais;
}
