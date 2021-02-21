package entities.Champions;

import java.util.List;
import java.util.Random;

import entities.NameGenarator;

public class Trol implements Player{
    protected String name;
    int st;
    int hp;
    Random random;
    public Trol(){
        random = new Random();
        name = new NameGenarator().generate(random.nextInt(2) + 2);
        st = random.nextInt(5) + 3;
        hp = random.nextInt(25) + 20;
    }
    public String getName() {
        return name;
    }
    public boolean isAlive() {
        return hp > 0;
    }
    public Player selectTarget(List<Player> lista) {
        Random random = new Random();
        return lista.get(random.nextInt(lista.size()));
    }
    public void attack(Player other) {
        if(other != null && other.isAlive())
            other.takeDemage(st, this);
    }
    public int getHp(){
        return hp;
    }
    public void takeDemage(int qtd, Player other) {
        hp -= qtd;
    }
    public boolean ultimate(Player other){
        Random random = new Random();
        int probability = random.nextInt(10);
        if(this.hp <= 15 && probability <5){ 
            if(other != null && other.isAlive())
            other.takeDemage(st*2, this);
            System.out.print("ULTIMATE: 🗡 double attack");
        }
        return false;
    }
    public String toString() {
        return  getName() + ":" + st + ":" + hp;
    }

}
