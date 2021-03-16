# Relatório

### O que fiz
- Realizei o projeto [Cadrastro - Agência 2](https://github.com/aSTRonuun/arcade/blob/master/base/013/Readme.md), projeto proposto da semana 12, com foco em **Herança** e outros conceitos já estudos como estrutura de dados em listas, agregação e composição entre classes.

### Com quem fiz?
- Fiz o projeto sozinho, com base em projetos anteriores e nas aulas passadas pelo professor.

### Como fiz?
- Realizei o projeto com base em todos os requisitos recomendados e seguindo também o diagrama UML do projeto com algumas modificações para completar ainda mais o projeto, para saber mais clique e leia o readme do projeto [Cadrastro - Agência 2](https://github.com/aSTRonuun/arcade/blob/master/base/013/Readme.md).
- O projeto tem como base, melhorar o desenvolvimento do programa por meio de **Herança**, na qual temos uma classe principal geral de contas que eu denominei de ```AccountBank``` e em seguida temos especificações dessa contas que são geradas a partir de **Herança**, que são as classe filhas ```CheckingAccount``` e ```SanvigsAccount```, conta corrente e conta poupança respectivamente. Diante disso, desenvolvi o projeto em 1 classe de controller, 4 classes de modelos e uma so para a main, que por sua vez são organizadas do seguinte modo.
    - #### controller
        - ```Agency``` - classe do sistema para controlar os clientes, contas e as movimentações.
    - ### models
        - ```Client``` - classe do client para guardar seu id e suas contas.
        - ```AccountBank``` - classe com todas as funcionalidades gerais das contas.
        - ```CheckingAccount``` - sub-classe específica de conta corrente.
        - ```SavingsAccount``` - sub-classe específica para conta poupança.
    - ### test
        - ```test``` - testes do projeto, sem a main interativa.
    - ### app
        - ```App``` - classe da main interativa.

- Uma modificação importante aqui foi que eu decidir usar TreeMap em vez de usar ArrayList na classe ```Agency``` para guardar tantos as listas de clientes como as listas de contas, foi criado também uma variável do tipo *int* para controlar os id's das contas, a medida que elas forem sendo cadastradas no sistema para servir como *key's* no TreeMap. 

- Nesse projeto trabalhei bastante com exceções, para tratar todos os erros possíveis que um usuário possa ter, pois, se trata de um sistema crítico e as validações precisam ser precisas.

### O que eu aprendi?
- Exercitei o que venho aprendendo dos projetos anteriores, como manipular elementos em lista, melhorar a lógica e aprender as funcionalidades e sintaxe do Java.

- Exercitei bastante exceções com ajuda do TreeMap, que fica bem mais fácil trabalhar com dados para orderna, procurar e buscar.

### Quanto tempo levei?
- Como eu já venho exercitanto e ficando cada vez melhor e com mais segurança não demorei muito, apenas tive que pensar como eu podia fazer para melhorar o projeto adicionando as funcionalidades de TreeMap, a parte da criação das classes filhas com herança foi bem tranquila. Com isso, acho que demorei por volta de umas 6 horas para completar todo o código.