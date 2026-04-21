# 🃏 Blackjack (21)

Este projeto é uma aplicação **Fullstack** moderna que simula o clássico jogo de cartas Blackjack (21). Desenvolvido como atividade de avaliação para o projeto **Hack the Favela** (módulo Java) pelo **alt.bank**, ele demonstra a integração entre um backend robusto em Quarkus e um frontend reativo de alta performance em Angular 21.

---

## 🚀 Tecnologias e Arquitetura

### 🖥️ Frontend

- **Framework:** Angular 21 (Versão estável mais recente)
- **Estado & Reatividade:** **Signals** (Gerenciamento de estado nativo e granular)
- **Estilização:** Tailwind CSS (Interface responsiva e Mobile First)
- **Comunicação:** HttpClient com Interceptors para tratamento global de erros.

### ⚙️ Backend

- **Linguagem:** Java 21 (LTS)
- **Framework:** Quarkus 3.34.5
- **Arquitetura:** Clean Architecture (Separação clara entre Use Cases, Domain Entities e Web Resources)
- **Documentação:** Swagger UI (OpenAPI)
- **Gerenciador de Dependências:** Maven
- **Framework de Testes:** JUnit 5
- **Testes de API:** RestAssured (utilizado para validar os contratos REST e códigos de status HTTP)
- **Mocks & Spies:** Mockito (utilizado para mockar o Baralho ou repositórios, garantindo testes unitários determinísticos)
- **Quarkus Test:** Utilização da anotação @QuarkusTest para gerenciamento do ciclo de vida do CDI durante os testes

### 📁 Estrutura de pastas do projeto

```
├── backend/                # Projeto Quarkus (Java 21)
│   ├── src/main/java       # Código fonte (Clean Arch)
│   ├── src/test/java       # Testes unitários e de integração
│   └── pom.xml             # Dependências Maven
├── frontend/               # Projeto Angular 21 (Zoneless)
│   ├── src/app             # Componentes, Signals e Layouts
│   ├── Dockerfile          # Build multi-stage do Angular
│   └── nginx.conf          # Configuração de roteamento
└── docker-compose.yaml     # Orquestração do ecossistema
```

---

## 🛠️ Como Executar o Projeto

A forma mais simples rodar a aplicação completa (Frontend + Backend) é utilizando o **Docker**.

### Pré-requisitos

- Docker e Docker Compose instalados.

### Passo a Passo

1.  Na raiz do monorepo, execute o comando:
    ```bash
    docker-compose up --build
    ```
2.  Aguarde a compilação de ambos os projetos (o Docker fará o build do Java e do Angular automaticamente).
3.  Acesse a aplicação no seu navegador:
    - **Frontend:** `http://localhost:4200`
    - **Backend & Swagger:** `http://localhost:8080/swagger-ui`

---

## 🛣️ Endpoints da API (REST)

O backend expõe os seguintes endpoints para o controle da partida:

| Método   | Endpoint                   | Descrição                                                |
| :------- | :------------------------- | :------------------------------------------------------- |
| `POST`   | `/api/partida/novo-jogo`   | Inicializa uma nova mesa e distribui as cartas iniciais. |
| `GET`    | `/api/partida`             | Retorna o estado atual da partida e mãos dos jogadores.  |
| `PATCH`  | `/api/partida/pedir-carta` | O jogador solicita uma nova carta (Hit).                 |
| `PATCH`  | `/api/partida/parar`       | O jogador encerra sua vez (Stand) e passa para o Dealer. |
| `DELETE` | `/api/partida`             | Reseta a mesa e limpa a sessão atual.                    |

---

## 🃏 Regras Implementadas nesta Versão

- **Blackjack Automático:** Se o jogador receber 21 pontos nas duas primeiras cartas, a vitória é declarada instantaneamente.
- **IA do Dealer:** O Dealer segue a regra de parar obrigatoriamente ao pelo menos 17 pontos.
- **Interface Responsiva:** Design otimizado para dispositivos móveis com cartas proporcionais e botões táteis.
- **Zoneless Core:** Implementação utilizando as APIs mais modernas do Angular para detecção de mudanças sem Zone.js.

---

## ⚖️ Objetivo e Regras do Jogo

O objetivo é chegar mais próximo ou igual a **21 pontos** sem ultrapassá-lo.

### Pontuação das Cartas

| Carta       | Valor                              |
| :---------- | :--------------------------------- |
| **2 a 10**  | Valor face da carta                |
| **J, Q, K** | 10 pontos                          |
| **Ás (A)**  | 1 ou 11 (O que for mais favorável) |
