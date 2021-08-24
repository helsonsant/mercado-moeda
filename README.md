# API para cotação e compra de Moedas Estrangeiras

## mercado-moeda

API 
    moeda-mercado/

Endpoints    
    /health
        metodo:
            GET
        
        descricao:
            retorna status da aplicacao

        retorno:
            {
                "status": "UP",
            }

    /cotacao
        metodo: 
            POST

        descricao:
            retorna cotacao de compra de moeda estrangeira solicitada

        payload entrada:

            {
                "segmento": "Private",
                "moeda": "USD",
                "quantidade": 1500
            }

        retorno:
            http status: 200 - OK
            {
                "segmento": "Private",
                "moeda": "USD",
                "quantidade": 1500,
                "taxa": 0.2,
                "valorEmReais": 9689.039999999999
            }

    /taxas
        metodo:
            GET

        descricao:
            lista todas as taxas cobradas dos clientes por segmento

        retorno:
            [
                {
                    "segmento": "Varejo",
                    "taxaCobrada": 0.4
                },
                {
                    "segmento": "Personnalite",
                    "taxaCobrada": 0.3
                },
                {
                    "segmento": "Private",
                    "taxaCobrada": 0.2
                }
            ]

    /taxas
        metodo:
            POST

        descricao:
            adiciona/atualiza taxa cobrada dos cliente do segmento informado

        payload entrada:
            {
                "segmento": "Varejo",
                "taxaCobrada": 0.4
            }

        retorno:
            {
                "segmento": "Varejo",
                "taxaCobrada": 0.4
            }

    /taxas/{segmento}
        metodo:
            GET
        descricao:
            retorna taxa cobrada dos cliente do segmento informado
        retorno:
            {
                "segmento": "Varejo",
                "taxaCobrada": 0.4
            }
    
    /taxas/{segmento}
        metodo:
            PUT

        descricao:
            atualiza taxa cobrada dos clientes do segmento informado

        retorno:
            http status 200 OK

            {
                "segmento": "Varejo",
                "taxaCobrada": 0.4
            }

    /taxas/{segmento}
        metodo:
            DELETE
            
        descricao:
            elimina taxa cobrada dos clientes do segmento informado

        retorno:
            http status 200 OK

A documentação também pode ser consultada via swagger-ui

![swagger-docs](https://github.com/helsonsant/mercado-moeda/blob/master/src/main/resources/mercado-moeda-swagger.png?raw=true)

Sugestão de arquitetura para implantação na cloud AWS

![swagger-docs](https://github.com/helsonsant/mercado-moeda/blob/master/src/main/resources/mercado-moeda-arquitetura.png?raw=true)


