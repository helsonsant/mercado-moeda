package br.com.helsonsant.mercadomoeda.domain;

import lombok.Data;

@Data
public class CotacaoCompraMoedaEstrangeira {
    private String segmento;
    private String moeda;
    private int quantidade;
    private double taxa;
    private double valorEmReais;
}