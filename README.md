# 💰 FinanceHub API

Uma API REST desenvolvida com **Spring Boot** para gerenciamento financeiro pessoal.

O sistema permite que usuários cadastrem categorias, registrem receitas e despesas, acompanhem seu saldo financeiro através de um dashboard e gerenciem todas as suas movimentações com autenticação JWT.

---


# 🚀 Tecnologias

- Java 21
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Spring Data JPA
- Flyway
- Maven
- Swagger / OpenAPI
- Lombok
- Docker (em breve)

---

# 📋 Funcionalidades

## Autenticação

- Cadastro de usuários
- Login utilizando JWT
- Autenticação Bearer Token
- Rotas protegidas

---

## Categorias

- Criar categoria
- Listar categorias
- Buscar categoria por ID
- Atualizar categoria
- Remover categoria

Cada categoria pertence apenas ao usuário autenticado.

---

## Transações

- Criar transação
- Listar transações
- Buscar por ID
- Atualizar transação
- Remover transação
- Paginação

Cada transação pertence exclusivamente ao usuário autenticado.

---

## Dashboard

Resumo financeiro contendo:

- Total de Receitas
- Total de Despesas
- Saldo Atual

---

## Validações

- Bean Validation
- Tratamento global de exceções
- Respostas padronizadas de erro

---

## Documentação

Documentação automática utilizando Swagger/OpenAPI.

---

# 🔒 Segurança

A autenticação é realizada utilizando **JWT (JSON Web Token)**.

Todas as rotas (exceto autenticação) exigem um token válido.

Fluxo:

```
Login

↓

JWT

↓

Bearer Token

↓

Requisições autenticadas
```

---

# 📂 Estrutura do Projeto

```
src/main/java
│
├── auth
│
├── category
│
├── common
│
├── config
│
├── dashboard
│
├── transaction
│
└── user
```

---

# 📚 Endpoints

## Auth

| Método | Endpoint |
|---------|----------|
| POST | /auth/register |
| POST | /auth/login |

---

## Usuário

| Método | Endpoint |
|---------|----------|
| GET | /users/me |

---

## Categorias

| Método | Endpoint |
|---------|----------|
| GET | /categories |
| GET | /categories/{id} |
| POST | /categories |
| PUT | /categories/{id} |
| DELETE | /categories/{id} |

---

## Transações

| Método | Endpoint |
|---------|----------|
| GET | /transactions |
| GET | /transactions/{id} |
| POST | /transactions |
| PUT | /transactions/{id} |
| DELETE | /transactions/{id} |

Suporte à paginação:

```
GET /transactions?page=0&size=10
```

---

## Dashboard

| Método | Endpoint |
|---------|----------|
| GET | /dashboard |

---

# ▶️ Como executar

## Clonar o projeto

```bash
git clone https://github.com/AugustoSouza126/FinanceHub-API.git
```

```bash
cd FinanceHub-API
```

---

## Banco de Dados

Configure um banco PostgreSQL e altere o arquivo:

```
application.properties
```

com suas credenciais.

---

## Executar

```bash
./mvnw spring-boot:run
```

ou execute diretamente pela IDE.

---

# 📖 Swagger

Após iniciar a aplicação:

```
http://localhost:8081/swagger-ui/index.html
```

---

# 🛠 Arquitetura

A aplicação foi organizada em módulos por domínio, facilitando manutenção e escalabilidade.

```
Controller

↓

Service

↓

Repository

↓

PostgreSQL
```

---

# 📌 Próximas melhorias

- Frontend Angular
- Deploy da API
- Docker Compose
- Dashboard com gráficos
- Testes automatizados

---

# 👨‍💻 Autor

**Augusto Souza**

GitHub

https://github.com/AugustoSouza126

LinkedIn

https://www.linkedin.com/in/augusto-souza-795324313/

---

⭐ Caso tenha gostado do projeto, deixe uma estrela no repositório.