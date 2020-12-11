
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

enum Pokemon{

    P1("Pikachu", "Pikachu que pode gerar eletricidade poderosa tem sacos de bochecha que são extra macios e super elásticos.", "Eletrico", 7, 5);

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

    boolean Capiturar(Pokemon pokemon) throws IOException {

        System.out.println("Pokemon Encontrado!");
        if(pokebolasDisponiveis == 0){
            System.out.println("Não há mais pokebolas");
            System.in.read();
            return false;
        }
        int valor = aleatorio.nextInt(11);
        if(valor >= pokemon.esquiva && pokebolasDisponiveis != 0){
            System.out.println("Pokemon foi capiturado");
            this.pokespaco = pokemon;
            this.pokebolasDisponiveis -= 1;
            capiturado = true;
            System.in.read();
            return true;
        }
        if(valor <= pokemon.esquiva && pokebolasDisponiveis != 0){
            if(pokemon.Raiva())
                System.out.println("O pokemon lhe atacou");
            System.out.println("O pokemon Escapou");
            this.pokebolasDisponiveis -= 1;
            System.in.read();
            return true;
        }
        return false;
    }

    boolean pokedex() throws IOException {

        if(capiturado){
            System.out.println("Name: " + pokespaco.name);
            System.out.println("Tipo: " + pokespaco.tipo);
            System.out.println("Descrição: " + pokespaco.info);
            System.in.read();
            return true;
        }
        System.out.println("Não há pokemons capiturados");
        System.in.read();
        return false;
    }

    void mochila() throws IOException {
        System.out.println("Quantidade de pokebolas: "+ pokebolasDisponiveis + "/" + pokebolasMax);
        System.in.read();
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
            System.out.println("[0] - Sair");
            System.out.println();

            System.out.print("> ");
            control = sc.nextInt();

            switch(control){
                case 0:
                    break;
                case 1:{
                   int valor = aleatorio.nextInt(11);
                    if(valor <= 5){
                        pokebola.Capiturar(Pokemon.P1);
                    }else{ 
                        System.out.println("Nenhum pokemon foi avistado");
                        System.in.read();
                    }
                    break;
                }case 2:{
                    pokebola.pokedex();
                    break;
                }case 3:{
                    pokebola.mochila();
                }
            }

        }while(control != 0);

        sc.close();
    }

}
