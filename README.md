# PROJETO SPRING BOOT COM MONGODB

O projeto consiste em uma API rest de um sistema de Usuários, Posts e comentários, busca e atualização de usuário por ID, busca de posts por id, busca de posts por título.

Endereço local: http://localhost:8080/



## Requisitos

JDK 11

Sprint Tool Suit 4 ou qualquer IDE de sua preferência

Postman Client

MongoDB



## Dependências

- Spring Web
- MongoDB 



## Modelo lógico com padrão em camadas

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/padrao-camadas.PNG)

## Modelo de domínio - UML

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/modelo-logico.PNG)



## Configuração do application.properties

*** Abrir o arquivo application.properties em src/main/resources  e colar o conteúdo abaixo ***

```
spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```



## Requisição Client utilizando o POSTMAN

![](https://github.com/andrezasecon/Springboot2-Java11-CRUD/blob/master/imagens/POSTMAN.png)



### GET - Find All

Status esperado: 200 ok

**`http://localhost:8080/users`**

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/findAllUSers.PNG)



### GET - Find Posts by ID

Para buscar o item desejado passar o ID como parâmetro na requisição, Status esperado: 200 ok

- **ID do Post**

**`http://localhost:8080/posts/6088be2a31a9ce2aa8e6d460`**

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/findPostByIdPost.PNG)

### GET - Find Post By Title

**`http://localhost:8080/posts/titlesearch?text=bom%20dgfdsgf`** = utilizando a palavra bom

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/findByTitle.PNG)

### GET - Find Post with criterion

**`http://localhost:8080/posts/fullsearch?text=aproveite&minDate=2021-03-21&maxDate=2021-03-22`**

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/fullsearch.PNG)

### POST - Insert User

Para inserir um usuário, colocar no Body, raw, tipo Json, inserir os dados desejados no formato Json, Status esperado: 201 created

**/users**

```
{
    "name": "Leonardo Secon",
    "email": "leonardo@gmail.com"
}
```



![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/postUser.PNG)

### PUT - Update User By ID

Para atualizar um registro, passar o id desejado na requisição

**/users/6089df52be80a47d9384b182**

No Body da requisição clicar em raw, tipo Json e adicionar o campo que deseja alterar no formato Json

```
{
    "name": "Leonardo Carvalho",
    "email": "leonardocarvalho@gmail.com"
}
```

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/updateUser.PNG)

### DELETE - Delete User by ID

Para excluir um item, passar o ID como parâmetro da requisição

**/users/6089dac9be80a47d9384b17d**

![](https://github.com/andrezasecon/api_springboot_mongoDB/blob/master/imagens/deleteUser.PNG)



### 