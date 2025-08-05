Claro! Um bom README é essencial para qualquer projeto. Para o MkDocs, que usa Markdown, podemos criar um ficheiro bem estruturado, informativo e que inclua a sua imagem do diagrama.

Abaixo está uma sugestão completa para o seu README.md.

Nota Sobre a Imagem
Para que a imagem apareça no seu site MkDocs, siga estes passos:

Dentro da pasta do seu projeto, o MkDocs geralmente cria uma pasta chamada docs.

Dentro da pasta docs, crie uma nova pasta chamada images.

Coloque o seu ficheiro de imagem (image_b886c7.png) dentro desta nova pasta docs/images/.

O código Markdown abaixo já está configurado para encontrar a imagem nesse local.

Conteúdo para o seu README.md
Pode copiar e colar todo o texto abaixo num ficheiro README.md (ou index.md) dentro da sua pasta docs.

Markdown

# Agregador de Investimentos

Bem-vindo ao Agregador de Investimentos, uma API RESTful desenvolvida em Java com Spring Boot para gerir utilizadores, as suas contas de investimento e as ações associadas a cada conta.

Este projeto permite criar utilizadores, associar múltiplas contas a eles e popular essas contas com diferentes ações, simulando uma carteira de investimentos simplificada.

## Funcionalidades Principais

* **Gestão de Utilizadores:** Criar, listar, atualizar e apagar utilizadores.
* **Gestão de Contas:** Criar e listar contas de investimento associadas a um utilizador.
* **Gestão de Ações (Stocks):** Criar os tipos de ações disponíveis no sistema.
* **Associação de Carteira:** Associar ações a uma conta de um utilizador, especificando a quantidade.
* **Consulta de Carteira:** Listar todas as ações e as suas quantidades para uma determinada conta.

## Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA (Hibernate)**
* **MySQL** (ou outro banco de dados relacional)
* **Maven**

## Estrutura do Banco de Dados

A estrutura do banco de dados foi modelada para representar as relações entre utilizadores, contas e ações, garantindo a integridade dos dados.

![Diagrama de Entidade-Relacionamento](images/image_b886c7.png)

## Como Executar o Projeto Localmente

### Pré-requisitos

* JDK 17 ou superior
* Apache Maven
* Uma instância de MySQL a correr

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd agregadorinvestimentos
    ```

2.  **Configure a base de dados:**
    Abra o ficheiro `src/main/resources/application.properties` e configure os seus dados de acesso ao MySQL:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/db_example
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Execute a aplicação:**
    Use o Maven para iniciar o servidor Spring Boot.
    ```bash
    mvn spring-boot:run
    ```
    A API estará disponível em `http://localhost:8080`.

## Endpoints da API

Aqui estão os principais endpoints disponíveis na API.

### Utilizadores (`/v1/users`)

* `POST /`: Cria um novo utilizador.
    * Corpo (Body): `{ "username": "...", "email": "...", "password": "..." }`
* `GET /{userId}`: Busca um utilizador pelo seu ID.
* `GET /`: Lista todos os utilizadores.
* `PUT /{userId}`: Atualiza os dados de um utilizador.
* `DELETE /{userId}`: Apaga um utilizador e todos os seus dados associados (contas, ações na conta, etc.).

### Contas (`/v1/users/{userId}/accounts`)

* `POST /`: Cria uma nova conta para um utilizador específico.
    * Corpo (Body): `{ "description": "...", "street": "...", "number": ... }`
* `GET /`: Lista todas as contas de um utilizador específico.

### Ações (Stocks)

* `POST /v1/stocks`: Cria um novo tipo de ação no sistema (ex: ITSA4).
    * Corpo (Body): `{ "stockId": "...", "description": "..." }`

### Carteira (`/v1/accounts/{accountId}/stocks`)

* `POST /`: Associa uma ação a uma conta, especificando a quantidade.
    * Corpo (Body): `{ "stockId": "...", "quantity": ... }`
* `GET /`: Lista todas as ações e as suas quantidades para uma conta específica.
