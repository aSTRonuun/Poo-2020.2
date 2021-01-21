package entities;

import java.util.ArrayList;

public class Schedule {
    
    private ArrayList<Contact> contacts;

    public Schedule(){
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(String name, ArrayList<Phone> phones){
        for(Contact contact : contacts){
            if(contact.equals(name)){
                System.out.println("Name already redistered!");
                return false;
            }
        }
        Contact cont = new Contact(name, phones);
        contacts.add(cont);
        return true;
    }
}
