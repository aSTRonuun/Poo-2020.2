import java.util.Scanner;

public class Carro {
    
    int gas;
    int gasMax;
    int pass;
    int passMax;
    int km;

    Carro(int gas, int pass){
        this.gas = gas;
        this.gasMax = 100;
        this.pass = pass;
        this.passMax = 2;
        this.km = 0;
    }

    boolean in(){
        if(pass < passMax){
            pass += 1;
            return true;
        }else{
            System.out.println("fail: limite de pessoas atingido");
            return false;
        }
    }

    boolean out(){
        if(pass > 0){
            pass -= 1;
            return true;
        }else{
            System.out.println("fail: nao ha ninguem no carro");
            return false;
        }
    }

    void fuel(int value){
        if(gas < gasMax){
            gas += value;
        }else if(gas > gasMax){
            gas = gasMax;
        }
        
    }

    @Override
    public String toString(){
        return "pass: "
            + pass
            + ", gas: "
            + gas
            + ", km: "
            + km;
    }

    public static void main(String[] args) {
    
        Carro car = new Carro(0, 0);
        Scanner sc = new Scanner(System.in);
    
        while(true){
            String line = sc.nextLine();
            String[] usrIn = line.split(" ");
            if(usrIn[0].equals("in")){
                car.in();
            }else if(usrIn[0].equals("out")){
                car.out();
            }else if(usrIn[0].equals("fuel")){
                int qtd = Integer.parseInt(usrIn[1]);
                car.fuel(qtd);
            }else if(usrIn[0].equals("show")){
                System.out.println(car);
            }else{
                System.out.println("Comando invalido");
            }
        }
    }
}
