import java.util.Scanner;

public class Carro {
    
    int gas;
    int gasMax;
    int pass;
    int passMax;
    int km;
    int contOil;
    boolean oil;

    Carro(int gas, int pass, int gasMax, int passMax){
        this.gas = gas;
        this.gasMax = gasMax;
        this.pass = pass;
        this.passMax = passMax;
        this.km = 0;
        this.contOil = 0;
        this.oil = true;
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
            if(gas > gasMax){
                gas = gasMax;
            }
        }
        
    }

    boolean drive(int distance){
        if(pass > 0 && gas > 0 && oil == true){ 
            if(distance > gas){
                km += gas;
                System.out.println("fail: tanque vazio apos andar " + gas);
                gas = 0;
                return true;           
            }else{
                km += distance;
                gas -= distance;
                if( km - contOil >= 2000){
                    oil = false;
                    contOil =+ km; 
                }
                return true;
            }
        }else if(pass == 0){
            System.out.println("fail: nao ha ninguem no carro");
            return true;
        }else if(gas == 0){
            System.out.println("fail: tanque vazio");
            return true;
        }else if(oil == false){
            System.out.println("fail: o oleo precisa ser trocado");
            return true;
        }
        return false;

    }

    void oil(){
        if(oil){
            System.out.println("Nivel do Oleo está bom!");
        }else{
            oil = true;
        }
    }

    @Override
    public String toString(){
        String verifOil;
        if(oil){
            verifOil = "OK";
        }else{
            verifOil = "Alerta de Manutençao";
        }

        
        return "pass: "
            + pass
            + ", gas: "
            + gas
            + ", km: "
            + km
            + ", oil: "
            + verifOil;          
    }

    public static void main(String[] args) {
    
        Carro car = new Carro(0, 0, 500, 4);

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
            }else if(usrIn[0].equals("drive")){
                int distance = Integer.parseInt(usrIn[1]);
                car.drive(distance);
            }else if(usrIn[0].equals("oil")){
                car.oil();
            }else if(usrIn[0].equals("show")){
                System.out.println(car);
            }else if(usrIn[0].equals("end")){
                break;
            }else{
                System.out.println("Comando invalido");
            }
        }

        sc.close();
    }
}
