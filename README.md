# Spring CRUD API 🚀

![Java Version](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

Projeto backend desenvolvido com **Spring Boot** para estudo de **CRUD**, **Spring Data JPA** e **arquitetura em camadas**.

## 📋 Sobre o Projeto

Aplicação backend que implementa um **CRUD de usuários**, sem interface gráfica, focada exclusivamente em **lógica de negócio**, **persistência de dados** e **organização do código** seguindo boas práticas do Spring.

## 🏗️ Estrutura de Pastas

Arquitetura em camadas para melhor organização e manutenção:

- `business` — regras de negócio  
- `controller` — camada de controle  
- `infrastructure/entity` — entidades JPA  
- `infrastructure/repository` — acesso a dados com Spring Data  
- `main` — inicialização da aplicação  
---
## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Data JPA**
* **H2 Database**
* **Maven**
---
## Como executar
- Fazer git clone do repositorio com comando [ git clone https://github.com/ViniciusS4ntos/spring-crud-api.git ]
- Ter o **JDK 21** instalado
- Ter o **Docker**
- Abrir o repositorio por alguma ide ( Prefira Intelij )
- usar o comando [ mvn clean package ] para gerar um .jar
- usar  o comando [ docker build -t spring-crud-api .
- usar o comando [ docker run -p 8080:8080 spring-crud-api ]
- e fazer bom uso

## 🔗 Exemplos de uso com Query Params

A aplicação utiliza **query parameters** para identificar o usuário em algumas operações.  
A ação executada depende do **método HTTP escolhido no Postman**.

### URL base
http://localhost:8080/user


---

### 📄 GET – Buscar usuário por email

Para buscar um usuário, é necessário informar o **email** como parâmetro.
GET http://localhost:8080/user?email=EdsonViniciusss@email.com

---

### ➕ POST – Criar usuário

A criação do usuário pode utilizar o **email como parâmetro**, juntamente com o corpo da requisição.
POST http://localhost:8080/user?email=EdsonViniciusss@email.com&nome=edson

---

### ✏️ PUT – Atualizar usuário por ID

Para atualizar um usuário, é obrigatório informar o **ID**.
PUT http://localhost:8080/user?id=1

---

### ❌ DELETE – Deletar usuário por email

Para deletar um usuário, é necessário informar o **email**.
DELETE http://localhost:8080/user?email=sdadsasdasd

---

### ℹ️ Observação Importante

- **GET e DELETE** utilizam parâmetros na URL para identificar o usuário  
- **PUT** exige o **ID** do usuário  
- **POST** cria um novo registro  
- O comportamento da rota depende do **método HTTP selecionado no Postman**




## 🎯 Objetivo

- Praticar Spring Boot
- Aplicar Spring Data JPA
- Consolidar arquitetura em camadas
- Servir como projeto de portfólio backend
