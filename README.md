
# API DE SUPERMERCADO EM SPRING BOOT

Api feita em spring boot que permite realizar o cadastro de clientes e produtos em Postgres SQL e o registro de compras em MONGODB

# ROTAS

## Clientes

### POST
URL BASE ```localhost:8080/clientes/```

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
### GET

URL BASE ```localhost:8080/clientes/```

Retorna a lista de todas os clientes cadastrados

### GET ID

URL BASE ```localhost:8080/clientes/id```

Retorna o cliente com o id selecionado, caso não tenha o id na base de dados ira retornar status 404

### PUT

URL BASE ```localhost:8080/clientes/id```

Irá passar o id na url e editar as informações do mesmo, caso não tenha o id na base de dados ira retornar status 404

### DELETE

URL BASE ```localhost:8080/clientes/id```

Irá deletar o id que esta na url, caso não tenha o id na base de dados ira retornar status 404


## Produtos

### POST

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

### GET

URL BASE ```localhost:8080/produtos/```

Retorna a lista de todas os produtos cadastrados

### GET ID

URL BASE ```localhost:8080/produtos/id```

Retorna o produto com o id selecionado, caso não tenha o id na base de dados ira retornar status 404

### GET COD BARRAS

URL BASE ```localhost:8080/produtos/codbarras/{codbarras}```

Retorna o produto codigo de barras que esta na url, caso não tenha na base de dados ira retornar status 404

### GET CATEGORIA

URL BASE ```localhost:8080/produtos/categoria/{categoria}```

Retorna todos os produtos com a categoria dita na url, caso não tenha na base de dados ira retornar status 404

### GET SEM ESTOQUE

URL BASE ```localhost:8080/produtos/semestoque```

Retorna todos os produtos que estão com a quantidade de estoque 0 no momento

### PUT

URL BASE ```localhost:8080/produtos/id```

Irá passar o id na url e editar as informações do mesmo, caso não tenha o id na base de dados ira retornar status 404

### DELETE

URL BASE ```localhost:8080/produtos/id```

Irá deletar o id que esta na url, caso não tenha o id na base de dados ira retornar status 404

## Compras

### POST

URL BASE ```localhost:8080/compras/```

Irá informar um CPF e um array com objetos do id do produto e a quantidade do mesmo, caso o cpf não exista ira retornar erro 404, caso o produto esteja sem estoque ira retornar erro 400
Exemplo de JSON a ser enviado no corpo da requisição:

```JSON
{
    "cpfCliente": "123.456.789-10",
		"produtos":[
			{
				"id": 1,
				"quantidade": 1
				
			},
			{
				"id": 2,
				"quantidade": 3
			}
		]
			
		

}
```
No corpo da resposta irá retornar o id, a nota fiscal e o valor da compra que irá ser adicionado no valor total do usuário e a quantidade irá ser subtraida do estoque dos produtos que estão no array de compras

Exemplo de JSON que irá ser retornado no corpo da resposta:
```JSON
{
  "id": "61abe8f074a515650bf1092b",
  "notafiscal": "690e701c-d545-43ce-8ab5-96ed967bfb12",
  "produtos": [
    {
      "id": 1,
      "nome": "Presunto",
      "marca": "Seara",
      "quantidade": 1,
      "preco": 25.25,
      "categoria": "Frios",
      "codbarras": 719853630986
    },
    {
      "id": 2,
      "nome": "Biscoito",
      "marca": "Richester",
      "quantidade": 3,
      "preco": 2.5,
      "categoria": "Cereais",
      "codbarras": 411359940245
    }
  ],
  "cpfCliente": "123.456.789-11",
  "valorcompras": 32.75
}
```
### GET

URL BASE ```localhost:8080/compras/```

Retorna a lista de todas as compras registradas

### GET COMPRAS POR CPF

URL BASE ```localhost:8080/compras/cpf/{cpf}```

Retorna a lista de todas as compras registradas por um cpf, caso o cpf não exista ira retornar erro 404

### GET COMPRA POR NF

URL BASE ```localhost:8080/compras/notafiscal/{notafiscal}```

Retorna a compra pela nota fiscal, caso a nota fiscal não exista ira retornar erro 404




