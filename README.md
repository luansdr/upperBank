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
  - [Listar todas](#listar-todas-movimentações-de-uma-conta)
  - [Mostrar detalhes](#mostrar-detalhes-de-uma-movimentação)
  - [Atualizar](#atualização-movimentaçao)
  - [Apagar](#apagar-movimentaçao)

<br/>

- > <h2>Cliente</h2>
  - [Cadastrar](#cadastrar-um-cliente)
  - [Listar todas](#listar-todos-clientes)
  - [Mostrar detalhes](#mostrar-detalhes-de-um-cliente)
  - [Atualizar](#atualização-cliente)
  - [Apagar](#apagar-cliente)

<h1>Swagger upperbank</h1>

<details>
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
    "agencia": 1234,
    "conta": 44444,
    "digito": 1,
    "cliente": [
        {    
            "id": 0,
            "nome": "Luan Reis",
            "dataNascimento": "16/02/2023 - 14:00:00",
            "cpf": "40587128801"
        }
    ],
    "movimentacao": [
        {
            "id": 0,
            "nome": "Pagamento de conta",
            "tipo": 65,
            "agenciaDestino": 1231,
            "contaDestino": 12343,
            "digitoContaDestino": 1,
            "data": "16/02/2023 - 14:00:00",
            "status": "A",
            "valor": 0.0,
            "descricao": "Pagamento"
        }
    ],
    "dataAbertura": "16/02/2023 - 14:00:00",
    "senha": 12345678,
    "status": "A",
    "saldo": 0.0,
    "limite": 0.0
}
```

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
    "id": 1,
    "agencia": 1234,
    "conta": 44444,
    "digito": 1,
    "cliente": [
        {   
            "id": 1,
            "nome": "Luan Reis",
            "dataNascimento": "16/02/2023 - 14:00:00",
            "cpf": "40587128801"
        }
    ],
    "movimentacao": [
        {
            "id": 1,
            "nome": "Pagamento de conta",
            "tipo": 65,
            "agenciaDestino": 1231,
            "contaDestino": 12343,
            "digitoContaDestino": 1,
            "data": "16/02/2023 - 14:00:00",
            "status": "A",
            "valor": 0.0,
            "descricao": "Pagamento"
        }
    ],
    "dataAbertura": "16/02/2023 - 14:00:00",
    "senha": 12345678,
    "status": "A",
    "saldo": 0.0,
    "limite": 0.0
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
    "agencia": 1234,
    "conta": 44444,
    "digito": 1,
    "cliente": [
        {    
            "id": 1,
            "nome": "Luan Reis",
            "dataNascimento": "16/02/2023 - 14:00:00",
            "cpf": "40587128801"
        }
    ],
    "movimentacao": [
        {
            "id": 1,
            "nome": "Pagamento de conta",
            "tipo": 65,
            "agenciaDestino": 1231,
            "contaDestino": 12343,
            "digitoContaDestino": 1,
            "data": "16/02/2023 - 14:00:00",
            "status": "A",
            "valor": 0.0,
            "descricao": "Pagamento"
        }
    ],
    "dataAbertura": "16/02/2023 - 14:00:00",
    "senha": 12345678,
    "status": "A",
    "saldo": 0.0,
    "limite": 0.0
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
    "agencia": 1234,
    "conta": 44444,
    "digito": 1,
    "cliente": [
        {   
            "id": 1,
            "nome": "Luan Reis",
            "dataNascimento": "16/02/2023 - 14:00:00",
            "cpf": "40587128801"
        }
    ],
    "movimentacao": [
        {
            "id": 1,
            "nome": "Pagamento de conta",
            "tipo": 65,
            "agenciaDestino": 1231,
            "contaDestino": 12343,
            "digitoContaDestino": 1,
            "data": "16/02/2023 - 14:00:00",
            "status": "A",
            "valor": 0.0,
            "descricao": "Pagamento"
        }
    ],
    "dataAbertura": "16/02/2023 - 14:00:00",
    "senha": 12345678,
    "status": "A",
    "saldo": 0.0,
    "limite": 0.0
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
    "agencia": 1234,
    "conta": 44444,
    "digito": 1,
    "cliente": [
        {
            "id": 1, 
            "nome": "Luan Reis",
            "dataNascimento": "16/02/2023 - 14:00:00",
            "cpf": "40587128801"
        }
    ],
    "movimentacao": [
        {
            "id": 1,
            "nome": "Pagamento de conta",
            "tipo": 65,
            "agenciaDestino": 1231,
            "contaDestino": 12343,
            "digitoContaDestino": 1,
            "data": "16/02/2023 - 14:00:00",
            "status": "A",
            "valor": 0.0,
            "descricao": "Pagamento"
        }
    ],
    "dataAbertura": "16/02/2023 - 14:00:00",
    "senha": 12345678,
    "status": "A",
    "saldo": 0.0,
    "limite": 0.0
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
    "agencia": 1234,
    "conta": 44444,
    "digito": 1,
    "cliente": [
        { 
            "id": 1, 
            "nome": "Luan Reis",
            "dataNascimento": "16/02/2023 - 14:00:00",
            "cpf": "40587128801"
        }
    ],
    "movimentacao": [
        {
            "id": 1,
            "nome": "Pagamento de conta",
            "tipo": 65,
            "agenciaDestino": 1231,
            "contaDestino": 12343,
            "digitoContaDestino": 1,
            "data": "16/02/2023 - 14:00:00",
            "status": "A",
            "valor": 0.0,
            "descricao": "Pagamento"
        }
    ],
    "dataAbertura": "16/02/2023 - 14:00:00",
    "senha": 12345678,
    "status": "A",
    "saldo": 0.0,
    "limite": 0.0
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

|  campo  |      tipo       | obrigatório | descrição                                                     |
| :-----: | :-------------: | :---------: | ------------------------------------------------------------- |
|   id    |       int       |     sim     | Id da conta com auto-incremento                               |
| agencia |       int       |     sim     | numero da agencia                                             |
|  conta  |       int       |     sim     | numero da conta                                               |
| cliente |   fk_cliente    |     sim     | uma conta pode ter um ou mais clientes.                       |
| cliente | fk_movimentacao |     sim     | uma conta pode ter nenhuma ou várias movimentações.           |
|  data   |      date       |     sim     | data da abertura da conta                                     |
|  senha  |       int       |     sim     | senha da conta                                                |
| status  |     char(1)     |     sim     | Status da conta sendo "A" ativo, "E" encerrada, "B" bloqueada |
|  saldo  |  number(10,2)   |     sim     | saldo da conta                                                |
| limite  |  number(10,2)   |     sim     | limite da conta                                               |

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
    "nome": "Pagamento",
    "tipo": 5,
    "agenciaDestino": 1231,
    "contaDestino": 12343,
    "digitoContaDestino": 1,
    "data": "2023-03-07T17:07:21.226+00:00",
    "status": "A",
    "valor": 0.0,
    "descricao": "Pagamento"
}
```

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{
  "id": 0,
  "nome": "Pagamento",
  "tipo": 5,
  "agenciaDestino": 1231,
  "contaDestino": 12343,
  "digitoContaDestino": 1,
  "data": "2023-03-07T17:07:21.226+00:00",
  "status": "A",
  "valor": 0.0,
  "descricao": "Pagamento"
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
<summary> <b style="color:cyan">GET</b> /upperbank/api/movimentação</summary>

<br/>

# Listar todas movimentações de uma conta

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
[
    {
    "id": 0,
    "nome": "Pagamento",
    "tipo": 5,
    "agenciaDestino": 1231,
    "contaDestino": 12343,
    "digitoContaDestino": 1,
    "data": "2023-03-07T17:07:21.226+00:00",
    "status": "A",
    "valor": 0.0,
    "descricao": "Pagamento"
  },
 {
    "id": 1,
    "nome": "Pagamento",
    "tipo": 5,
    "agenciaDestino": 1231,
    "contaDestino": 12343,
    "digitoContaDestino": 1,
    "data": "2023-03-07T17:07:21.226+00:00",
    "status": "A",
    "valor": 0.0,
    "descricao": "Pagamento"
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
  "nome": "Pagamento",
  "tipo": 5,
  "agenciaDestino": 1231,
  "contaDestino": 12343,
  "digitoContaDestino": 1,
  "data": "2023-03-07T17:07:21.226+00:00",
  "status": "A",
  "valor": 0.0,
  "descricao": "Pagamento"
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

# Atualização movimentaçao

### Requisição:

```json
{
  "id": 1,
  "nome": "Pagamento",
  "tipo": 5,
  "agenciaDestino": 1231,
  "contaDestino": 12343,
  "digitoContaDestino": 1,
  "data": "2023-03-07T17:07:21.226+00:00",
  "status": "A",
  "valor": 0.0,
  "descricao": "Pagamento"
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
  "nome": "Pagamento",
  "tipo": 5,
  "agenciaDestino": 1231,
  "contaDestino": 12343,
  "digitoContaDestino": 1,
  "data": "2023-03-07T17:07:21.226+00:00",
  "status": "A",
  "valor": 0.0,
  "descricao": "Pagamento"
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
|    ag_destino    |     int      |     sim     | numero da agencia destino para o pagamento                 |
|  conta_destino   |     int      |     sim     | numero da conta destino para o pagamento                   |
| digito_c_destino |     int      |     sim     | numero da conta destino para o pagamento                   |
|       data       |     date     |     sim     | data da abertura da movimentação                           |
|      status      |   char(1)    |     sim     | Status da movimentação sendo "C" concluida, "A" : Abortada |
|      valor       | number(10,2) |     sim     | Valor que foi na movimentação                              |
|    descricao     | varchar(50)  |     sim     | Descrição sobre a movimentação                             |

</details>


<details>
<summary>Cliente</summary>

<br>

<details>
<summary> <b style="color:green">POST</b> /upperbank/api/cliente</summary>

<br/>

# Cadastrar um cliente

<br/>

### Requisição:

```json
{ 
    "cpf": "40587128801",
    "nome": "Luan Reis",
    "dataNascimento": "19/11/1995",
}
```

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{    
    "id": 1,
    "cpf": "40587128801",
    "nome": "Luan Reis",
    "dataNascimento": "19/11/1995",
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
<summary> <b style="color:cyan">GET</b> /upperbank/api/cliente</summary>

<br/>

# Listar todos clientes

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
[
  {
    "id": 1,
    "cpf": "40587128801",
    "nome": "Luan Reis",
    "dataNascimento": "19/11/1955",
  },
  {
    "id": 2,
    "cpf": "222312332132",
    "nome": "Ana Paula",
    "dataNascimento": "20/10/2000",
  }
]
```

<br/>
<hr>

`status code: 204`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "Não há cliente para retornar"
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
<summary> <b style="color:cyan">GET</b> /upperbank/api/cliente/${id}</summary>

<br/>

# Mostrar detalhes de um cliente

<br/>

### Responses:

`status code: 200`

#### Tipo do body: <b>Application/json</b>

```json
{ 
    "id": 1,
    "cpf": "40587128801",
    "nome": "Luan Reis",
    "dataNascimento": "19/11/1955",
  }
```

<br/>
<hr>

`status code: 204`

#### Tipo do body: <b>Application/json</b>

```json
{
  "retorno": "cliente inexistente"
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
<summary> <b style="color:orange">UPDATE</b> /upperbank/api/cliente</summary>

<br/>

# Atualização cliente

### Requisição:

```json
{ 
    "id": 1,
    "cpf": "40587128801",
    "nome": "Luan Reis",
    "dataNascimento": "19/11/1955",
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
  "cpf": "40587128801",
  "nome": "Luan Reis",
  "dataNascimento": "19/11/1955",
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
<summary> <b style="color:red">DELETE</b> /upperbank/api/cliente/${id}</summary>

<br/>

# Apagar cliente

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

|     campo     |     tipo     | obrigatório | descrição                                                            |
| :-----------: | :----------: | :---------: | -------------------------------------------------------------------- |
|      id       |     int      |     sim     | id e primary key.                                                    |
|      cpf      | varchar(11)  |     sim     | CPF será unico para cada cliente, não poderá haver 2 cpf cadastrado. |
|  nm_cliente   | varchar(100) |     sim     | nome do cliente                                                      |
| dt_nascimento |     date     |     sim     | data nascimento do cliente                                           |


</details>