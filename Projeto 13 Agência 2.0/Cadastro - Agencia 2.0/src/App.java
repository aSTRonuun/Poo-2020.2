import controller.Agency;

public class App {
    
    public static void main(String[] args) {
        Agency agency = new Agency();
        agency.addClient("almir");
        System.out.println(agency);
    }
}
