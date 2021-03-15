import java.util.Scanner;

import controller.Agency;

public class App {
    
    public static void main(String[] args) {
        Agency agency = new Agency();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------GALACTIC-BANK 🌌-----------");

        while(true){
            try{
                String line = sc.nextLine();
                String[] ui = line.split(" ");
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addCli")){
                    agency.addClient(ui[1]);
                }else if(ui[0].equals("show")){
                    System.out.println(agency);
                }else if(ui[0].equals("deposit")){
                    int id = Integer.parseInt(ui[1]);
                    float value = Float.parseFloat(ui[2]);
                    agency.bankDeposit(id, value);
                }else if(ui[0].equals("draft")){
                    int id = Integer.parseInt(ui[1]);
                    float value = Float.parseFloat(ui[2]);
                    agency.bankDraft(id, value);
                }else if(ui[0].equals("transfer")){
                    int idMe = Integer.parseInt(ui[1]);
                    int idOther = Integer.parseInt(ui[2]);
                    float value = Float.parseFloat(ui[3]);
                    agency.bankTransfer(idMe, idOther, value);
                }else if(ui[0].equals("update")){
                    agency.bankUpdate();
                }else{
                    System.out.println("❌ Error: command invalid.");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("❌ Error: Insuffiecient parameters to complete the operation");
            }catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
