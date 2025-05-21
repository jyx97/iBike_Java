# iBike Backend


**Backend da plataforma iBike — monitoramento inteligente de pátios de motos**

---

## 🛠️ Sobre o Projeto

O **iBike Backend** é a API responsável pela gestão da plataforma iBike, que monitora pátios de motocicletas conectando dados de motos, funcionários (administradores), pátios e eventos de monitoramento.

A plataforma facilita o controle do status das motos e da ocupação dos pátios, com eventos detalhados de entrada e saída. Os dados de monitoramento são simulados via integração com o MockAPI da Mottu, replicando dados externos reais.

---

## 🎯 Funcionalidades

* **Gerenciamento de Administradores**
  Funcionários que gerenciam os pátios, com autenticação e autorização para acesso e modificação apenas dos seus próprios dados.

* **Controle de Motos**
  Cadastro, atualização e visualização das motos, filtrando por status e local de pátio.

* **Gestão de Pátios**
  Monitoramento da capacidade e status (disponível, cheio, sobrecarregado) dos pátios.

* **Eventos de Monitoramento**
  Registro dos eventos de entrada e saída das motos, permitindo rastreamento do fluxo.

* **Segurança JWT**
  Acesso seguro usando tokens JWT para autenticação e controle de permissão.

* **Cache para Performance**
  Cache de dados frequentes para otimizar consultas.

---

## 📁 Estrutura do Projeto

```
src/
└── main/
    ├── java/br/com/fiap/ibike/
    │   ├── config/           # Configurações gerais e Swagger
    │   ├── controller/       # REST Controllers
    │   ├── model/            # Entidades JPA, enums
    │   ├── repository/       # Spring Data JPA Repositories
    │   ├── security/         # Configurações de segurança e JWT
    │   └── service/          # Serviços e regras de negócio
    └── resources/
        ├── application.properties # Configurações do projeto
        └── data.sql                # Dados iniciais para banco em memória
```

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia            | Finalidade                                   |
| --------------------- | -------------------------------------------- |
| Java 17               | Linguagem principal                          |
| Spring Boot           | Framework para API REST                      |
| Spring Data JPA       | Acesso ao banco com JPA                      |
| Spring Security (JWT) | Autenticação e autorização                   |
| H2 Database           | Banco em memória para desenvolvimento        |
| Lombok                | Redução de código boilerplate                |
| Swagger/OpenAPI       | Documentação interativa da API               |
| MockAPI (Mottu)       | Simulação de dados externos de monitoramento |

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

* Java 17 instalado
* Maven instalado (ou wrapper Maven incluso)
* (Opcional) Docker para rodar banco externo

### Rodando localmente com Maven

1. Clone o repositório:

```bash
git clone https://github.com/jyx97/iBike_Java.git
cd ibike-backend
```

2. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

3. Acesse a API em:

```
http://localhost:8080
```

4. Para acessar a documentação Swagger (UI interativa):

```
http://localhost:8080/swagger-ui.html
```

---

### Gerar e executar .jar

1. Compile e empacote:

```bash
./mvnw clean package
```

2. Execute o arquivo jar gerado:

```bash
java -jar target/ibike-backend-0.0.1-SNAPSHOT.jar
```

---

### Rodar com Docker

1. Crie o Dockerfile (se ainda não tiver):

```dockerfile
FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/ibike-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

2. Build da imagem:

```bash
docker build -t ibike-backend .
```

3. Execute o container:

```bash
docker run -p 8080:8080 ibike-backend
```

---

## 🛠️ Configurações importantes

No arquivo `src/main/resources/application.properties`, configure:

```properties
# Porta do servidor
server.port=8080

# Configurações de JWT (secret, tempo expiração, etc)
jwt.secret=yourSecretKeyHere
jwt.expirationMs=3600000

# H2 Console (para debug e testes)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## 📋 Exemplos de Endpoints

| Método | Endpoint              | Descrição                                  |
| ------ | --------------------- | ------------------------------------------ |
| POST   | `/administrador`      | Cadastro de administrador                  |
| PUT    | `/administrador/{id}` | Atualizar dados do administrador (próprio) |
| DELETE | `/administrador/{id}` | Deletar conta do administrador (próprio)   |
| GET    | `/patio`              | Listar todos os pátios                     |
| POST   | `/patio`              | Criar novo pátio                           |
| GET    | `/patio/{id}`         | Buscar pátio por ID                        |
| GET    | `/moto`               | Listar motos com filtros                   |
| GET    | `/monitoramento`      | Listar eventos de monitoramento            |

---

## 🔒 Segurança

* **JWT** para autenticação.
* Usuários só podem acessar e alterar seus próprios dados.
* Spring Security protege todos endpoints sensíveis.
* Configuração de roles e permissões.

---

## 📈 Melhorias Futuras

* Integração com banco PostgreSQL ou outro banco relacional real.
* Dashboard web para visualização em tempo real.
* Alertas e notificações automáticas para eventos críticos.
* API pública para acesso externo controlado.
* Implementação de testes automatizados (unitários e integração).

---

## 🤝 Integrantes
Gabriel Dias Menezes RM555019
Júlia Soares Farias dos Santos RM554609

---
