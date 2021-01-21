package entities;

import java.util.ArrayList;

public class Contact {
    
    private String name;
    private ArrayList<Phone> phones;

    public Contact(String name){
        this.name = name;
        this.phones = new ArrayList<>();
    }

    public boolean addPhone(String id, String number){
        if(Phone.validate(number)){ 
            phones.add(new Phone(id, number));
            return true;
        }
        System.out.println("Invalid number... try again!");
        return false;
    }

    public boolean rmvPhone(int index){
       if(index >= 0 && index < phones.size()){
           phones.remove(index);
           System.out.println("sycessfully removed");
           return true;
       }
       System.out.println("Invalid index");
       return false;
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
        System.out.println("Invalid index");
        return null;
    }

    @Override
    public String toString() {
        String exitString = this.name;
        int i=0;
        for(Phone phones : phones){ 
            exitString += " [" + i + ":" + phones.toString() + "]";
            i++;
        }   
        return exitString;
    }
}
