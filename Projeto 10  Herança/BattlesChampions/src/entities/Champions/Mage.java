package entities.Champions;

import java.util.List;
import java.util.Random;

import entities.NameGenarator;

public class Mage extends Trol{
    int mn;

    public Mage(){
        random = new Random();
        name = new NameGenarator().generate(random.nextInt(5) + 3);
        st = random.nextInt(5) + 7;
        hp = random.nextInt(30) + 10;
        mn = random.nextInt(20) + 10;
    }

    public String getName(){
        return "🧙" + name;
    }
    public void attack(Player other) {
        if(other != null && other.isAlive()){
            other.takeDemage(st, this);
            if(mn > 0)
                mn -= 2;
        }
    }
    public Player selectTarget(List<Player> lista) {
        if(lista.size() == 1 && lista.get(0) == this)
            return null;
        Random random = new Random();
        while(true){
            Player chosen = lista.get(random.nextInt(lista.size()));
            if(chosen != this)
                return chosen;
        }
    }
    public void takeDemage(int qtd, Player other) {
        Random random = new Random();
        hp -= qtd;
        if(random.nextInt(2) == 1){
            mn += 4;
            System.out.print("Mage: 💫 won mana ");
        }
    }
    public boolean ultimate(Player other){
        Random random = new Random();
        int probability = random.nextInt(10);
        if(this.hp <= 20 && this.mn >= 10 && probability < 5){
            this.hp += 15;
            this.mn -= 10;
            System.out.print("ULTIMATE: 💚 healing spell");
            return true;
        }
        return false;
    }
    public String toString(){
        return getName() + ":" + st + ":" + hp + ":" + mn;
    }
}