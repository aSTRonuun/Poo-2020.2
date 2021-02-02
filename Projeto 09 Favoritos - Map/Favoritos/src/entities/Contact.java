package entities;

import java.util.ArrayList;

public class Contact {
    
    private String name;
    private boolean starred;
    private ArrayList<Phone> phones;
    
    public Contact(String name){
        this.name = name;
        this.phones = new ArrayList<>();
        this.starred = false;
    }

    public boolean addPhone(String label, String number){
        if(Phone.validate(number)){
            phones.add(new Phone(label, number));
            return true;
        }
        throw new RuntimeException("Invalid number.");
    }

    public boolean addPhones(ArrayList<Phone> phones){
        boolean invalid = false;
        for(int i=0;i<phones.size();i++){
            if(!Phone.validate(phones.get(i).getNumber())){
                phones.remove(i);
                invalid = true;
            }
        }
        if(invalid)
            System.out.println("Some numbers have not been saved.");
        else
            System.out.println("All numbers have been saved.");
        this.phones.addAll(phones);
        return true;
    }

    public boolean rmPhone(int index){
        if(index >= 0 || index <= phones.size()){ 
            phones.remove(index);
            System.out.println("Sucessfully removed.");
            return true;
        }
        throw new RuntimeException("Invalid index");
    }

    public Phone getLabelPhone(String label){
        for(Phone phone : phones){
            if(phone.getLabel().equals(label))
                return phone;
        }
        throw new RuntimeException("Label not found");
    }

    public String getName() {
        return name;
    }

    public void setStarred(boolean value) {
        this.starred = value;
    }

    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        if(this.starred)
            exit.append("@ " + this.name);
        else
            exit.append("- " + this.name); 
        
        int i=0;
        for(Phone phone : phones){
            exit.append(" [" + i + ":" + phone.toString() + "]");
            i++;
        }
        return exit.toString();
    }



    

}
