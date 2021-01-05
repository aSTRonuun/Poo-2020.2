import entities.AccountBank;

public class aplication {
    
    public static void main(String[] args) {
        AccountBank account = new AccountBank(100);
        System.out.println(account);

        account.deposit(100);
        System.out.println(account);
        account.toWithdraw(-50);
        System.out.println(account);
        account.toWithdraw(-60);
        System.out.println(account);
        account.deposit(80);
        account.toWithdraw(-30);
        account.deposit(100);
        account.getExtract();
        account.deposit(30);
        account.getExtractLast(3);
        account.tariff(10);
        account.getExtract();
        account.toWithdraw(-220);
        account.getExtract();
    }
    
}
