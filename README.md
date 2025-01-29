# 🌍 **Projeto: Monitoramento de Terremotos com Java e Mapa Interativo**

**Descrição**: Este projeto tem como objetivo monitorar e visualizar dados de terremotos em tempo real, utilizando a API pública da USGS (United States Geological Survey). A aplicação é desenvolvida em **Java** e gera um **mapa interativo** para visualização dos eventos sísmicos.

---

## 🚀 **Funcionalidades**

- **Consulta em Tempo Real**: Obtém dados de terremotos ocorridos no último mês a partir da API da USGS.
- **Filtragem por País**: Permite ao usuário filtrar os terremotos por local, fornecendo uma busca mais direcionada.
- **Mapa Interativo**: Gera um mapa interativo utilizando a biblioteca **Leaflet.js** para exibir a localização e magnitude dos terremotos.
- **Exibição Simples**: Exibe os dados dos terremotos no console, incluindo **local**, **magnitude** e **data**.

---

## 🔧 **Tecnologias Utilizadas**

- **Java**: Linguagem de programação principal para o desenvolvimento da aplicação.
- **API RESTful**: Utilizada para consumir os dados em tempo real da **USGS**.
- **Leaflet.js**: Biblioteca JavaScript para criar o mapa interativo.
- **JSON**: Formato de dados utilizado para comunicação com a API da USGS.

---

## 📜 **Como Funciona**

1. A aplicação faz uma requisição **HTTP GET** para a API da USGS, que retorna um JSON com os dados dos terremotos ocorridos no último mês.
2. O usuário pode filtrar os dados por país. Caso o campo de filtro esteja vazio, serão retornados todos os terremotos.
3. A aplicação exibe os dados no console e gera um arquivo HTML com um mapa interativo, utilizando a biblioteca **Leaflet.js** para visualizar os terremotos com marcadores no mapa.

---

## 🛠️ **Instalação**

Para rodar este projeto em sua máquina, siga os passos abaixo:

### Pré-requisitos

- **Java 11 ou superior** instalado.
- **IDE** (como **IntelliJ IDEA** ou **Eclipse**) ou terminal para compilar e rodar o código.

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/terremotos.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd monitoramento-terremotos
   ```

3. Compile e execute o projeto:

   Se estiver utilizando uma IDE, basta rodar a classe `Principal.java`.

   Caso utilize o terminal, compile e execute com os seguintes comandos:

   ```bash
   javac -d bin src/br/com/terremoto/*.java
   java -cp bin br.com.terremoto.Principal
   ```

4. Ao rodar o projeto, ele pedirá para você digitar o nome de um país para filtrar os terremotos ou deixar em branco para consultar todos os eventos.

5. Após a execução, será gerado um arquivo `mapa_terremotos.html`, que pode ser aberto em qualquer navegador para visualizar o mapa interativo.

---

## 📊 **Exemplo de Saída**

### Console:
```plaintext
Digite o nome do país para filtrar os terremotos:
Brasil
Foram encontrados 10 terremotos.

Local: Peru, Magnitude: 4.5, Data: Thu, 28 Jan 2025 13:30:00 GMT
Local: Chile, Magnitude: 5.2, Data: Thu, 28 Jan 2025 14:00:00 GMT
...
```

### Mapa Interativo:
O mapa HTML gerado exibirá um marcador para cada terremoto encontrado, com informações sobre o **local** e **magnitude** do evento sísmico.

---

## 📂 **Estrutura do Projeto**

```plaintext
├── src/
│   ├── br/
│   │   ├── com/
│   │   │   ├── terremoto/
│   │   │   │   ├── controller/
│   │   │   │   ├── model/
│   │   │   │   ├── view/
│   │   │   │   ├── Principal.java
├── mapa_terremotos.html
└── README.md
```

---

## ⚙️ **Como Contribuir**

Se você quiser contribuir para este projeto, fique à vontade para criar **pull requests**! Aqui estão algumas maneiras de contribuir:

1. **Relatar erros**: Se encontrar algum bug, crie uma issue detalhando o problema.
2. **Adicionar melhorias**: Se tiver ideias para novas funcionalidades ou melhorias, faça um fork do projeto e envie uma pull request.
3. **Testes e Documentação**: Ajude a melhorar a cobertura de testes ou a documentação deste projeto.

---

## 📬 **Contato**

Se tiver dúvidas, sugestões ou quiser compartilhar seu feedback sobre o projeto, entre em contato comigo via **LinkedIn**: [Magno Santos](https://www.linkedin.com/in/magnosantos)

---

## 📃 **Licença**

Este projeto está licenciado sob a **MIT License**. Veja o arquivo LICENSE para mais detalhes.
