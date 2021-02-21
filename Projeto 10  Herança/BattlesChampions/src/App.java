import java.io.IOException;
import java.util.Scanner;

import entities.Game;

public class App {

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
            
            System.out.println("[1] - Play");
            System.out.println("[0] - End");
            
            try{
                System.out.print("> ");
                int command = sc.nextInt();
                if(command == 1){
                    System.out.println("Enter the number of Trolls for the battle with the champions - (max 5)");
                    System.out.print("> ");
                    int ntrols = sc.nextInt();
                    if(ntrols > 5)
                        ntrols = 5;
                    Game game = new Game(ntrols);
                    game.play();
                    System.out.println("Enter [0] for exit... ");
                    int exit = sc.nextInt();
                }else if(command == 0){
                    break;
                }else{
                    System.out.println("Error: Invalid command");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("Error: Insufficient parameters to complete the operation");
            }
        }
        sc.close();
    }
}