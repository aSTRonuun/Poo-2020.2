package entities.Champions;

import java.util.List;
import java.util.Random;

import entities.NameGenarator;

public class Warraior extends Trol{
    int armor;
    
    public Warraior(){
        random = new Random();
        name = new NameGenarator().generate(random.nextInt(3) + 4);
        st = random.nextInt(5) + 6;
        hp = random.nextInt(20) + 40;
        armor = random.nextInt(10) + 5;
    }
    public String getName() {
        return "💂" + name;
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
        if (armor >= 5 && hp <= 5){ 
            hp -= (qtd/5);
            armor -= 5;
            System.out.print("⚜️ Activated protective shield ");
            return;
        }if(armor >= 2){
            hp = hp - (qtd / 2);
            armor -= 2;
            System.out.print("⚜️ Shield ");
            return;
        }
        hp -= qtd;
        System.out.print("💢 Broken shield ");
        return;
    }
    public boolean ultimate(Player other){
        Random random = new Random();
        int probability = random.nextInt(10);;
        if(armor < 5 && probability <3){ 
            armor += 5;
            System.out.print("ULTIMATE: 🔨 Rapair shield ");
        }
        return false;
    }
    public String toString(){
        return getName() + ":" + st + ":" + hp + ":" + armor;
    }
}
