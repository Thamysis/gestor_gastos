# Gestor de Gastos - Backend

Projeto desenvolvido como parte da disciplina de **SSC0961 - Desenvolvimento Web e Mobile**, utilizando **Spring Boot** para criar a API de backend da aplicação de gestão de gastos.

## ✨ Descrição

Este repositório contém o **backend** do sistema **Gestor de Gastos**, uma aplicação Java baseada em Spring Boot que visa facilitar o controle financeiro de usuários.  
A API permite registrar, consultar e gerenciar dados de despesas, servindo como base para o consumo por um frontend (web ou mobile).

## 🚀 Tecnologias Utilizadas

- Java 23
- Spring Boot 3.4.0
- Spring Data JPA
- Spring Web
- PostgreSQL
- Lombok
- Maven

## ⚙️ Como Rodar o Projeto (Windows)

### ✅ Pré-requisitos

- [Java JDK 23](https://www.oracle.com/java/technologies/javase/jdk-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL + pgAdmin](https://www.postgresql.org/download/windows/)

### 🔧 Instalação e Configuração

#### 1. Instale o Java

- Baixe o JDK 23 e adicione a pasta `/bin` à variável de ambiente `PATH`.
- Verifique com:

    java -version

#### 2. Instale o Maven

- Extraia o Maven e adicione a pasta /bin do Maven à variável de ambiente PATH.
- Verifique com:

    mvn -v

#### 3. Configure o PostgreSQL

##### Opção A – Usando o terminal psql

- Abra o SQL Shell (psql).
- Pressione Enter até chegar ao prompt postgres=#.
- Crie banco e usuário:

    CREATE DATABASE gestor_gastos;
    CREATE USER seu_usuario WITH PASSWORD 'sua_senha';
    GRANT ALL PRIVILEGES ON DATABASE gestor_gastos TO seu_usuario;

##### Opção B – Usando o pgAdmin

- Abra o pgAdmin.
- Crie um banco chamado gestor_gastos.
- Crie um usuário (Login/Group Role) com nome e senha, e atribua privilégios no banco.
- Configure o arquivo application.properties

No diretório src/main/resources/application.properties, adicione:

    spring.application.name=gestor_gastos

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:postgresql://localhost:12345/gestor_gastos
    
    spring.datasource.username=postgres
    spring.datasource.password=12345

    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    server.port=8080
   
### ▶️ Executando o Projeto

No terminal/prompt de comando, dentro da pasta do projeto:

    ./mvnw spring-boot:run

Ou, se estiver usando o Maven instalado:

    mvn spring-boot:run

A API estará disponível em: http://localhost:8080

### 🧪 Rodando os Testes

    mvn test

## 📬 Testando a API com Postman

Você pode testar os endpoints da API localmente utilizando o [Postman](https://www.postman.com/downloads/), uma ferramenta gráfica que permite enviar requisições HTTP e visualizar respostas de APIs.

### 🛠️ Passo a Passo

#### 1. Instale o Postman

Baixe e instale a versão mais recente em: [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

#### 2. Inicie a aplicação

Execute o projeto com:

    ./mvnw spring-boot:run


A API deve iniciar em http://localhost:8080.

#### 3. Crie uma nova requisição no Postman

### ▶️ Requisição POST - Criar uma despesa
**Método:** POST

**URL:** http://localhost:8080/api/despesas

**Aba:** Body

**Selecione:** raw

**Tipo:** JSON

**Corpo:**

    {
    "nome": "Supermercado",
    "descricao": "Compras do mês",
    "valor": 450.75,
    "data": "2025-06-01",
    "categoria": "Alimentação"
    }


Clique em **Send**

### ▶️ Requisições

**Base URL:** http://localhost:8080/api/

| Método | Rota                           | Descrição                                |
|--------|--------------------------------|-------------------------------------------|
| GET    | /api/contasBancarias           | Lista todas as contas bancárias           |
| GET    | /api/contasBancarias/{id}      | Busca uma conta bancária pelo ID          |
| POST   | /api/contasBancarias           | Cria uma nova conta bancária              |
| PUT    | /api/contasBancarias/{id}      | Atualiza uma conta bancária existente     |
| DELETE | /api/contasBancarias/{id}      | Remove uma conta bancária pelo ID         |
| GET    | /api/contasPagar               | Lista todas as contas a pagar             |
| GET    | /api/contasPagar/{id}          | Busca uma conta a pagar pelo ID           |
| POST   | /api/contasPagar               | Cria uma nova conta a pagar               |
| PUT    | /api/contasPagar/{id}          | Atualiza uma conta a pagar existente      |
| DELETE | /api/contasPagar/{id}          | Remove uma conta a pagar pelo ID          |
| GET    | /api/despesas                  | Lista todas as despesas                   |
| GET    | /api/despesas/{id}             | Busca uma despesa pelo ID                 |
| POST   | /api/despesas                  | Cria uma nova despesa                     |
| PUT    | /api/despesas/{id}             | Atualiza uma despesa existente            |
| DELETE | /api/despesas/{id}             | Remove uma despesa pelo ID                |
| GET    | /api/receitas                  | Lista todas as receitas                   |
| GET    | /api/receitas/{id}             | Busca uma receita pelo ID                 |
| POST   | /api/receitas                  | Cria uma nova receita                     |
| PUT    | /api/receitas/{id}             | Atualiza uma receita existente            |
| DELETE | /api/receitas/{id}             | Remove uma receita pelo ID                |
| GET    | /api/usuarios                  | Lista todos os usuários                   |
| GET    | /api/usuarios/{id}             | Busca um usuário pelo ID                  |
| POST   | /api/usuarios                  | Cria um novo usuário                      |
| PUT    | /api/usuarios/{id}             | Atualiza um usuário existente             |
| DELETE | /api/usuarios/{id}             | Remove um usuário pelo ID                 |

Na raiz da pasta tem uma coleção para o postman com as várias requisições.


