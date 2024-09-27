# Sistema de Gerenciamento de Ações de Extensão

Este projeto é parte da disciplina de Programação Orientada a Objetos (POO) da **Universidade Federal do Vale do São Francisco (Univasf)**. O objetivo é implementar um módulo central de um **Sistema de Gerenciamento de Ações de Extensão**, destinado ao envio e à avaliação de projetos de Extensão da Univasf. O foco principal é o desenvolvimento do **núcleo do sistema**, contemplando sua **arquitetura e modelagem básica**, sem a necessidade de autenticação de usuários ou interfaces gráficas avançadas (desktop, web, mobile).

## Funcionalidades

O módulo deverá implementar as operações básicas **CRUD (Create, Read, Update, Delete)** para o gerenciamento de projetos de Extensão. As principais funcionalidades incluem:

1. **Criação de Projetos de Extensão**: Permite o cadastro de novos projetos, incluindo informações como título, descrição, coordenador, duração, entre outros.
2. **Leitura de Projetos Cadastrados**: Exibe uma lista de projetos cadastrados e suas respectivas informações.
3. **Atualização de Projetos**: Permite a edição das informações dos projetos existentes.
4. **Exclusão de Projetos**: Remove projetos do sistema.

Além disso, o sistema deve garantir a **persistência dos dados** utilizando **serialização** (Java Serialization) para armazenar e recuperar as informações dos projetos.

## Requisitos

- **Java**: O módulo será implementado em Java.
- **POO**: O código deve seguir os princípios da Programação Orientada a Objetos.
- **Serialização**: Utilização de serialização para salvar e carregar dados dos projetos.
- **Interface de Console**: O sistema deve conter uma interface de console simples para que as funcionalidades possam ser testadas.
