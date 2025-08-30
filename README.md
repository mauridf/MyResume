# My Resume - Backend

API desenvolvida em **Java Spring Boot** seguindo os princípios de **DDD** e **SOLID** para cadastro e geração de Currículo Vitae (CV).

## 🚀 Tecnologias
- Java 17
- Spring Boot (Spring Web, Spring Data JPA, Spring Security, Validation)
- MySQL
- JWT (autenticação)
- Logs
- Lombok
- Maven

## 📂 Estrutura do Projeto (DDD)
```
myresume-backend/
 ┣ src/main/java/com/myresume/
 ┃ ┣ domain/         # Entidades e regras de negócio
 ┃ ┣ repository/     # Interfaces de persistência (JPA)
 ┃ ┣ service/        # Regras de aplicação
 ┃ ┣ controller/     # Endpoints REST
 ┃ ┣ config/         # Configurações (JWT, segurança, logs)
 ┗ src/main/resources/
    ┗ application.properties
```

## 🗄️ Modelo de Dados
- Usuário
- Pessoa
- Redes Sociais
- Resumo Profissional
- Habilidades
- Experiência
- ExperiênciaHabilidade
- Formação Acadêmica
- Certificações
- Idiomas

## 📌 Funcionalidades
- Autenticação com JWT
- CRUDs para todas as entidades
- Validações (Bean Validation)
- Logs de inclusão, alteração e exclusão
- Geração de Currículo em formato **PDF/DOC**
- Exposição de dados para frontend (blog/portfolio)

## ▶️ Como rodar o projeto

### Pré-requisitos
- JDK 17+
- MySQL rodando
- Maven

### Passos
```bash
# Clone o repositório
git clone https://github.com/seu-usuario/myresume-backend.git
cd myresume-backend

# Configure o banco no application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/myresume
spring.datasource.username=root
spring.datasource.password=senha

# Rodar o projeto
mvn spring-boot:run
```

## 📜 Commits Semânticos
Exemplo de convenções usadas:
- `feat:` nova funcionalidade
- `fix:` correção de bug
- `refactor:` refatoração de código
- `docs:` alterações de documentação
- `test:` adição/melhoria de testes

## 🔗 Endpoints Principais
- `/auth/login` → autenticação
- `/usuarios` → CRUD Usuários
- `/pessoas` → CRUD Pessoas
- `/experiencias` → CRUD Experiências
- `/habilidades` → CRUD Habilidades
- `/formacoes` → CRUD Formações Acadêmicas
- `/certificacoes` → CRUD Certificações
- `/idiomas` → CRUD Idiomas

## 📄 Licença
Projeto desenvolvido para fins de estudo e prática de arquitetura de software.
