import controller.Agency;

public class App {
    
    public static void main(String[] args) {
        Agency agency = new Agency();
        agency.addClient("Almir");
        agency.addClient("Julia");
        agency.addClient("Maria");
        System.out.println(agency);
        agency.bankDeposit(0, 100);
        agency.bankDeposit(1, 200);
        agency.bankDeposit(2, 50);
        agency.bankDeposit(3, 300);
        agency.bankDraft(3, 50);
        agency.bankDraft(0, 70);
        System.out.println(agency);
        agency.bankTransfer(3, 5, 200);
        agency.bankTransfer(0, 4, 25);
        System.out.println(agency);
        agency.bankUpdate();
        System.out.println(agency);

    }
}
