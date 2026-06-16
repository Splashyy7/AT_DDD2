# AT — Domain-Driven Design (DDD) e Arquitetura de Softwares Escaláveis com Java

Repositório para entrega do **AT** da matéria **Domain-Driven Design (DDD) e Arquitetura de Softwares Escaláveis com Java**.

O trabalho modela parte do ecossistema **PetFriends**, com foco nos microsserviços de backend desenvolvidos em **Java** com **Spring Boot**.

## Estrutura do repositório


| Pasta                                                  | Microsserviço               | Descrição                                                                         |
| ------------------------------------------------------ | --------------------------- | --------------------------------------------------------------------------------- |
| `[petfriends_almoxarifado/](petfriends_almoxarifado/)` | **PetFriends_Almoxarifado** | Preparação de pedidos no estoque (estado *Em Preparação*)                         |
| `[petfriends_transporte/](petfriends_transporte/)`     | **PetFriends_Transporte**   | Entrega de pedidos (estados *Em Trânsito*, *Entregue*, *Devolvido*, *Extraviado*) |


Cada pasta contém um projeto Maven independente com domínio, persistência (JPA/H2) e integração assíncrona via RabbitMQ para receber eventos do microsserviço **PetFriends_Pedidos**.