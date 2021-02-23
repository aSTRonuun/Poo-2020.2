import java.util.ArrayList;


import entities.Phone;
import entities.PhonebookPlus;

public class App {
    
    public static void main(String[] args) {
        PhonebookPlus phonebook = new PhonebookPlus();
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("cla", "159753"));
        phones.add(new Phone("tim", "753159"));
        phonebook.addContact("vitor", phones);
        phonebook.addContact("ana", phones);
        phonebook.bookMark("vitor");
        System.out.println(phonebook);
        phonebook.rmvContact("vitor");
        phonebook.bookMark("ana");
        phonebook.unBookMark("ana");
        System.out.println(phonebook);
    }
}
