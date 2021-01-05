import java.util.ArrayList;
import java.util.Scanner;

class Kid{

    private String name;
    private int age;
    

    public Kid(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name
            + ":"
            + age;
    }
}

class PulaPula{
    
    ArrayList<Kid> kidsWaiting;
    ArrayList<Kid> kidsPlaying;
    int limit;
    double cashBox;

    public PulaPula(int limit){
        this.kidsWaiting = new ArrayList<>();
        this.kidsPlaying =  new ArrayList<>();
        this.limit = limit;
        this.cashBox = 0;
    }

    public double getCashBox() {
        return cashBox;
    }

    public void arrive(Kid kid){
        kidsWaiting.add(0, kid);
    }

    public void in(){
        if(kidsWaiting.isEmpty()){
            System.out.println("Não ná nenhuma criança no fila.");
            return;
        }
        if(kidsPlaying.size() == limit){
            System.out.println("Limite superado, espere uma criança sair");
            return;
        }
        Kid kidFirst = kidsWaiting.get(kidsWaiting.size() - 1);
        kidsWaiting.remove(kidsWaiting.size() - 1);
        kidsPlaying.add(0, kidFirst); 
        cashBox += 2.00;
        return;
    }

    public void out(){
        if(kidsPlaying.isEmpty()){
            System.out.println("Não há nenhuma criança no PulaPula.");
            return;
        }
        Kid kidFirst = kidsPlaying.get(kidsPlaying.size() - 1);
        kidsPlaying.remove(kidsPlaying.size() - 1);
        kidsWaiting.add(0, kidFirst);
        return;
    }

    public boolean removeKid(String name){
        if(kidsPlaying.isEmpty() && kidsWaiting.isEmpty())
            return false;
        for(Kid kids : kidsWaiting){
            if(kids.getName().equals(name)){ 
                Kid kidsair = kids;
                kidsWaiting.remove(kidsair);
                return true;
            }
        }
        for(Kid kids : kidsPlaying){
            if(kids.getName().equals(name)){ 
                Kid kidsair = kids;
                kidsPlaying.remove(kidsair);
                return true;
            }
        }
        System.out.println("Nome inválido, tente novamente...");
        return false;
    }

    @Override
    public String toString() {
        return "Caixa: " + cashBox + " Limit: " + kidsPlaying.size() + "/" + limit + "\n"
            + "=> " + kidsWaiting + "=> " + kidsPlaying + " ";
    }

    public static void main(String[] args) {
        PulaPula pulapula = new PulaPula(0);
        
        Scanner sc = new Scanner(System.in);

        while(true){
            String line = sc.nextLine();
            String[] usrIn = line.split(" ");
            if(usrIn[0].equals("init")){
                int limit = Integer.parseInt(usrIn[1]);
                pulapula = new PulaPula(limit);
            }else if(usrIn[0].equals("chegou")){
                String name = usrIn[1];
                int age = Integer.parseInt(usrIn[2]);
                pulapula.arrive(new Kid(name, age));
            }else if(usrIn[0].equals("entrar")){
                pulapula.in();
            }else if(usrIn[0].equals("sair")){
                pulapula.out();
            }else if(usrIn[0].equals("papaichegou")){
                String name = usrIn[1];
                pulapula.removeKid(name);
            }else if(usrIn[0].equals("show")){
                System.out.println(pulapula);
            }else if(usrIn[0].equals("end")){
                break;
            }else{
                System.out.println("Comando inválido");
            }
        }
        sc.close();

    }
}