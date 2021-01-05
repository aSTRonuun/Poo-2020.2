import java.util.Scanner;

import entities.AccountBank;

public class aplication {
    
    public static void main(String[] args) {
        AccountBank account = new AccountBank(0);

        Scanner sc = new Scanner(System.in);

        while(true){
            String line = sc.nextLine();
            String[] usrIn = line.split(" ");
            if(usrIn[0].equals("init")){
                int number = Integer.parseInt(usrIn[1]);
                account = new AccountBank(number);
            }else if(usrIn[0].equals("show")){
                System.out.println(account);
            }else if(usrIn[0].equals("deposit")){
                float value = Float.parseFloat(usrIn[1]);
                account.deposit(value);
            }else if(usrIn[0].equals("withdraw")){
                float value = Float.parseFloat(usrIn[1]);
                account.toWithdraw(value);
            }else if(usrIn[0].equals("tariff")){
                float value = Float.parseFloat(usrIn[1]);
                account.tariff(value);
            }else if(usrIn[0].equals("extract")){
                account.getExtract();
            }else if(usrIn[0].equals("extractN")){
                int n = Integer.parseInt(usrIn[1]);
                account.getExtractLast(n);
            }else if(usrIn[0].equals("reversal")){
                int n = Integer.parseInt(usrIn[1]);
                int[] indexs = new int[usrIn.length - 1];

                for(int i=1;i<usrIn.length;i++){
                    indexs[i-1] = Integer.parseInt(usrIn[i]);
                }
                account.reversal(indexs);
            }else if(usrIn[0].equals("end")){
                break;
            }else{
                System.out.println("Invalid command...");
            }
        }

        sc.close();
    }
    
}
