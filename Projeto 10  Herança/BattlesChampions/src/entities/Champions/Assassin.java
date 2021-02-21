package entities.Champions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.NameGenarator;

public class Assassin extends Trol {
    
    public Assassin(){
        random = new Random();
        name = new NameGenarator().generate(random.nextInt(2) + 3);
        st = random.nextInt(5) + 8;
        hp = random.nextInt(20) + 25;
    }
    public String getName(){
        return "🧝" + name;
    }
    public Player selectTarget(List<Player> list) {
        ArrayList<Player> aux = new ArrayList<>();
        for(Player player : list)
            if(player != this && player.isAlive())
                aux.add(player);
        if(aux.size() == 0)
            return null;
        Player weak = aux.get(0);
        for(Player playe : aux)
            if(playe.getHp() < weak.getHp())
                weak = playe;
        return weak;
    }
    public void attack(Player other){
        if(other != null && other.isAlive()){
            other.takeDemage(st, this);
            if(other.getHp() <= 0){
                this.st += 4;
                this.hp += 3;
            }
        }
    }
    public void takeDemage(int qtd, Player other) {
        Random random = new Random();
        int probability = random.nextInt(10);
        if(this.hp <= 10 && probability < 4)
            System.out.print("🙏🤜🤛🤘👊 Kage Bunshin no Jutsu 👥");
        else
            hp -= qtd;
    }
    public boolean ultimate(Player other){
        Random random = new Random();
        int probability = random.nextInt(10);
        if(probability < 3){
            if(other != null && other.isAlive())
            other.takeDemage(st*3, this);
            System.out.print("ULTIMATE: 💥 critical hit ");
            if(other.getHp() <= 0){
                this.st += 3;
                this.hp += 3;
            }
            return true;
        }
        return false;
    }
}
