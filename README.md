# Desafio implementação modelo Movie Flix

Implementar as classes propostas no modelo em um projeto com testes, com o objetivo de fazer os testes passarem

## Tecnologias utilizadas

* Java 11
* Spring boot 2.4.4
* Spring Data JPA (ORM para integração com banco de dados)
* Banco h2 (banco em memória para testes)
* Beans Validation
* Spring security
* Autorização com Oauth2

 ### OBSERVAÇÃO:
  A implementação da autenticação via token JWT nessa aplicação não possui um controller,
  porque vem direto pela implementação das configurações na pasta "com.devsuperior.movieflix.config".
  A autenticação deve ser passada no header, e é do tipo "x-www-form-urlencoder", utilizando
  "client-id" e "client-secret".
  Futuramente farei uma outra versão com controller para o Login com entradas via
  body JSON, para facilitar.
  

![Diagrama de classes](https://github.com/brunoclaumari/bds05-bruno-sousa/blob/main/Diagrama%20de%20classes%20MovieFlix.png)



