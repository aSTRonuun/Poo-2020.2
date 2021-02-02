import java.util.ArrayList;

import entities.Phone;
import entities.PhoneBook;

public class Aplication {
    
    public static void main(String[] args) {
        
        PhoneBook phoneBook = new PhoneBook();
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("claro", "159753"));
        phones.add(new Phone("time", "aa563"));
        phones.add(new Phone("oio", "756389"));
        phoneBook.addContact("vitor", phones);
        phoneBook.bookMark("vitor");
        phoneBook.unBookMark("vitor");
        
    }
}
