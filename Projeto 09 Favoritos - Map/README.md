# Relatório

### O que fiz?
- Realizei o projeto [Favoritos - Agenda 03](https://github.com/qxcodepoo/arcade/blob/master/base/016/Readme.md), projeto proposto para a semana, com enfâse em estrutura de dado e manipulção de dados.

### Com que fiz?
- Fiz o projeto sozinho, com base do projeto [Agenda 02](https://github.com/qxcodepoo/arcade/blob/master/base/015/Readme.md) e dos projetos exemplos vistos em aula, de vídeos complementares e suporte de fóruns da comunidade.

### Como fiz?
- Realizei o projeto com base nos requisitos recomendados, para saber mais clique no link do projeto [Favoritos - Agenda 03](https://github.com/qxcodepoo/arcade/blob/master/base/016/Readme.md), assim como no projeto anterior desenvolvi 4 classes, onde 3 são de entidades do projeto e mais uma para guardar a ```interative main```.
    - ### entities
        - #### Phone - entidade Phone
            - _Atributos_<br/>
                -```id```: id do contato<br/>
                -```number```: número do contato<br/>
            - _Métodos_<br/>
                +```validate```: validação de números<br/>
                +```toString```<br/>
        - #### Contact - entidade Contatos
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
        - #### PhoneBook - entidade Agenda
            - _Atributos_<br/> 
                -```contacts```: linda de contatos **TreeMapa**<br/>
                -```bookmarks```: linda de favoritos **TreeMapa**<br/>
            - _Métodos_<br/>
                +```addContact```: adicionar contato<br/>
                +```rmContact```: remover contato<br/>
                +```bookMark```: marcar um contato como favorito<br/>
                +```unBookMark```: desmarcar contato como favorito<br/>
                +```getBookMarks```: retornar somente os favoritos<br/>
                +```search```: procurar por palavra chave<br/>
                +```toString```:<br/>
    - ### aplication
        - ```interative main```
- A atualização do projeto [Agenda 02](https://github.com/qxcodepoo/arcade/blob/master/base/015/Readme.md) para o projeto [Favoritos - Agenda 03](https://github.com/qxcodepoo/arcade/blob/master/base/016/Readme.md), consistiu em uma mudança para melhor o desempenho do programa, assim como na simplificação de sua sintaxe, nos atributos da classe PhoneBook, trocamos o ArrayList para o TreeMap, uma estrutura de dados nativa do Java que suporta uma lista de elementos com chave de acesso única e ordena esse elementos por meio da sua chave, o que facilita a busca de dados.

### O que eu aprendi?
- Exercitei o que venho aprendendo dos projetos anteriores, como manipular elementos em lista, melhorar a lógica e aprender as funcionalidades do Java.

- Exercitei a como achar **Regex** - expressões regurales - para dinamizar o processo de busca por padrões passando as funções ```pattern``` e ```matcher``.

- Aprendi a como usar o **TreeMap** para listar, ordernar e buscar elementos.

- Na ```interative main```, apliquei os conceitos de **Exessão** abordado pelo professor nas aulas da semana, que consiste em colocar comando de ```Exception``` nas funções e se algo de errado, capturar esse erros na main com ```try cat```, para tratar esse erros e comunicar ao usuário.

### Quanto tempo levei?
- Ao todo levei uma 7 horas para completar o projeto, tive um pouco de dificuldade para botar em prática a parte do **TreeMap**, precisei assistir as aulas o que demandou mais tempo para completar, porém, consegui compreender o processo e as funções e botar em prática.





