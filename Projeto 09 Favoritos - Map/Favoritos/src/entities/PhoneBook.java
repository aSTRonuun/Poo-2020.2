package entities;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    
    private TreeMap<String, Contact> contacts;
    private TreeMap<String, Contact> bookMarks;

    public PhoneBook(){
        this.contacts = new TreeMap<>();
        this.bookMarks = new TreeMap<>();
    }

    public void addContact(String name, ArrayList<Phone> phones){
        if(this.contacts.containsKey(name)){
            this.contacts.get(name).addPhones(phones);
        }if(this.bookMarks.containsKey(name)){
            this.bookMarks.get(name).addPhones(phones);
            return;
        }
        Contact addContact = new Contact(name);
        addContact.addPhones(phones);
        this.contacts.put(name, addContact);
        System.out.println("Contact added sucessefully.");
        return;
    }

    public boolean rmContact(String name){
        if(this.contacts.containsKey(name)){
            this.contacts.remove(name);
            System.out.println("Contact removed from contact list.");
        }if(this.bookMarks.containsKey(name)){
            this.bookMarks.remove(name);
            System.out.println("Contact removed from favorites list.");
            return true;
        }
        throw new RuntimeException("Name not found.");
    }

    public void bookMark(String name){
        if(!this.contacts.containsKey(name))
            throw new RuntimeException("Contact "+ name +" does not exist.");
        if(this.bookMarks.containsKey(name))
            throw new RuntimeException("The contact "+ name +" is already in the favorite list.");
        
        Contact addBookMark = this.contacts.get(name);        
        this.contacts.get(name).setStarred(true);
        this.bookMarks.put(name, addBookMark);
        this.contacts.remove(name);
        System.out.println("Contact "+ name +" added to favorites list.");
        return;
    }

    public void unBookMark(String name){
        if(!this.bookMarks.containsKey(name))
            throw new RuntimeException("Contact "+ name +" does not exit.");
        
        Contact addContact = this.bookMarks.get(name);
        this.contacts.put(name, addContact);
        this.bookMarks.remove(name);
        System.out.println("Contact "+ name +" removed successfully");
    }

    public String getBookMarks(){
        String bookMarksList = "";
        for(Contact bookMark : this.bookMarks.values())
            bookMarksList += bookMark.toString();
        return bookMarksList;
    }

    public ArrayList<Contact> search(String expression){
        ArrayList<Contact> regexContact = new ArrayList<>();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher;
        for(Contact bookMark : this.bookMarks.values()){
            matcher = pattern.matcher(bookMark.toString());
            if(matcher.find())
                regexContact.add(bookMark);
        }
        for(Contact contact : this.contacts.values()){
            matcher = pattern.matcher(contact.toString());
            if(matcher.find())
                regexContact.add(contact);
        }

        return regexContact;
    }

    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        for(Contact bookMark : this.bookMarks.values())
            exit.append(bookMark.toString());
        for(Contact contact : this.contacts.values())
            exit.append(contact.toString());
        return exit.toString();
    }

}
