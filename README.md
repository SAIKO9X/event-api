# Sistema de Gerenciamento de Eventos (Estudo de Clean Architecture)

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

## 🎯 Sobre o Projeto

Este projeto é uma API REST para gerenciamento de eventos, desenvolvido como um exercício prático para estudar e aplicar os conceitos de **Clean Architecture** em um ambiente Java com Spring Boot. O principal objetivo é criar um sistema desacoplado, testável, escalável e independente de frameworks, onde as regras de negócio são o núcleo da aplicação.

A arquitetura e os conceitos foram baseados nos ensinamentos do curso **Java10x**.

---

## 🏛️ Arquitetura e Conceitos Aplicados

O projeto segue rigorosamente a **Regra de Dependência** da Clean Architecture, onde as dependências sempre apontam para dentro, do mais baixo nível (infraestrutura) para o mais alto nível (regras de negócio).

### Estrutura de Pacotes

A estrutura de pacotes foi desenhada para refletir a separação de responsabilidades:

```
com.event
├── core
│   ├── entities      // Entidades de negócio (Ex: Event)
│   ├── enums         // Enumerações de negócio
│   ├── exceptions    // Exceções de negócio personalizadas
│   ├── gateway       // Interfaces (Ports) que definem os contratos com a camada externa
│   └── useCases      // Regras de negócio da aplicação (Interactors)
│
└── infra
    ├── config        // Configuração de Beans do Spring
    ├── controllers   // Adaptadores de entrada (API REST)
    ├── exceptions    // Manipulador global de exceções da infraestrutura
    ├── gateway       // Implementação dos Gateways da camada core
    ├── mapper        // Mapeamento entre DTOs, Entidades de Domínio e Entidades de Persistência
    ├── persistence   // Lógica de persistência (JPA Repositories, Entities)
    ├── request       // DTOs (Data Transfer Objects) para as requisições
    └── response      // DTOs para as respostas da API
```

- **`core`**: Camada de domínio e regras de negócio. Não possui nenhuma dependência com frameworks externos (como Spring ou JPA). É o coração da aplicação.
- **`infra`**: Camada de infraestrutura. Contém os detalhes de implementação, como a API web, o acesso ao banco de dados e outras integrações. Esta camada depende da camada `core`, implementando suas interfaces (Gateways).

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Flyway** (Versionamento de banco de dados)
- **Postgresql** (Banco de dados relacional)
- **Lombok** (Para reduzir código boilerplate)

---

## 🚀 Como Executar o Projeto

**Pré-requisitos:**
- JDK 17 ou superior
- Maven 3.8 ou superior

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/SAIKO9X/event-api.git)
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd event-api
   ```

3. **Execute a aplicação com o Maven:**
   ```bash
   mvn spring-boot:run
   ```

4. A API estará disponível em `http://localhost:8080`.

---

## 🔌 Endpoints da API

A seguir, a lista de endpoints disponíveis na API:

| Método | Rota             | Descrição                                 |
|--------|------------------|-------------------------------------------|
| `POST` | `/events`        | Cria um novo evento.                      |
| `GET`  | `/events/{id}`   | Busca um evento específico pelo seu ID.   |
| `GET`  | `/events`        | Lista todos os eventos cadastrados.       |
| `PUT`  | `/events/{id}`   | Atualiza um evento existente pelo seu ID. |

## 📜 Licença

Este projeto é distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.