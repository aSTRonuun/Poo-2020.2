package entities;

import java.util.ArrayList;


public class Contact implements Comparable<Contact> {
    
    private String name;
    private ArrayList<Phone> phones;

    public Contact(String name){
        this.name = name;
        this.phones = new ArrayList<>();
    }

    public Contact(String name, ArrayList<Phone> phones){
        this.name = name;
        this.phones = phones;
    }

    public boolean addPhone(String id, String number){
        if(Phone.validate(number)){ 
            phones.add(new Phone(id, number));
            return true;
        }
        throw new RuntimeException("Invalid number... try again!");
    }

    public boolean rmvPhone(int index){
       if(index >= 0 && index < phones.size()){
           phones.remove(index);
           System.out.println("sucessfully removed");
           return true;
       }
       throw new RuntimeException("Invalid index");
    }

    public Phone getNamePhone(String name){
        for(Phone phone : phones){
            if(phone.getId().equals(name)){
                return phone;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Phone getPhones(int index){
        if(index >= 0 || index <= phones.size()){
            return phones.get(index);
        }
        throw new RuntimeException("Invalid index");
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        String exitString = this.name;
        int i=0;
        for(Phone phones : phones){ 
            exitString += " [" + i + ":" + phones.toString() + "]";
            i++;
        }
        exitString += "\n";   
        return exitString;
    }
}

