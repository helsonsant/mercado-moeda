package br.com.helsonsant.mercadomoeda.controller;

import br.com.helsonsant.mercadomoeda.configuration.Health;
import br.com.helsonsant.mercadomoeda.domain.*;
import br.com.helsonsant.mercadomoeda.inbound.ports.CotacaoCompraPort;
import br.com.helsonsant.mercadomoeda.service.TaxaPort;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping(path = "/mercado-moeda", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = { "Mercado Moeda" })
public class MercadoMoedaController {
    private final ModelMapper modelMapper;
    private final TaxaPort taxaUseCase;
    private final CotacaoCompraPort cotacaoCompra;

    @Autowired
    public MercadoMoedaController(ModelMapper modelMapper, TaxaPort taxaPort, CotacaoCompraPort cotacao){
        this.taxaUseCase = taxaPort;
        this.modelMapper = modelMapper;
        this.cotacaoCompra = cotacao;
    }

    @GetMapping(value = "/health")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna status da aplicação")
    public ResponseEntity<String> getHealthStatus() {
        return new ResponseEntity<String>(new Gson().toJson(new Health()), HttpStatus.OK);
    }

    @PostMapping(value = "/cotacaocompra")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna uma cotacao e compra de uma moeda estrangeira")
    public ResponseEntity<String> postCotacaocompra(@RequestBody final CotacaoCompraDTO cotacao) {
        CotacaoCompraMoedaEstrangeira cotacaoCompraRetornada = cotacaoCompra.getCotacaoCompraMoedaEstrangeira(convertToEntity(cotacao, CotacaoCompraMoedaEstrangeira.class));
        return new ResponseEntity<String>(new Gson().toJson(cotacaoCompraRetornada), HttpStatus.OK);
    }


    @PostMapping(value = "/taxas", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria nova taxa para um segmento")
    public ResponseEntity<String> postTaxa(@RequestBody final TaxaDTO taxa){
        taxaUseCase.createTaxa(convertToEntity(taxa, Taxa.class));
        return new ResponseEntity<String>(new Gson().toJson(taxa), HttpStatus.CREATED);
    }

    @GetMapping(value = "/taxas")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna lista de taxas cadastradas")
    public ResponseEntity<String> getTaxas() {
        List<Taxa> taxas = taxaUseCase.taxas();
        List<TaxaDTO> listaTaxas = new ArrayList<>();
        for (Taxa taxa: taxas){
            listaTaxas.add(convertToDTO(taxa, TaxaDTO.class));
        }
        return new ResponseEntity<String>(new Gson().toJson(listaTaxas), HttpStatus.OK);
    }

    @GetMapping(value = "/taxas/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna taxa do segmento informado")
    public ResponseEntity<String> getTaxas(@PathVariable final String id) {
        Taxa taxa = taxaUseCase.getTaxa(id);
        if (taxa != null){
            return new ResponseEntity<String>(new Gson().toJson(convertToDTO(taxa, TaxaDTO.class)), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
    }

    @PutMapping(value = "/taxas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza taxa cobrada dos clientes do segmento informado")
    public ResponseEntity<String> updateTaxa(@RequestBody final TaxaDTO taxa, @PathVariable final String id) {
        taxaUseCase.saveTaxa(convertToEntity(taxa, Taxa.class));
        return new ResponseEntity<String>(new Gson().toJson(taxa), HttpStatus.OK);
    }

    @DeleteMapping(value = "/taxas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Exclui taxa cobrada cadastrada")
    public ResponseEntity<String> deleteTaxa(@PathVariable final String id) {
        taxaUseCase.deleteTaxa(id);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    protected CotacaoCompraMoedaEstrangeira convertToEntity(final CotacaoCompraDTO dto, final Class<CotacaoCompraMoedaEstrangeira> entityClass) {
        CotacaoCompraMoedaEstrangeira entity = modelMapper.map(dto, entityClass);
        return entity;
    }

    protected CotacaoCompraDTO convertToDTO(final CotacaoCompraMoedaEstrangeira entity, final Class<CotacaoCompraDTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    protected Taxa convertToEntity(final TaxaDTO dto, final Class<Taxa> entityClass) {
        Taxa entity = modelMapper.map(dto, entityClass);
        return entity;
    }

    protected TaxaDTO convertToDTO(final Taxa entity, final Class<TaxaDTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }


}
