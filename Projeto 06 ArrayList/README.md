# Relatório

## O que fiz?
- Realizei dois projetos proposto da semana [Pula pula no parquinho](https://github.com/qxcodepoo/arcade/blob/master/base/009/Readme.md) e [Tarifas - Agência 1](https://github.com/qxcodepoo/arcade/blob/master/base/007/Readme.md), no projeto pula pula eu fiz apartir do código visto em sala, na qual adicionei funções novas complementares. Ademais fiz o projeto Tarifas com base nos conhecimentos adquiridos nas aulas da semana, com o tema ArrayList.

## Com quem fiz?

- Fiz o projeto sozinho, com ajuda das aulas e dos códigos exemplos, pesquisei algumas partes do algoritmo em sites e fóruns de dùvidas da comunidade.

## Como fez?

### Pula pula no Parquinho
- Assim como na aulas, o projeto está utilizando conceitos de composição de classes para guardar um objeto dentro de outros, diante disso podemos dividir o projeto em duas classes na a primeira classe chamada ` Kid ` irá ter somente atributos como ` name ` e ` age ` e na classe ` Pula Pula ` temos métodos os métodos:
    - ` in ` : entrar no trampulim
    - ` out `: sair do trampulim
    - ` arrive `: entrar na fila de espera
    - ` removeKid `: para quando o responsável da criança chegar

- Eu adicionei dois atributos na classe PulaPula são eles  ` limit ` para adicionar uma capacidade máxima de crianças e também ` cashbox ` para guardando o montante total das crianças que pagavam para subir no pula pula.

- Ademais, adicionei um método também na classe PulaPula que é ` removeKid ` para que quando o pai da criança chegar, a criança possa sair ou do pula pula ou da fila. 

### Tarifas
- No projeto tarifas eu programei conforme os requisitos, envolvendo 3 classes que são elas:
    - ` AccountBanck `
    - ` Operation `
    - ` Aplication `

- Na na classe ` AccountBank ` temos todos os requisitos descritos abaixos:
    - ` deposit ` : deposita o dinheiro
    - ` toWithdran ` : sacar o dinheiro
    - ` tariff ` : passar uma tarifa
    - ` reversal ` : extornar uma tarifa
    - ` getExtract ` : para mostrar todo extrato
    - ` getExtractN ` : para mostrar apenas os últimos dados do extrato
    - ` toString `

- Na classe ` Operation ` fica guardado os dados do extrato, que é guardada dentro da classe ` AccountBanck `, diante disso forma-se a composição com objetos adicionando o ArryList.

- Na classe ` Aplication ` é onde se encontra a ` main interativa `.

### O que aprendeu?

- Compreendi bastante coisas sobre o **ArrayList**, principalmente para adicionar os dados, bem como pecorrer os Arrays com a função ` for each ` que me ajudou muito para mostrar os valores, consegui também praticar muito com os métodos, tive um pouco de dificuldade para entender e tive vários problemas para excutar, porém, com bastante atenção consegui ver os erros e achar as soluções adequadas.

- Prátiquei e apefeiçoei minhas técnicas de programação para manipular vetores de dados e a interação com eles.

- Aprendi a executar tarefas usando funções como ` Array.lenth ` e ` Arry.IndexOf `.

### Quanto tempo levou?

- No projeto [Pula pula no parquinho](https://github.com/qxcodepoo/arcade/blob/master/base/009/Readme.md) levou umas duas horas pra refazer e adicionar as funções novas.

- No projeto [Tarifas - Agência 1](https://github.com/qxcodepoo/arcade/blob/master/base/007/Readme.md), me tomou bem mais tempo pois fiquei com algumas dúvias e optei por ficar pesquisando, estudando por outros códigos e dúvidas nos fóruns da comunidade. Portanto, creio que levei umas 7 horas para completudar tudo.