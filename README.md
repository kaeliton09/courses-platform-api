# Courses Platform API

API backend em desenvolvimento para uma plataforma de cursos, construída com Java e Spring Boot.

## Objetivo

Projeto de prática de desenvolvimento backend e organização de uma aplicação Java com persistência de dados.

## Tecnologias identificadas no projeto

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Banco de dados H2
- Lombok
- Maven

O projeto também inclui dependências relacionadas a criptografia do Spring Security e ferramentas de teste do Spring Boot. A presença dessas dependências não significa, por si só, que autenticação ou todos os testes estejam implementados.

## Como executar

### Pré-requisitos

- JDK 21
- Git

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/kaeliton09/courses-platform-api.git
   cd courses-platform-api
   ```

2. Execute a aplicação usando o Maven Wrapper:

   **Linux/macOS**
   ```bash
   ./mvnw spring-boot:run
   ```

   **Windows**
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

3. Para executar os testes automatizados:

   **Linux/macOS**
   ```bash
   ./mvnw test
   ```

   **Windows**
   ```powershell
   .\mvnw.cmd test
   ```

## Estrutura e funcionalidades

Consulte o código-fonte para verificar os recursos implementados, os endpoints disponíveis e a configuração do banco de dados. Atualize esta seção conforme as funcionalidades forem concluídas.

## Repositório

https://github.com/kaeliton09/courses-platform-api
