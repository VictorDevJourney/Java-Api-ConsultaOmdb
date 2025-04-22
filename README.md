# ConsultaOmdb

Um sistema simples em Java que permite buscar informações sobre filmes utilizando a API OMDb (Open Movie Database). O usuário pode inserir o título de um filme e obter detalhes como título, ano, duração, gênero, diretor e sinopse.

## Conceitos Abordados:

- **Requisições HTTP**: Utilização da biblioteca `HttpClient` para fazer requisições à API.
- **Manipulação de JSON**: Uso da biblioteca `Gson` para deserializar a resposta JSON da API.
- **Listas**: Armazenamento de objetos `Titulo` em uma lista para gerenciar os filmes buscados.
- **Tratamento de Exceções**: Implementação de tratamento de erros para garantir a robustez do sistema.
- **Interação com o Usuário**: Interface de linha de comando para entrada e saída de dados.
