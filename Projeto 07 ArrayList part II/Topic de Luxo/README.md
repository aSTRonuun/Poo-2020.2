# Relatório

## O que fiz?
- Realizei o projeto proposto para está semana, [Topic de Luxo](https://github.com/aSTRonuun/arcade/blob/master/base/012/Readme.md) com enfase ainda em manipulação de ArraysLists. Com base do projeto [Sala de Cinema](https://github.com/qxcodepoo/arcade/blob/master/base/010/Readme.md) desenvolvi esse aplicando alguns conceitos semelhantes.

## Com que fiz?
- Fiz o projeto sozinho, com ajuda dos links que o professor disponibilizou para termos uma vase, e também com ajuda do projeto anterior [Sala de Cinema](https://github.com/qxcodepoo/arcade/blob/master/base/010/Readme.md).

## Como fiz?
- Assim como no projeto anterior, segui todos os requisitos recomendados do projeto que se encontram no Readme do projeto, para conferir clique no link [Topic de Luxo](https://github.com/aSTRonuun/arcade/blob/master/base/012/Readme.md), usando novamente os conceitos de ``` Composição de classes ``` e também conceitos de ``` ArrayList ``` para guardar a lista dos passageiros da topic, dividi o projeto em 3 classes principais que são elas:
    - #### entities
        - ### Pass - Entidade passageiros
            - _Atributos_
                - -``` name ```: nome
                - -``` age ```: idade
            - _Métodos_
                - +```toString```
        - ### Topic - Entidade Topic
            - _Atributos_
                - -```seats```: ArrayList para guardar os passageiros.
                - -```maxPrefSeats```: para guardar o tamanhos de assentos preferenciais.
                - -```ocpPreSeats```: contador dos assentos preferenciais.
                - -```maxNormalSeats```: para guardar o tamanho. máximos de assentos normais.
                - -```opcNormalSeats```: contador dos assentos normais
            
            - _Métodos_
                - +```Topic```: contrutor de topic
                - +```toBoard```: função para embarcar na topic
                - +```land```: função para desembarcar na topic
                - +```toString``` 

    - ### Aplication - Entidade Main
        - ```Interative Main```

- No método topic fiz uma lógica para inicialmente da preferencias ao idosos, colocando as pessoas com mais de 60 anos nos assentos preferenciais, para isso o algoritmo conta com um cálculo baseado no total de bancos normais vagos, ocupados e no total de bancos preferenciais vagos, ocupados para testar se os bancos estão sendo usados ou não, depois de testar ele escolhe qual o melhor assento para o passageiro, e isso tudo usando apenas um  ```ArrayList``` dando mais performance para o programa.

- Para inicializar o ArrayList com todos **nul** eu utilizei o mesmo recurso do projeto passado, chamando a função ```Collections``` e depois instanciei o arraylist com o código ``` this.clients = new ArrayList<Client>(Collections.nCopies(size, null)) ```.

## O que eu aprendi?

- Exercitei o que eu já tinha aprendido no projeto anterior, instaciar um ArrayList passando um valor inicial como o tamnho dele e instaciar todos os valores com o valor ```null```, que pode ser feito usando a funções ```Collections```.

- Pratiquei também a lógica para posicionar elementos em uma lista usando contadores para realizar calculos a medida com que os elementos são inseridos.

- Exercitei e compreendi melhor como fazer um ```toString``` com comandos de desição, para retornar uma String personalizada de acordo com os elementos de um ArrayList

## Quanto tempo levei?

- Levei por volta de 5 horas para fazer o código, como tomei como base o projeto anterior não sentir quase nenhuma dificuldade, só demorei mais na parte de fazer a função ```toBoard: embarcar```, pois, precisei desenvolver um algoritmo funcional complexo para fazer a alocação dos elementos no ArrayList, foi a parte que mais demorei.

