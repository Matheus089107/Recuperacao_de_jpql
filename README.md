# API REST - Gerenciamento de Projetos e Tarefas 🚀

API REST desenvolvida em **Java** com **Spring Boot** e **MySQL** para o gerenciamento de projetos de software e suas respectivas tarefas corporativas. Projeto desenvolvido como parte da avaliação de recuperação da unidade de Programação de APIs (Turma MI77) - SENAI/SC.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA** (Persistência de dados)
* **MySQL** (Banco de dados relacional)
* **Lombok** (Produtividade)
* **MapStruct / DTOs** (Transferência e mapeamento de dados)

---

## 📐 Arquitetura do Projeto

O sistema foi construído seguindo a arquitetura em camadas para garantir a separação de responsabilidades:
* **Controladores (`Controller`):** Portas de entrada dos endpoints REST.
* **Serviços (`Service`):** Camada de lógica de negócio e validações.
* **Repositórios (`Repository`):** Consultas ao banco de dados com JPA/JPQL/Native Query.
* **Entidades (`Model`):** Classes de domínio mapeadas para o banco de dados.
* **DTOs:** Objetos de transferência de dados para proteção da API.

---

## 🔥 Funcionalidades e Destaques Técnicos

### 1. CRUD Completo com Cascade
* Gerenciamento total de **Projetos** e **Tarefas** (Criar, Listar, Buscar por ID, Atualizar e Deletar).
* Implementação de `CascadeType.ALL` e `orphanRemoval = true` no relacionamento `@OneToMany` para garantir a integridade referencial ao deletar registros.

### 2. Consulta Otimizada com JPQL (JOIN FETCH)
Para listar as tarefas de um projeto específico de forma altamente performática e evitar o problema de consultas *N+1*, foi utilizada a cláusula `JOIN FETCH`:
```java
@Query("SELECT t FROM Tarefa t JOIN FETCH t.projeto p WHERE p.id = :projetoId")
List<Tarefa> listarTarefasPorProjetoId(@Param("projetoId") Long projetoId);
