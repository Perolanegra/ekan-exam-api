<h1 align="center">
Desafio Processo Seletivo da Ekan
</h1>

<p align="center">
  Criar uma API de Cadastro de Beneficiarios e Documentos.
</p>

<p align="center">
  <a href="#page_with_curl-sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#books-dependencias">Dependencias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#star-requisitos">Requisitos</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;  
  <a href="#rocket-começando">Começando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#computer-iniciando-o-projeto">Iniciando o Projeto</a>&nbsp;&nbsp;&nbsp;
</p>

## :page_with_curl: Sobre
Este repositório contém um sistema baseado em arquitetura Rest Api desenvolvida com Java e Spring Boot, o H2 para a persistência de dados com Spring Data, 
o Swagger e Insomnia para a documentação dos endpoints, o spring-validation para fazer as validações necessárias da Api, junit e mockito para os testes unutários.

## :books: **Dependencias**


**spring-boot-starter-web**: Utilizado para tornar a aplicação web.

**spring-boot-starter-data-jpa**: Utilizado para fazer a integração com o banco de dados e gerenciar a persistência de dados do sistema.

**spring-boot-starter-validation**: Utilizado para as validações dos Models, DTOs, etc.

**spring-boot-devtools**: Utilizado para o LiveReload do servidor.

**springfox-swagger**: Utilizado para documentar a Api.

**junit-vintage-engine**: Utilizado para fazer os testes unitários da aplicação.


## :star: Requisitos
- Ter [**Git**](https://git-scm.com/) para clonar o projeto.
- Ter [**Java 11**](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) instalado.
- Ter [**Maven**]([https://gradle.org/install/](https://maven.apache.org/download.cgi)) instalado. (Opcional)


## :rocket: Começando
``` bash
  # Clonar o projeto:
  $ git clone https://github.com/Perolanegra/ekan-exam-api

  # Entrar no diretório do projeto:
  $ cd ekan-exam-api
```

## :computer: Iniciando o Projeto
```bash
  # Instalar as dependências:
  $ mvn clean install 

  # Rodar a aplicação:
  $ mvn spring-boot:run

  # Rodar a aplicação com o CMD:
  $ Entrar no diretorio onde está o arquivo .JAR, na pasta do projeto
  $ abrir o CMD e executar o seguinte comando: java -jar ekan-exam-API.jar

```

Feito com ❤️ por Igor Alves 👋🏻 [Get in touch!](https://github.com/Perolanegra)
