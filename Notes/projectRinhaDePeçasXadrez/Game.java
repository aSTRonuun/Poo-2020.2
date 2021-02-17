import java.util.*;
interface Jogador{
    String getName();
    boolean isAlive();
    int getHp();
    Jogador selectTarget(List<Jogador> lista);
    void attack(Jogador other);
    void takeDemage(int qtd, Jogador other);
}

class Peon implements Jogador{
    protected String name;
    int st;
    int hp;
    
    public Peon(){
        String vogais = "aeiou";
        String consoantes = "BCDFGHJKLMNPQRSTVXYZ";
        Random random = new Random();
        name = "" + consoantes.charAt(random.nextInt(consoantes.length())) + 
                    vogais.charAt(random.nextInt(vogais.length())) +
                    vogais.charAt(random.nextInt(vogais.length()));
        st = random.nextInt(5) + 5;
        hp = random.nextInt(30) + 20;
    }
    public String getName() {
        return name;
    }
    public boolean isAlive() {
        return hp > 0;
    }
    public Jogador selectTarget(List<Jogador> lista) {
        Random random = new Random();
        return lista.get(random.nextInt(lista.size()));
    }
    public void attack(Jogador other) {
        if(other != null && other.isAlive())
            other.takeDemage(st, this);
    }
    public int getHp(){
        return hp;
    }
    public void takeDemage(int qtd, Jogador other) {
        hp -= qtd;
    }
    public String toString() {
        return  getName() + ":" + st + ":" + hp;
    }
}

class Horse extends Peon{
    public String getName(){
        return "♞ " + super.getName();
    }

    public Jogador selectTarget(List<Jogador> lista) {
        if(lista.size() == 1 && lista.get(0) == this)
            return null;
        Random random = new Random();
        while(true){
            Jogador chosen = lista.get(random.nextInt(lista.size()));
            if(chosen != this)
                return chosen;
        }
    }
    public void takeDemage(int qtd, Jogador other) {
        hp -= qtd;
        if(other != null)
            other.takeDemage(st, null);
    }
    public String toString(){
        return super.toString();
    }
}

class Tower extends Horse{
    public String getName(){
        return "♜ " + name;
    }
    public void takeDemage(int qtd, Jogador other) {
        if(hp < 5)
            hp -= qtd/5;
        else
            hp -= qtd / 2;
    }
}

class Bishop extends Peon{
    public String getName(){
        return "♝ " + name;
    }
    public Jogador selectTarget(List<Jogador> lista) {
        ArrayList<Jogador> aux = new ArrayList<>();
        for(Jogador player : lista)
            if(player != this && player.isAlive())
                aux.add(player);
        if(aux.size() == 0)
            return null;
        Jogador weak = lista.get(0);
        for(Jogador play : aux)
            if(play.getHp() < weak.getHp())
                weak = play;
        return weak;
    }
    public void attack(Jogador other){
        if(other != null && other.isAlive()){
            other.takeDemage(st, this);
            if(other.getHp() <= 0 ){
                this.st += 5;
            }
        }
    }
}

class Quenn extends Bishop{
    public String getName(){
        return "♚ " + name;
    }
    public void attack(Jogador other){
        if(other != null && other.isAlive()){
            other.takeDemage(st, this);
            if(other.getHp() <= 0 ){
                this.hp += 7;
            }
        }
    }
}

public class Game{

    List<Jogador> players;
    Scanner sc = new Scanner(System.in);

    public Game(){
        this.players = new ArrayList<>();
        for(int i=0;i<6;i++)
            players.add(new Peon());
        players.add(new Horse());
        players.add(new Tower());
        players.add(new Bishop());
        players.add(new Quenn());
        Collections.shuffle(players);
    }
    public void showPlayers(){
        for(Jogador player : players)
                System.out.print(player + " ");
            System.out.println("");
    }
    public void roundFight(){
        for(Jogador player : players){
            if(!player.isAlive())
                continue;
            Jogador target = player.selectTarget(this.players);
            player.attack(target);
            System.out.println(player + " ⚔️  " + target);
        }
    }
    public void rmvDeadBodies(){
        List<Jogador> aux = new ArrayList<Jogador>();
        for(Jogador player : players)
            if(player.isAlive())
                aux.add(player);
        players = aux;
    }
    public void play(){
        showPlayers();   
        while(players.size() > 1){
            System.out.print("Ready for battle?: (y/n) ");
            sc.next();
            System.out.println("FIGHT");
            roundFight();
            showPlayers();
            rmvDeadBodies();
        }
        sc.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play(); 
    }
}