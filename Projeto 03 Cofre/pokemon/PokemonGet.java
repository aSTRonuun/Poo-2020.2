
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

enum Pokemon{

    P1("Pikachu", "Pikachu que pode gerar eletricidade poderosa tem sacos de bochecha que são extra macios e super elásticos.", "Eletrico", 7, 5),
    P2("Rattata", "Vai mastigar qualquer coisa com suas presas. Se voê ver um, pode ter certeza de que mais 40 vivem na área.", "Normal", 5, 3);

    String name;
    String info;
    String tipo;
    int esquiva;
    int investida;
    

    Pokemon(String name, String info, String tipo, int esquiva, int investida){
        this.name = name;
        this.info = info;
        this.tipo = tipo;
        this.esquiva = esquiva;
        this.investida = investida;
    }

    Random aleatorio = new Random();

    boolean Raiva(){
        int valor = aleatorio.nextInt(11);
        if(valor >= this.investida){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name:"
            + name + "\n"
            + "Descrição: "
            + info + "\n"
            + "Tipo: "
            + tipo + "\n"
            + "Esquiva: "
            + esquiva + "\n";

    }
}

class Pokebola{

    Pokemon pokespaco;
    int pokebolasDisponiveis;
    int pokebolasMax = 20;
    boolean capiturado = false;

    Random aleatorio = new Random();
    
    Pokebola(int pokebolasDisponiveis){
        this.pokebolasDisponiveis = pokebolasDisponiveis;

    }

    boolean capiturar(Pokemon pokemon) {

        System.out.println("Pokemon Encontrado!");
        if(pokebolasDisponiveis == 0){
            System.out.println("Não há mais pokebolas");
            return false;
        }
        int valor = aleatorio.nextInt(11);
        if(valor >= pokemon.esquiva && pokebolasDisponiveis != 0){
            System.out.println("Pokemon foi capiturado");
            this.pokespaco = pokemon;
            this.pokebolasDisponiveis -= 1;
            capiturado = true;
            return true;
        }
        if(valor <= pokemon.esquiva && pokebolasDisponiveis != 0){
            if(pokemon.Raiva())
                System.out.println("O pokemon lhe atacou");
            this.pokebolasDisponiveis -= 1;
            System.out.println("O pokemon Escapou");
            return true;
        }
        return false;
    }

    boolean pokedex() {

        if(capiturado){
            System.out.println(pokespaco);
            return true;
        }
        System.out.println("Não há pokemons capiturados");
        return false;
    }

    void mochila() {
        System.out.println("Quantidade de pokebolas: "+ pokebolasDisponiveis + "/" + pokebolasMax);
    }

    boolean comprarPokebola(int qtd){
        if(pokebolasDisponiveis == pokebolasMax){
            System.out.println("Limite de pokebolas alcançado");
            return false;
        }
        pokebolasDisponiveis += qtd;
        if(pokebolasDisponiveis > pokebolasMax)
            pokebolasDisponiveis = pokebolasMax;    
        return true;
    }
}

public class PokemonGet {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();

        Pokebola pokebola = new Pokebola(20);
        int control  = -1;

        do{
            //Limpa a tela no windows, no linux e no MacOS
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");

            System.out.println("[1] - Caçar Pokemon");
            System.out.println("[2] - Ver Pokedex");
            System.out.println("[3] - Abrir mochila");
            System.out.println("[4] - Comprar pokebolas");
            System.out.println("[0] - Sair");
            System.out.println();

            System.out.print("> ");
            control = sc.nextInt();

            switch(control){
                case 0:
                    break;
                case 1:{
                   int valor = aleatorio.nextInt(21); //Função randoom para achar um pokemon
                    if(valor < 5){
                        pokebola.capiturar(Pokemon.P1);
                        System.out.print("Pressione enter para continuar...");
                        System.in.read();
                    }else if(valor <= 10){
                        pokebola.capiturar(Pokemon.P2);
                        System.out.print("Pressione enter para continuar...");
                        System.in.read();
                    }else{ 
                        System.out.println("Nenhum pokemon foi avistado");
                        System.out.print("Pressione enter para continuar...");
                        System.in.read();
                    }
                    break;
                }case 2:{
                    pokebola.pokedex();
                    System.out.print("Pressione enter para continuar...");
                    System.in.read();
                    break;
                }case 3:{
                    pokebola.mochila();
                    System.out.print("Pressione enter para continuar...");
                    System.in.read();
                    break;
                }case 4:{
                    pokebola.mochila();
                    System.out.println("Quantas pokebolas você deseja comprar? Max:20");
                    int qtd = sc.nextInt();
                    pokebola.comprarPokebola(qtd);
                    System.out.print("Pressione enter para continuar...");
                    System.in.read();
                }
            }

        }while(control != 0);

        sc.close();
    }

}
