package entities;

import java.util.ArrayList;
import java.util.Collections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Schedule {
    
    private ArrayList<Contact> contacts;

    public Schedule(){
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(String name, ArrayList<Phone> phones){
        for(Contact contact : contacts){
            if(contact.getName().equals(name)){
                System.out.println("Name already redistered!");
                return false;
            }
        }
        this.contacts.add(new Contact(name, phones));
        Collections.sort(contacts);
        return true;
    }

    public boolean addPhone(String name, String id, String number){
        for(Contact contact : contacts){
            if(contact.getName().equals(name)){
                contact.addPhone(id, number);
                System.out.println("Phone successfully added!");
                return true;
            }
        }
        System.out.println("No contact found");
        return false;
    }

    public boolean rmContact(String name){
        for(Contact contact : contacts){
            contact.getName().equals(name);
            contacts.remove(contact);
            System.out.println("Contact removed successfully.");
            return true;
        }
        System.out.println("No contacts found.");
        return false;
    }


    public ArrayList<Contact> search(String expression){
        ArrayList<Contact> regex = new ArrayList<>();
        //expression += "\\w";

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher;
        for(Contact contact : contacts){
            matcher = pattern.matcher(contact.toString());
            if(matcher.find()){
                regex.add(contact);
            }
        }
        return regex;
    }

    public boolean rmPhone(String name, int index){
        for(Contact contact : contacts){
            if(contact.getName().equals(name)){
                contact.rmvPhone(index);
                return true;
            }
        }
        System.out.println("No contacts found.");
        return false;
    }


    @Override
    public String toString() {
        String exit = "";

        for(Contact contact : contacts)
            exit += "- " + contact.toString() + "\n" ;

        return exit;
    }
}

