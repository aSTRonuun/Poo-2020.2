import entities.Contact;

public class Aplication {
    
    public static void main(String[] args) {
        
        Contact contact = new Contact("Vitor");
        contact.addPhone("claro", "88994281497");
        contact.addPhone("tim", "(88)99428-1497");
        contact.addPhone("oi", "34975bbaa61");
        contact.rmvPhone(0);
        contact.rmvPhone(1);
        contact.rmvPhone(0);
        System.out.println(contact);
    }
}
