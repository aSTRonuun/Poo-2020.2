class Pet{
    private int energyMax;
    private int cleanMax;
    private int hungryMax;
    private int energy;
    private int clean;
    private int hungry;
    private boolean alive;

    public Pet(int energyMax, int hungryMax, int cleanMax){
        this.energyMax = energyMax;
        this.hungryMax = hungryMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.hungry = hungryMax;
        this.clean = cleanMax;
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

    public void brincar(){
        if(testarMorto())
            return;
        this.setHungry(getHungry() - 2);
        this.setClean(getClean() - 3);
        this.setEnergy(getEnergy() - 5);
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

    public boolean isAlive(){
        return this.alive;
    }

    @Override
    public String toString() {
        return "Energe: "
            + energy 
            + "/"
            + energyMax
            + "Hungry: "
            + hungry
            + "/"
            + hungryMax
            + " Clean: "
            + clean
            + "/"
            + cleanMax;
    }

}

public class Tamagoshi {
    
    public static void main(String[] args) {
        Pet pet = new Pet(20, 15, 10);
        System.out.println(pet);
        
    }    
}
