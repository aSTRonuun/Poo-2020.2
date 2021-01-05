import entities.AccountBank;

public class aplication {
    
    public static void main(String[] args) {
        AccountBank account = new AccountBank(100);
        System.out.println(account);

        account.deposit(100);
        account.tariff(20);
        account.deposit(5);
        System.out.println(account);
        account.getExtract();
        int[] indexs = {2};
        account.reversal(indexs);
        System.out.println(account);
        account.getExtract();
        account.deposit(10);
        account.tariff(5);
        account.tariff(5);
        account.deposit(10);
        System.out.println(account);
        account.getExtract();
        int[] indexs2 = {6, 7, 12};
        account.reversal(indexs2);
        System.out.println(account);
        account.getExtract();

    }
    
}
