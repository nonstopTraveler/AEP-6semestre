# Alunos:
 Danilo Antonio Alves Rosa, RA:24047644-2
 Renan Homiak Guimarães, RA: 24000668-2

# DoeLivro

> Plataforma de doação de livros desenvolvida como Prova de Conceito (PoC) para a Atividade de Estudo Programada (AEP) do 6º semestre de Engenharia de Software.

---

# Problema

O acesso à leitura ainda é um desafio para muitas pessoas devido ao alto custo de livros didáticos, técnicos e literários. Ao mesmo tempo, milhares de livros permanecem armazenados sem uso ou acabam sendo descartados após cumprirem sua finalidade.

A ausência de uma plataforma simples para conectar pessoas que desejam doar livros com aquelas que precisam deles reduz o reaproveitamento desses materiais e dificulta o acesso ao conhecimento.

O **DoeLivro** busca solucionar esse problema oferecendo uma plataforma onde usuários podem cadastrar livros disponíveis para doação, promovendo o compartilhamento de conhecimento, o incentivo à leitura e o reaproveitamento de livros em bom estado.

---

# ODS relacionada

## **ODS 4 — Educação de Qualidade**

Este projeto está alinhado ao **Objetivo de Desenvolvimento Sustentável nº 4 da Organização das Nações Unidas (ONU)**, que busca assegurar uma educação inclusiva, equitativa e de qualidade, promovendo oportunidades de aprendizagem ao longo da vida para todos.

Ao facilitar a doação de livros, o DoeLivro contribui para ampliar o acesso ao conhecimento, incentivando a circulação de materiais educacionais e literários, reduzindo barreiras econômicas ao aprendizado e promovendo uma educação mais acessível para a comunidade.

---

# Público-alvo

A plataforma é destinada a pessoas interessadas em doar livros e a estudantes, leitores e instituições que buscam acesso a materiais de leitura de forma gratuita.

---

# Tecnologias utilizadas

- **Java 21**
- **Spring Boot**
  - spring-boot-starter-web
  - spring-boot-starter-data-mongodb
- **MongoDB** (Banco de Dados NoSQL)
- **Maven**
- **JUnit 5**
- **Mockito**
- **JaCoCo** (Cobertura de testes)
- **Git e GitHub**
- **HTML5**
- **CSS3**
- **JavaScript**

---

# Arquitetura

O projeto está organizado em camadas para manter uma separação clara de responsabilidades:

```text
controller/  → recebe as requisições HTTP
service/     → implementa as regras de negócio
repository/  → acesso ao MongoDB
model/       → entidades persistidas na coleção de livros
```

Essa arquitetura facilita a manutenção, evolução e organização do código, seguindo princípios da Programação Orientada a Objetos.

---

# Funcionalidades da 1ª entrega

A primeira versão da PoC contempla:

- Cadastro de livros para doação;
- Listagem dos livros cadastrados;
- Consulta das informações dos livros;
- Exclusão de livros cadastrados;
- Persistência dos dados utilizando MongoDB;
- Interface web para interação com o sistema.

> Novas funcionalidades serão adicionadas na segunda entrega da AEP.

---

# Como executar

## Pré-requisitos

- Java 21;
- Maven;
- MongoDB em execução.

## Passo a passo

1. Clonar o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

2. Entrar na pasta do projeto:

```bash
cd DoeLivro
```

3. Executar a aplicação:

```bash
mvn spring-boot:run
```

4. Acessar a aplicação em:

```text
http://localhost:8080
```

---

# Como executar os testes

Para executar os testes automatizados:

```bash
mvn test
```

Para gerar e validar a cobertura mínima de testes:

```bash
mvn verify
```

O relatório de cobertura será gerado em:

```text
target/site/jacoco/index.html
```

---

# Estrutura do banco de dados

A primeira entrega utiliza uma única coleção NoSQL contendo documentos homogêneos referentes aos livros cadastrados para doação.

Exemplo:

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "categoria": "Tecnologia",
  "estadoConservacao": "Bom",
  "doador": "João Silva"
}
```

---

# Estrutura do projeto

```text
src
├── main
│   ├── java
│   │   └── com
│   │       └── aep
│   │           └── ler
│   │               ├── LerApplication.java
│   │               ├── controller
│   │               │   └── LivroController.java
│   │               ├── model
│   │               │   └── Livro.java
│   │               ├── repository
│   │               │   └── LivroRepository.java
│   │               └── service
│   │                   └── LivroService.java
│   └── resources
│       ├── application.properties
│       └── static
│           ├── index.html
│           ├── script.js
│           └── style.css
└── test
    └── java
        └── com
            └── aep
                └── ler
                    ├── LerApplicationTests.java
                    ├── controller
                    │   └── LivroControllerTest.java
                    ├── model
                    │   └── LivroTest.java
                    └── service
                        └── LivroServiceTest.java
```

---

