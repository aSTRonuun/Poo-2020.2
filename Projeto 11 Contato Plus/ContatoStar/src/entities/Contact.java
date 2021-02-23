package entities;

import java.util.ArrayList;

public class Contact {
    
    protected String name;
    protected ArrayList<Phone> phones;
    
    public Contact(String name){
        this.name = name;
        this.phones = new ArrayList<>();
    }
    //Adicionar somente um fone no contato
    public boolean addPhone(String label, String number){
        if(Phone.validate(number)){
            phones.add(new Phone(label, number));
            return true;
        }
        throw new RuntimeException("Invalid number.");
    }
    //Adicionar uma lista de phones no contato
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
    //remover fone do contato
    public boolean rmPhone(int index){
        if(index >= 0 || index <= phones.size()){ 
            phones.remove(index);
            System.out.println("Sucessfully removed.");
            return true;
        }
        throw new RuntimeException("Invalid index");
    }
    //pegar um phone pelo rotulo
    public Phone getLabelPhone(String label){
        for(Phone phone : phones){
            if(phone.getLabel().equals(label))
                return phone;
        }
        throw new RuntimeException("Label not found");
    }
    //pegar o nome
    public String getName() {
        return name;
    }
    //pegar uma lista de fones
    public ArrayList<Phone> getPhones(){
        return phones;
    }
    //toString
    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append(" - " + this.name);
        int i=0;
        for(Phone phone : phones){
            exit.append(" [" + i + ":" + phone.toString() + "]");
            i++;
        }
        exit.append("\n");
        return exit.toString();
    }
}

