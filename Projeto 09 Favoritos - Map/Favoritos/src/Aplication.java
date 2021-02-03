import java.util.ArrayList;

import entities.Contact;
import entities.Phone;
import entities.PhoneBook;

public class Aplication {
    
    public static void main(String[] args) {
        
        PhoneBook phoneBook = new PhoneBook();
        ArrayList<Phone> phones = new ArrayList<>();
        ArrayList<Phone> phone1 = new ArrayList<>();
        phones.add(new Phone("claro", "159753"));
        phones.add(new Phone("time", "aa563"));
        phones.add(new Phone("oio", "756389"));
        phoneBook.addContact("vitor", phones);
        phone1.add(new Phone("claro", "1777"));
        phone1.add(new Phone("CLA", "753"));
        phoneBook.addContact("ana", phone1);
        phoneBook.addContact("dri", phones);
        phoneBook.bookMark("dri");
        phoneBook.bookMark("ana");
        System.out.println(phoneBook);
        System.out.println(phoneBook.getBookMarks());
        ArrayList<Contact> regex = new ArrayList<>();
        regex = phoneBook.search("cla");
        System.out.println(regex);
        

    }
}
