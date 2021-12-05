
# API DE SUPERMERCADO EM SPRING BOOT

Api feita em spring boot que permite realizar o cadastro de clientes e produtos em Postgres SQL e o registro de compras em MONGODB

## ROTAS

### Clientes

#### POST
URL BASE ```RAW localhost:8080/clientes/```

Exemplo de JSON a ser enviado no corpo da requisição:
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

URL BASE ```localhost:8080/clientes/```

Retorna a lista de todas os clientes cadastrados

#### GET ID

URL BASE ```localhost:8080/clientes/id```

Retorna o cliente com o id selecionado, caso não tenha o id na base de dados ira retornar status 404

#### PUT

URL BASE ```localhost:8080/clientes/id```

Irá passar o id na url e editar as informações do mesmo, caso não tenha o id na base de dados ira retornar status 404

#### DELETE

URL BASE ```localhost:8080/clientes/id```

Irá deletar o id que esta na url, caso não tenha o id na base de dados ira retornar status 404


### Produtos

#### POST

URL BASE ```localhost:8080/produtos/```

Exemplo de JSON a ser enviado no corpo da requisição:

```JSON
    "nome": "Presunto",
    "marca": "Seara",
    "quantidade": 13,
    "preco": 25.25,
    "categoria": "Frios",

```
Irá retornar junto com o ID e o codigo de barras atribuido a ele

```JSON
{
  "id": 7,
  "nome": "Presunto",
  "marca": "Seara",
  "quantidade": 13,
  "preco": 25.25,
  "categoria": "Frios",
  "codbarras": 338536788080
}
```

#### GET

URL BASE ```localhost:8080/produtos/```

Retorna a lista de todas os produtos cadastrados

#### GET ID

URL BASE ```localhost:8080/produtos/id```

Retorna o produto com o id selecionado, caso não tenha o id na base de dados ira retornar status 404

#### GET ID

URL BASE ```localhost:8080/produtos/codbarras/{codbarras}```

Retorna o produto codigo de barras que esta na url, caso não tenha na base de dados ira retornar status 404

#### GET CATEGORIA

URL BASE ```localhost:8080/produtos/categoria/{categoria}```

Retorna todos os produtos com a categoria dita na url, caso não tenha na base de dados ira retornar status 404

#### GET SEM ESTOQUE

URL BASE ```localhost:8080/produtos/semestoque```

Retorna todos os produtos que estão com a quantidade de estoque 0 no momento

#### PUT

URL BASE ```localhost:8080/produtos/id```

Irá passar o id na url e editar as informações do mesmo, caso não tenha o id na base de dados ira retornar status 404

#### DELETE

URL BASE ```localhost:8080/produtos/id```

Irá deletar o id que esta na url, caso não tenha o id na base de dados ira retornar status 404


