# Automação de serviços da Petstore

Projeto foi criado com o objetivo de certificar conhecimentos de automação de APIs

## Tecnologias utilizadas

- [JAVA 11](https://docs.oracle.com/en/java/)
- [RestAssured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
- [Junit](https://junit.org/junit5/)
- [Maven](https://maven.apache.org/)

## IDE Utilizada

- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)

## Arquivos e diretórios:

- /src/test/java/petstore/dataFactory:
  Diretório que contém a refatoração do body Json para que tenha um código limpo;

- /src/test/java/petstore/modulos/pet:
  Testes relacionados ao módulo pet, para melhor organização;

- /src/test/java/petstore/modulos/store:
  Testes relacionados ao módulo store, para melhor organização;

- /src/test/java/petstore/pojo:
  Diretório que contém getters e setters para uso  no dataFactory;

- /src/test/java/petstore/testBase:
  Diretório que contém um @BeforeEach da baseURL, para reutilização do código usando herança.



## Execução 
Para executar as suites de testes, abra o terminal na pasta raiz do projeto e execute o comando abaixo:
`mvn test`

Para limpar a pasta target,execute o comando abaixo:
`mvn clean`

![Alt Text](/imagens/img.png)


<p>Para executar no próprio código, clique em <b>Run test</b> da classe desejada </p>



*Autor:*
*Mateus Pereira de Oliveira Neres*