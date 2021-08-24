package br.com.helsonsant.mercadomoeda.domain;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TaxaDTO", description = "Objeto Taxa")
public class TaxaDTO {
    @NotNull
    @ApiModelProperty(value = "Segmento do cliente", example = "Varejo, Personnalite, Private", required = true)
    private String segmento;
    @NotNull
    @ApiModelProperty(value = "Taxa cobrada do cliente", example = "0.3, 0.4", required = true)
    private double taxa;
}
