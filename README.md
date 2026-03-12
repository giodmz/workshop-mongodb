# Workshop MongoDB

Projeto Spring Boot com integração ao MongoDB, desenvolvido como material de estudo para persistência de dados com banco NoSQL orientado a documentos.

## Tecnologias

- **Java**
- **Spring Boot**
- **Spring Data MongoDB**
- **Maven**
- **MongoDB**

## Pré-requisitos

- Java 17+
- Maven 3.8+
- MongoDB rodando localmente ou via [MongoDB Atlas](https://www.mongodb.com/atlas)

## Estrutura do Projeto

```
src/
└── main/
    ├── java/
    │   └── com/example/workshopmongodb/
    │       ├── config/         # Configurações
    │       ├── domain/         # Entidades / Documents
    │       ├── repository/     # Repositórios MongoDB
    │       ├── resources/      # Controllers REST
    │       └── services/       # Regras de negócio
    └── resources/
        └── application.properties
```

## Conceitos Abordados

- Mapeamento de documentos com `@Document`
- Repositórios com `MongoRepository`
- Operações CRUD com Spring Data
- Relacionamentos por referência e por embedding
- Consultas customizadas com `@Query`
