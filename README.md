# 🐾 Petshop API
### Trabalho 05 AV2 — Técnicas de Integração de Sistemas

API REST para gerenciamento de clientes, pets e profissionais de um petshop, desenvolvida com Spring Boot e PostgreSQL, documentada seguindo o padrão OpenAPI 3.0 e disponibilizada via Swagger UI.

---

## 🔗 Links

| | URL |
|---|---|
| **API** | https://petshop-api-production-ebc2.up.railway.app |
| **Swagger UI** | https://petshop-api-production-ebc2.up.railway.app/swagger-ui/index.html |

---

## 📋 Endpoints

### Clientes — `/clientes`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/clientes` | Cadastrar novo cliente |
| `GET` | `/clientes` | Listar todos os clientes |
| `GET` | `/clientes/{id}` | Buscar cliente por ID |
| `PUT` | `/clientes/{id}` | Atualizar cliente |
| `DELETE` | `/clientes/{id}` | Deletar cliente |

### Pets — `/pets`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/pets` | Cadastrar novo pet |
| `GET` | `/pets` | Listar todos os pets |
| `GET` | `/pets/{id}` | Buscar pet por ID |
| `PUT` | `/pets/{id}` | Atualizar pet |
| `DELETE` | `/pets/{id}` | Deletar pet |

### Profissionais — `/profissionais`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/profissionais` | Cadastrar novo profissional |
| `GET` | `/profissionais` | Listar todos os profissionais |
| `GET` | `/profissionais/{id}` | Buscar profissional por ID |
| `PUT` | `/profissionais/{id}` | Atualizar profissional |
| `DELETE` | `/profissionais/{id}` | Deletar profissional |

---

## 🧪 Testando a API

Importe a URL base no **Postman** ou **Insomnia** e faça as requisições diretamente contra o ambiente de produção.

A especificação OpenAPI também está disponível em:
```
https://petshop-api-production-ebc2.up.railway.app/v3/api-docs
```

---

## ⚙️ Rodando localmente

### Pré-requisitos

- Java 21
- Docker e Docker Compose

### Passos

```bash
# 1. Clone o repositório
git clone https://github.com/sergiocostaczr/petshop-api.git
cd petshop-api

# 2. Suba o banco de dados
docker-compose up -d

# 3. Configure as variáveis de ambiente
# Crie src/main/resources/application-local.properties com:
# DB_URL=jdbc:postgresql://localhost:5432/petshopapi
# DB_USER=postgres
# DB_PASSWORD=postgres

# 4. Rode a aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080` e o Swagger UI em `http://localhost:8080/swagger-ui/index.html`.

---

## 🏗️ Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Lombok
- SpringDoc OpenAPI 3.0
- Docker / Railway
