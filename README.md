# upperBank

## Uma api para sistema bancário simples

- > <h2>Conta</h2>
  - [Cadastrar](#cadastrar-uma-conta)
  - [Listar todas](#listar-todas-contas)
  - [Mostrar detalhes](#mostrar-detalhes-de-uma-conta)
  - [Atualizar](#atualização-conta)
  - [Apagar](#apagar-conta)

<br/>

- > <h2>Movimentações</h2>
  - [Cadastrar](#cadastrar-uma-movimentaçao)
  - [Listar todas](#listar-todos-movimentaçao)
  - [Mostrar detalhes](#mostrar-detalhes-movimentaçao)
  - [Atualizar](#atualização-movimentaçao)
  - [Apagar](#apagar-movimentaçao)

<h1>Swagger upperbank</h1>

<details open>
<summary>Conta</summary>

<br>

<details>
<summary> <b style="color:green">POST</b> /upperbank/api/conta</summary>

<br/>

# Cadastrar uma conta

<br/>

### Requisição:

```json
{
  "nome": "Luan Reis",
  "agencia": 0001,
  "conta": 00001,
  "senha": 12345678
}
```

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "id": 1,
  "nome": "Luan Reis",
  "agencia": 0001,
  "conta": 00001,
  "digito": 0,
  "dataAbertura": "01/03/2023 13:01:25",
  "status": "A",
  "saldo": 0.0,
  "senha": 12345678
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

<br/>
</details>

<details open>
<summary> <b style="color:cyan">GET</b> /upperbank/api/conta</summary>

<br/>

# Listar todas contas

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
[
  {
    "id": 1,
    "nome": "Luan Reis",
    "agencia": 0001,
    "conta": 00001,
    "digito": 0,
    "dataAbertura": "01/03/2023 13:01:25",
    "status": "A",
    "saldo": 0.0,
    "senha": 12345678
  },
  {
    "id": 2,
    "nome": "Joaizinho Pereira",
    "agencia": 0001,
    "conta": 00002,
    "digito": 0,
    "dataAbertura": "25/02/2023 22:21:25",
    "status": "A",
    "saldo": 0.0,
    "senha": 12345678
  },
  {
    "id": 3,
    "nome": "Maria Cesariana",
    "agencia": 2032,
    "conta": 12332,
    "digito": 2,
    "dataAbertura": "04/02/2023 01:10:56",
    "status": "A",
    "saldo": 0.0,
    "senha": 12345678
  }
]
```

<br/>
<hr>

`status code: 204`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "Não há contas para retornar"
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<details>
<summary> <b style="color:cyan">GET</b> /upperbank/api/conta/${ID}</summary>

# Mostrar detalhes de uma conta

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "id": 1,
  "nome": "Luan Reis",
  "agencia": 0001,
  "conta": 00001,
  "digito": 0,
  "dataAbertura": "01/03/2023 13:01:25",
  "status": "A",
  "saldo": 0.0,
  "senha": 12345678
}
```

<br/>
<hr>

`status code: 204`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "Conta inexistente"
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<details>
<summary> <b style="color:orange">UPDATE</b> /upperbank/api/conta</summary>

<br/>

# Atualização conta

### Requisição:

```json
{
  "id": 1,
  "nome": "Luan Reis",
  "agencia": 0001,
  "conta": 00001,
  "digito": 0,
  "status": "A",
  "saldo": 0.0,
  "senha": 12345678
}
```

<br/>

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "id": 1,
  "nome": "Luan Reis",
  "agencia": 0001,
  "conta": 00001,
  "digito": 0,
  "dataAbertura": "01/03/2023 13:01:25",
  "status": "A",
  "saldo": 0.0,
  "senha": 12345678
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<details>
<summary> <b style="color:red">DELETE</b> /upperbank/api/conta/${id}</summary>

<br/>

# Apagar conta

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "Apagado com sucesso"
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<br/><br/>

# Tabela banco de dados

|  campo  |     tipo     | obrigatório | descrição                                                                              |
| :-----: | :----------: | :---------: | -------------------------------------------------------------------------------------- |
|   id    |     int      |     sim     | Id da conta com auto-incremento                                                        |
|  nome   | varchar(100) |     sim     | nome do cliente;                                                                       |
| agencia |     int      |     sim     | numero da agencia                                                                      |
|  conta  |     int      |     sim     | numero da conta                                                                        |
| digito  |     int      |     sim     | número do digito da conta. vai ser gerador de acordo com o primeiro numero da agencia. |
|  data   |     date     |     sim     | data da abertura da conta                                                              |
|  saldo  | number(10,2) |     sim     | saldo da conta                                                                         |
|  senha  |     int      |     sim     | senha da conta                                                                         |
| status  |   char(1)    |     sim     | Status da conta sendo "A" ativo, "E" encerrada, "B" bloqueada                          |

</details>

<details>
<summary>Movimentações</summary>

<br>

<details>
<summary> <b style="color:green">POST</b> /upperbank/api/movimentacao</summary>

<br/>

# Cadastrar uma movimentação

<br/>

### Requisição:

```json
{
  "nome": "Transferencia",
  "tipo": 2,
  "conta": 1,
  "ag_destino": 0001,
  "conta_destino": 00001,
  "digito_c_destino": 0
}
```

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "id": 1,
  "nome": "Transferencia",
  "tipo": 2,
  "conta": 1,
  "ag_destino": 0001,
  "conta_destino": 00001,
  "digito_c_destino": 0,
  "data": "06/03/2023 - 14:12:02",
  "status": "C"
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

<br/>
</details>

 <details>
<summary> <b style="color:cyan">GET</b> /upperbank/api/movimentação/${conta}</summary>

<br/>

# Listar todas movimentações de uma conta

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
[
  {
    "id": 1,
    "nome": "Transferencia",
    "tipo": 2,
    "conta": 1,
    "ag_destino": 0001,
    "conta_destino": 00001,
    "digito_c_destino": 0,
    "data": "06/03/2023 - 14:12:02",
    "status": "C"
  },
  {
    "id": 1,
    "nome": "Transferencia",
    "tipo": 2,
    "conta": 1,
    "ag_destino": 0001,
    "conta_destino": 00001,
    "digito_c_destino": 0,
    "data": "06/03/2023 - 14:12:02",
    "status": "C"
  }
]
```

<br/>
<hr>

`status code: 204`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "Não há movimentações para retornar"
}
```

<br/>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<details>
<summary> <b style="color:cyan">GET</b> /upperbank/api/movimentação/${ID}</summary>

<br/>

# Mostrar detalhes de uma movimentação

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "id": 1,
  "nome": "Transferencia",
  "tipo": 2,
  "conta": 1,
  "ag_destino": 0001,
  "conta_destino": 00001,
  "digito_c_destino": 0,
  "data": "06/03/2023 - 14:12:02",
  "status": "C"
}
```

<br/>
<hr>

`status code: 204`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "Movimentação inexistente"
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<details>
<summary> <b style="color:orange">UPDATE</b> /upperbank/api/movimentacao</summary>

<br/>

# Atualização movimentação

### Requisição:

```json
{
  "id": 1,
  "nome": "Transferencia",
  "tipo": 2,
  "conta": 1,
  "ag_destino": 0001,
  "conta_destino": 00001,
  "digito_c_destino": 0,
  "data": "06/03/2023 - 14:12:02",
  "status": "C"
}
```

<br/>

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "id": 1,
  "nome": "Transferencia",
  "tipo": 2,
  "conta": 1,
  "ag_destino": 0001,
  "conta_destino": 00001,
  "digito_c_destino": 0,
  "data": "06/03/2023 - 14:12:02",
  "status": "C"
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<details>
<summary> <b style="color:red">DELETE</b> /upperbank/api/movimentacao/${id}</summary>

<br/>

# Apagar movimentação

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "Apagado com sucesso"
}
```

<br/>
<hr>

`status code: 400`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "{Mensagem de erro da regra de negocio}"
}
```

</details>

<br/><br/>

# Tabela banco de dados

|      campo       |     tipo     | obrigatório | descrição                                                  |
| :--------------: | :----------: | :---------: | ---------------------------------------------------------- |
|        id        |     int      |     sim     | Id da movimentação com auto-incremento                     |
|       nome       | varchar(100) |     sim     | nome da movimentação                                       |
|       tipo       |     int      |     sim     | 1 - Pagamentos, 2 - Transferencias                         |
|      conta       |     int      |     sim     | Tabela de contas vinculada nessas movimentações            |
|    ag_destino    |     int      |     sim     | numero da agencia destino para o pagamento                 |
|  conta_destino   |     int      |     sim     | numero da conta destino para o pagamento                   |
| digito_c_destino |     int      |     sim     | numero da conta destino para o pagamento                   |
|       data       |     date     |     sim     | data da abertura da movimentação                           |
|      status      |   char(1)    |     sim     | Status da movimentação sendo "C" concluida, "A" : Abortada |

</details>
