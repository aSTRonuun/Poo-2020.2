# Relatório

## O que fiz?
- Realizei o projeto [Agenda 02](https://github.com/qxcodepoo/arcade/blob/master/base/015/Readme.md), na qual foi o projeto proposto para a semana, com ênfase em adição, remoção, ordenação e busca em um ```ArrayList```.

## Com quem fiz?
- Fiz o projeto sozinho, com ajuda dos projetos exemplos realizados em sala e de vídeos complementares.

## Como fiz?
- Realizei o projeto com base nos requisitos recomendados para o projeto, aonde pode se observar clicando no link do projeto: [Agenda 02](https://github.com/qxcodepoo/arcade/blob/master/base/015/Readme.md), com base nos requisitos desenvolvi 4 classes, onde 3 são entidades do projeto e mais uma para guardar a  ```interative main```.
    - ### entities
        - #### Phone - entidade Phone
            - _Atributos_<br/>
                -```id```: id do contato<br/>
                -```number```: número do contato<br/>
            - _Métodos_<br/>
                +```validate```: validação de números<br/>
                +```toString```<br/>
        - #### Contact - entidade contatos
            - _Atributos_<br/>
                -```name```: nome do contato <br/>
                -```phones```: lista de fones <br/>
            - _Métodos_<br/>
                +```addPhone```: adicionar fone<br/>
                +```rmvPhone```: remover fones<br/>
                +```getNamePhone```: obter nomes<br/>
                +```getPhones```: obter fones<br/>
                +```compareTo```: comparar nos para ordenação<br/>
                +```toString```:<br/>
        - #### Schedule - entidade Agenda
            - _Atributos_<br/>
                -```contacts```: lista de contatos <br/>
            - _Métodos_<br/>
                +```addContact```: adicionar contato <br/>
                +```rmContact```: remover contato <br/>
                +```addPhone```: adicionar fone p/ contato existente <br/>
                +```rmPhone```: remover fone de um contato existente <br/>
                +```search```: buscar po um padrão <br/>
    - ### aplication
        - ```interative main```
- No método ```search``` fiz com as funções ```pattern``` e ```matcher```, para retornar contatos que estavam dentro de um padrão contido na string buscada pelo usuário, o que deixou a busca muito performática.

## O que eu aprendi?
- Exercitei o que venho aprendendo dos projetos anteriores, como manipular uma lista de dados no ```ArrayList```.

- Aprendi a usar a função ```Collection.sort``` e adicionar a função ```compareTo```, para serem usadas juntas e fazer a ordenação no ArrayList.

- Conheci mais sobre **RegEx** - Expressões Regulares para buscar padrões nos dados e retornar esse padrões com base no parâmentros passados, aprendi a usar a função ```pattern``` e ```matcher```, contidos nas bibliotecas regex do java para usar no projeto.

## Quanto tempo levei?
- Ao todo deu por valta de 6 horas para completar todo o projeto, acabei levando mais tempo porque decidi estudar sobre as **RegEx** para introduzilas nos coódigos, também tive um pouco de dificuldade para passar os parâmetros dos ArrayList de Phones, mais sem grandes dificuldades consegui achar uma solução viável para o problema. 
                
        