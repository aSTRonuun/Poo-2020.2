import entities.Movies;
import java.util.Scanner;

public class Aplication {
    
    public static void main(String[] args) {
        
        Movies movies = new Movies(0);

        Scanner sc = new Scanner(System.in);

        while(true){
            String line = sc.nextLine();
            String[] usrIn = line.split(" ");
            if(usrIn[0].equals("init")){
                int size = Integer.parseInt(usrIn[1]);
                movies = new Movies(size);
            }else if(usrIn[0].equals("reserve")){
                String id = usrIn[1];
                String fone = usrIn[2];
                int index = Integer.parseInt(usrIn[3]);
                movies.reserve(id, fone, index);
            }else if(usrIn[0].equals("cancel")){
                String id = usrIn[1];
                movies.cancel(id);
            }else if(usrIn[0].equals("show")){
                System.out.println(movies);
            }else if(usrIn[0].equals("end")){
                break;
            }else{
                System.out.println("Invalid command...");
            }
        }

        sc.close();
    }
}
