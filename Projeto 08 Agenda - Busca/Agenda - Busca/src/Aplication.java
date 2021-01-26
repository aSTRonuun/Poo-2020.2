import java.util.ArrayList;
import java.util.Scanner;

import entities.Contact;
import entities.Phone;
import entities.Schedule;


public class Aplication {
    
    public static void main(String[] args) {
        
        Schedule schedule = new Schedule();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String line = sc.nextLine();
            String[] usrIn = line.split(" ");
            if(usrIn[0].equals("add")){
                boolean verification = true;
                ArrayList<Phone> phones = new ArrayList<Phone>();
                for(int i=2;i < usrIn.length;i++){
                    String phoneNumbers[] = usrIn[i].split(":");
                    phones.add(new Phone(phoneNumbers[0], phoneNumbers[1]));
                }
                verification = schedule.addContact(usrIn[1], phones);
                if(verification)
                    System.out.println("Contact saved sucessfully.");
                else
                    System.out.println("There was an erro saving... Try again.");
            }else if(usrIn[0].equals("show")){
                System.out.println(schedule);
            }else if(usrIn[0].equals("rmFone")){
                String name = usrIn[1];
                int index = Integer.parseInt(usrIn[2]);
                schedule.rmPhone(name, index);
            }else if(usrIn[0].equals("end")){
                break;
            }else if(usrIn[0].equals("search")){
                ArrayList<Contact> regex = new ArrayList<>();
                regex = schedule.search(usrIn[1]);
                System.out.println(regex);
            }else if(usrIn[0].equals("addPhone")){
                String name  = usrIn[1];
                String[] data = usrIn[2].split(":");
                schedule.addPhone(name, data[0], data[1]);
            }else{
                System.out.println("Command Invalid...");
            }
        }

        sc.close();
    }
}
