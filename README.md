
# API DE SUPERMERCADO EM SPRIBG BOOT

Api feita em spring boot que permite realizar o cadastro de clientes e produtos em Postgres SQL e o registro de compras em MONGODB

##ROTAS

### Clientes

####POST
URL BASE ```RAW localhost:8080/clientes/```

Exemplo de JSON a ser enviado:
```JSON
{
		"cpf":"123.456.789-12"
    "nome": "Usuario",
 }

```

Retorna status 200 e o body completo do cliente:
```JSON
{
  "id": 6,
  "cpf": "123.456.789-12",
  "nome": "Usuario",
  "valorTotal": 0.0
}

```
#### GET

URL BASE ```RAW localhost:8080/clientes/```

Retorna a lista de todas os clientes cadastrados

#### GET ID

URL BASE ```RAW localhost:8080/clientes/id```

Retorna o cliente com o id selecionado, caso não tenha o id na base de dados ira retornar status 404

#### PUT

URL BASE ```RAW localhost:8080/clientes/id```

Irá passar o id na url e editar as informações do mesmo, caso não tenha o id na base de dados ira retornar status 404

#### DELETE

URL BASE ```RAW localhost:8080/clientes/id```

Irá deletar o id que esta na url, caso não tenha o id na base de dados ira retornar status 404



