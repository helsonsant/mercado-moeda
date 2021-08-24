package br.com.helsonsant.mercadomoeda.domain;

import lombok.Data;

@Data
public class UsdBrl {
    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    private String create_date;
}
