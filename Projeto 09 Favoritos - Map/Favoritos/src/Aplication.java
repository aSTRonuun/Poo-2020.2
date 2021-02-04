import java.util.ArrayList;
import java.util.Scanner;

import entities.Contact;
import entities.Phone;
import entities.PhoneBook;

public class Aplication {
    
    public static void main(String[] args) {
        
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                String line = sc.nextLine();
                String[] ui = line.split(" ");
                if(ui[0].equals("add")){
                    ArrayList<Phone> phones = new ArrayList<>();
                    for(int i=2;i<ui.length;i++){
                        String phoneNumbers[] = ui[i].split(":");
                        phones.add(new Phone(phoneNumbers[0], phoneNumbers[1]));
                    }
                    phoneBook.addContact(ui[1], phones);
                }else if(ui[0].equals("rmContact")){
                    phoneBook.rmContact(ui[1]);
                }else if(ui[0].equals("starred")){
                    System.out.println(phoneBook.getBookMarks());
                }else if(ui[0].equals("star")){
                    phoneBook.bookMark(ui[1]);
                }else if(ui[0].equals("unstar")){
                    phoneBook.unBookMark(ui[1]);
                }else if(ui[0].equals("search")){
                    ArrayList<Contact> regex = new ArrayList<>();
                    regex = phoneBook.search(ui[1]);
                    System.out.println(regex);
                }else if(ui[0].equals("show")){
                    System.out.println(phoneBook);
                }else if(ui[0].equals("end")){
                    break;
                }else{
                    System.out.println("Invalid command.");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("Error: Insufficient parameters to complete the operation");
            }catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
