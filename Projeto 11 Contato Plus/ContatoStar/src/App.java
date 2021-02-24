import java.util.ArrayList;
import java.util.Scanner;

import entities.Contact;
import entities.ContactPlus;
import entities.Phone;
import entities.PhonebookPlus;

public class App {
        
    public static void main(String[] args) {

        PhonebookPlus phonebook = new PhonebookPlus();
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
                    ContactPlus contact = new ContactPlus(ui[1]);
                    contact.addPhones(phones);
                    phonebook.addContact(contact);
                }else if(ui[0].equals("rmvContact")){
                    phonebook.rmvContact(ui[1]);
                }else if(ui[0].equals("star")){
                    phonebook.bookMark(ui[1]);
                }else if(ui[0].equals("starred")){
                    System.out.println(phonebook.toStringBookmark());
                }else if(ui[0].equals("unstar")){
                    phonebook.unBookMark(ui[1]);
                }else if(ui[0].equals("search")){
                    ArrayList<Contact> regex = new ArrayList<>();
                    regex = phonebook.search(ui[1]);
                    System.out.println(regex);
                }else if(ui[0].equals("show")){
                    System.out.println(phonebook);
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
