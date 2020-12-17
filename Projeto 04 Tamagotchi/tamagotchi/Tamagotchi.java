import java.util.Scanner;

class Pet {

    private int energyMax, hungryMax, cleanMax;
    private int energy, clean, hungry;
    private int diamonds;
    private int age;
    private boolean alive;

    public Pet(int energyMax, int hungryMax, int cleanMax){
        this.energyMax = energyMax;
        this.hungryMax = hungryMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.hungry = hungryMax;
        this.clean = cleanMax;
        this.diamonds = 0;
        this.age = 0;
        this.alive = true;
    }

    private void setEnergy(int value){
        energy = value;
        if(energy <= 0){
            energy = 0;
            System.out.println("Seu pet morreu de fraqueza");
            alive = false;
        }
        if(energy > energyMax)
            energy = energyMax;
    }

    private void setClean(int value){
        clean = value;
        if(clean <= 0){
            clean = 0;
            System.out.println("Seu pet morreu de sujeira");
            alive = false;
        }
        if(clean > cleanMax)
            clean = cleanMax;
    }

    private void setHungry(int value){
        hungry = value;
        if(hungry <= 0){
            hungry = 0;
            System.out.println("Seu pet morreu de fome");
            alive = false;
        }
        if(hungry > hungryMax )
            hungry = hungryMax;
    }

    boolean testarMorto(){
        if(this.alive)
            return false;
        System.out.println("O seu pet está morto");
        return true;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHungry() {
        return hungry;
    }

    public int getClean() {
        return clean;
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public void play(){
        if(testarMorto())
            return;
        this.setHungry(getHungry() - 2);
        this.setClean(getClean() - 3);
        this.setEnergy(getEnergy() - 2);
        this.diamonds += 1;
        this.age += 1;
    }

    public void clean(){
        if(testarMorto())
            return;
        this.setEnergy(getEnergy() - 3);
        this.setHungry(getHungry() - 1);
        this.setClean(getCleanMax());
        this.age += 2;
    }

    public void eat(){
        if(testarMorto())
            return;
        this.setEnergy(getEnergy() - 1);
        this.setHungry(getHungry() + 4);
        this.setClean(getClean() -2);
        this.age += 1;
    }

    public void sleep(){
        if(testarMorto())
            return;
        if(getEnergy() >= getEnergy() - 5){
            System.out.println("fail: nao esta com sono");
        }
        this.setEnergy(getEnergyMax());
            return;
    }



    @Override
    public String toString() {
        return "Energy: " + energy + "/" + energyMax + ", \n"
            + "Hungry: " + hungry + "/" + hungryMax + ", \n"
            + "Clean: " + clean + "/" + cleanMax + ", \n"
            + "Diamonds: " + diamonds + ", Idade: " + age;


    }

}

public class Tamagotchi {
    
    public static void main(String[] args) {
        Pet pet = new Pet(0, 0, 0);
        Scanner sc = new Scanner(System.in);
        
        while(true){

            String line = sc.nextLine();
            String[] usrIn = line.split(" ");
            if(usrIn[0].equals("init")){
                int energy = Integer.parseInt(usrIn[1]);
                int hungry = Integer.parseInt(usrIn[2]);
                int clean = Integer.parseInt(usrIn[3]);
                pet = new Pet(energy, hungry, clean);
            }else if(usrIn[0].equals("play")){
                pet.play();
            }else if(usrIn[0].equals("eat")){
                pet.eat();
            }else if(usrIn[0].equals("clean")){
                pet.clean();
            }else if(usrIn[0].equals("show")){
                System.out.println(pet);
            }else if(usrIn[0].equals("end")){
                break;
            }else{
                System.out.println("Comando invalido");
            }
        }

        sc.close();
        
    }    
}
