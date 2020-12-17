# Relatorio

## O que fiz
- Desenvolvi o projeto PokemonGet onde apliquei os conceitos de agregação de classes que estudamos nas aulas destas semana.

- O proketo se baseia em um mini-game insipirado no Universo Pokemon, na qual o ususário pode carçar pokemons com uma quantidade limitada de pokebolas.

- O game tem um funções **Random** para dinamizar o jogo, caçar pokemons não é uma tarefa fácil e por isso não é facil capiturar pokemons com níveis maiores.

- Dentro da funcionalidade PokemonGet (classe do game) o usuários poderá:
    - Caçar Pokemon
    - Ver Pokedex
    - Abrir mochila
    - Comprar Pokebolas

## Com quem fez?
-Fiz so, com ajuda somente de alguns vídeos sobre as funções e também com ajuda de foruns da comunidade java.

## Como Fez?
- Eu utilizei os conceitos de agregação de classes para fazer o projeto

- O projeto está divido em 3 classes dentro de um mesmo arquivo, que são elas:
    - Classe Enum Pokemon:
        - name: nome do pokemon
        - info: infomações sobre ele
        - tipo: tipo do pokemon
        - esquiva: número da esquiva
        - investida: número da investida


        - Raiva() -> Função booleana que retorna verdeira se o pokemon na hora da capitura ficou com raiva e deu uma investida no jogar

        - toString() -> Retorna as informações do pokemon

    - Classe Pokebola:
        - pokespaco: espaço para o pokemon se guardado
        - pokebolasDisponiveis: a quantidade de pokebolas que o jogador tem
        - pokebolasMax: a quantidade Máxima que o jogador pode ter
        - capiturado: para saber se tem ou não pokemon capiturado


        - capiturar(pokemon) -> função para capiturar ou não um pokemon

        - pokekedex() -> para retornar as informação dos pokemons que vc já tem capiturado

        - mochila() -> para mostrar a quantidade de suas pokebolas disponiveis

        - comprarPokebolas() -> para comprar mais pokebolas

    - Classe PokemonGet
        Para o usuário interagir com game com **Main interativa**

## O que aprendeu?

- Aprendi tanto agregação de classes como a função **Random** que é muito utilizada em jogos

- Estão em ajudando a compreender conceitos de programação e boas práticas de programação.

## Quanto tempo levou?

- Para finalizar o projeto levei cerca de 8 horas, a parte que tive mais dificuldade foi fazer um algoritmo para encaxar as funções random para dinamizar o jogo.

## 👀 Previw
<h1 align="center">
    <img src = "https://ik.imagekit.io/3uewgm6s11/GitHub/POO/novo_jogo_9sXkbTQsF.gif">
</h1>






 

