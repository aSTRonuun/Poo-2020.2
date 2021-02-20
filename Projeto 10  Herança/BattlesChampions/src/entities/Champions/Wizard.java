package entities.Champions;

import java.util.Random;

public class Wizard extends Mage {

    public String getName(){
        return "🧞" + name;
    }
    public void takeDemage(int qtd, Player other) {
        Random random = new Random();
        int probability = random.nextInt(10);
        if(this.mn >= 10 && probability < 5){
            other.takeDemage(qtd, this);
            System.out.print("Expelliarmus 🌀");
        }else
            hp -= qtd;
        if(random.nextInt(2) == 1){
            mn += 2;
            System.out.print("Wizard: 💫 won mana ");
        }
    }   
    public boolean ultimate(Player other){
        Random random = new Random();
        int probability = random.nextInt(10);
        if(this.hp <= 20 && probability < 5){
            this.mn += 5;
            System.out.print("ULTIMATE: 💫  Recover mana");
            return true;
        }
        return false;
    }
}
