# Relatório

## O que fiz?
- Realizei o projeto proposto da aula do dia 11/01/2021, [Sala de Cinema](https://github.com/qxcodepoo/arcade/blob/master/base/010/Readme.md) com foco em conceitos de ArraysLists. Com ajuda do professor e links de ajuda, fiz o projeto com todos os requisistos recomendados.

## Com quem fiz?
- Fiz o projeto sozinho, com instrução dos links que o professor passou para termos uma base, e com ajuda também do monitor na resolução de algumas dúvidas no discord.

## Como fiz?
- Assim como nos requisitos do projeto, segui todos os passos recomendados que se encontram no Readme do projeto [Sala de Cinema](https://github.com/qxcodepoo/arcade/blob/master/base/010/Readme.md), usando os conceitos de ``` Composição de classes ``` e também conceitos de ``` ArrayList ``` para guarda a lista de clientes, dividi o projeto em 3 classes principais que são elas:
    - ### entities
        - #### Client : Entidade cliente.
            - Atributo: ``` id ```: para guarda o nome.
            - Atributo: ``` fone ```: para guardar o telefone.

        - #### Movies : Entidade cinema.
            - Atributo: ``` Client ```: ArrayList do tipo Client para guardar todos os clientes.
            - Método: ``` reserve ```: para reservar o assento de acordo com index.
            - Método: ``` cancel ```: para cancelar a reserva e liberar o assento.

            - ``` toString ```.
    - #### Aplication : Classe da Main.
        - ``` Interativa Main ```

- Para inicializar o ArrayList com todos ```null``` eu segui a dica do professor e usei a Biblioteca do java chamada ``` Collections ```, e depois instanciei a clsse com o código ``` this.clients = new ArrayList<Client>(Collections.nCopies(size, null)) ```.

### O que eu aprendi?

- Aprendi como instaciar um ArrayList passando um valor inicial como o tamanho dele e instaciar todo com o valor ``` null ```, que pode ser feito usando a funções ``` Collections ```.

- Também prátiquei os conceitos de como mudar os elementos passando o comando set na classe ``` classe.set ```, para mudar o valor das variáveis no ArrayList.

- Compreendi melhor a como tratar possíveis erros nas funções ``` boolean ``` e ``` void ``` e também a como selecionar os objetos por index, algo muito útil.

### Quanto tempo levei?
