# GreenHouse

API da aplicação de controle de tarefas domésticas.

## Endpoints

- Tarefas
  - [Cadastrar Tarefa](#cadastrar-tarefa)
  - Alterar tarefa
  - [Listar tarefa](#listar-tarefa)
  - Apagar tarefa
  
- Usuário
  - [Cadastrar Usuário](#cadastrar-usuário)
  - [Listar Usuários](#listar-usuários)
  
- Poder
  - [Listar Poderes](#listar-poderes)
  - [Cadastrar Poder](#cadastrar-poderes)
  
  
### Cadastrar Tarefa
`POST` /greenhouse/api/tarefa
| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----
| nome | texto | não | o nome da tarefa para identificação.
| descrição | texto | sim | A descrição da tarefa.
| experiência | inteiro | sim | a experiência da tarefa ao ser concluída.
| categoria_id | inteiro | sim | o id da categoria da tarefa.
| data | data | sim | data limite para finalização da tarefa.


 **Exemplo de corpo de requisição**
 
 ```js
 
 {
    nome: 'Arrumar Quarto',
    descricao: 'Organizar guarda roupa, varrer e passar pano, tirar lixo, etc',
    experiencia: 200,
    categoria_id: 1
 }
 ```
 
 **Respostas**
 
| código | descrição
|-|-
|201| Tarefa cadastrada com sucesso
|400| a validação falhou
 
 ---
 
 ### Listar Tarefa
 `GET` /greenhouse/api/tarefa/{id}
 
 **Respostas**
 
 | código | descrição
 |-|-
 |200| Dados da tarefa retorna no corpo da resposta
 |404| não existe tarefa com o id informado
 
 **Exemplo corpo de resposta**
 ```js
 {
  nome: 'Organizar Quarto',
  descricao: 'Organizar guarda roupa, varrer e passar pano, tirar lixo, etc',
  experiencia: 200,
  categoria:
    {
      categoria_id: 1,
      nome: 'quarto'
    }
 }
 ```
 
 ---
 
 ### Cadastrar Usuário
 `POST` /greenhouse/api/usuario
 
 | campo | tipo | obrigatório | descrição
 |-------|------|:-------------:|----
 | user_id | inteiro | sim | identificador do usuário.
 | nome | texto | sim | o nome do usuário
 | senha | texto | sim | a senha do usuário
 | experiencia | inteiro | a experiencia do usuário para o ranking
 | level | inteiro | sim | O level do usuário
 
  **Exemplo de corpo de requisição**
  
  ```js
  {
    user_id: 1,
    nome: 'Victor Hugo',
    senha: 'senha123',
    xp: 1000,
    level: 10
  }
  ```
  
  **Respostas**
  
  | código | descrição
  |-|-
  |201| Usuário cadastrado com sucesso
  |400| A validação dos campos falhou
  
  ---
  ### Listar Usuários
  
  `GET` /greenhouse/api/usuario/{id}
  
  **Respostas**
  
| código | descrição
|-|-
|200| os dados do usuário retornaram no corpo da resposta
|404| id do usuário não existe
  
 **Exemplo de corpo de requisição**
  
 ```js
  {
    user_id: 1,
    nome: 'Victor Hugo',
    xp: 1000,
    level: 10
  }
  ```
  
  ---
  
  ### Cadastrar Poderes
  
  `POST` /greenhouse/api/power
  
 | campo | tipo | obrigatório | descrição
 |-------|------|:-------------:|----
 | tipo | inteiro | sim | Tipo de poder da loja.
 | descricao | String | sim | Descrição do poder da loja.
 | elementos | Inteiro | sim |Custo do poder na loja.
 
 **Exemplo de corpo de requisição**
 
 ```js
  {
    tipo_id : 1,
    descricao : 'Queime uma tarefa e deixe que alguem faça por você',
    elementos : 20  
  }
  ```
  
  ---
  
 ### Listar Poderes

`GET` /greenhouse/api/power/{id}

**Respostas**
 
 | código | descrição
 |-|-
 |200| Dados da tarefa retorna no corpo da resposta.
 |404| Não existe poder com o id informado.
 
 **Exemplo de corpo de requisição**
 
 ```js
  {
    tipo : {
      tipo_id : 1,
      nome : 'fire'
      },
    descricao : 'Queime uma tarefa e deixe que alguem faça por você',
    elementos : 20  
  }
  ```
