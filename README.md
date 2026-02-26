# SustEnergy 🚀

## 📌 Visão Geral
O **SustEnergy** é uma aplicação Java baseada em Spring Boot criada para facilitar a gestão de dados de consumo de energia em comunidades, empresas e residências. O objetivo é promover o uso eficiente de recursos, monitorar fontes renováveis e auxiliar na tomada de decisões sustentáveis.

Esta plataforma permite capturar e analisar o consumo energético de dispositivos conectados, fornecendo relatórios detalhados e sugestões para reduzir desperdícios e custos.

---

## 🧩 Funcionalidades Principais
- **Cadastro e gestão de usuários**: Suporte a diferentes perfis (administrador, consumidor, técnico).
- **Registro de consumo de energia**: Inserção e acompanhamento de medições ao longo do tempo.
- **Gerenciamento de dispositivos/entidades**: Controle de equipamentos e fontes (solar, eólica, fósseis, etc.).
- **Relatórios e análises**: Geração de dados para visualização de consumo, comparação entre períodos e sugestões de economia.

---

## 🛠 Tecnologias Utilizadas
- Java 17
- Spring Boot (MVC, Data JPA)
- H2 / banco de dados em memória (padrão de desenvolvimento)
- Maven (gerenciamento de dependências)
- Thymeleaf (templates HTML)
- JUnit 5 + Spring Test (testes unitários/repositório)

---

## 🔧 Pré-requisitos
Antes de executar o projeto localmente, certifique-se de ter instalado:
1. **Java 17** (ou superior)
2. **Maven 3.8+**
3. IDE de sua preferência (IntelliJ, Eclipse, VS Code, etc.)

---

## 🚀 Como Executar
```bash
# clonar o repositório
git clone https://github.com/KauanAltino/SustEnergy.git
cd SustEnergy

# construir o projeto
./mvnw clean package  # ou mvn clean package

# executar a aplicação
./mvnw spring-boot:run
```
A aplicação estará disponível em `http://localhost:8080`.

---

## 📁 Estrutura do Projeto
```
src/
 ├── main/java/com/mvn_project/SustEnergy    # pacotes principais
 │   ├── controller/          # REST controllers
 │   ├── model/               # entidades JPA
 │   ├── repository/          # interfaces Spring Data
 │   └── service/             # lógica de negócio
 └── resources/
     ├── application.properties
     └── templates/           # views Thymeleaf
``` 

---

## 💡 Endpoints principais
- `GET /` – página inicial
- `GET /users` – listar usuários
- `POST /energy-usages` – registrar consumo
- `GET /devices` – listar dispositivos

> Consulte os controllers para mais detalhes sobre rotas e parâmetros.

---

## ✅ Testes
O projeto inclui testes de repositório localizados em `src/test/java/com/mvn_project/SustEnergy`. Para executá-los:
```bash
./mvnw test
```

---

## 🤝 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir _issues_ ou _pull requests_ com melhorias e correções.

---

