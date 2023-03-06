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
 
  **Exemplo de corpo de requisição**
  
  ```js
  {
    user_id: 1,
    nome: 'Victor Hugo',
    senha: 'senha123',
    xp: 1000
  }
  ```
  
  **Respostas**
  
  | código | descrição
  |-|-
  |201| Usuário cadastrado com sucesso
  |400| a validação dos campos falhou
  
  ---
  
  `GET` /greenhouse/api/usuario/{id}
  
  **Respostas**
  
| código | descrição
|-|-
|200| os dados do usuário retornaram no corpo da resposta
|404| id do usuário não existe
  
 ```js
  {
    user_id: 1,
    nome: 'Victor Hugo',
    xp: 1000
  }
  ```
  
