import java.util.ArrayList;

import entities.Phone;
import entities.Schedule;


public class Aplication {
    
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();
        Schedule schedule = new Schedule();
        phones.add(new Phone("Tim", "789456"));
        phones.add(new Phone("Claro", "159753"));
        schedule.addContact("vitor", phones);
        phones = new ArrayList<>();
        phones.add(new Phone("tim", "123"));
        phones.add(new Phone("oi", "123"));
        phones.add(new Phone("claro", "123"));
        schedule.addContact("ana", phones);
        schedule.addContact("Vitor", phones);
        System.out.println(schedule);
    }
}
