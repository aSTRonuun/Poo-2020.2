import java.util.Scanner;

import entities.Pass;
import entities.Topic;

public class Aplication {

    public static void main(String[] args) {
        Topic topic = new Topic(0, 0);
        Scanner sc = new Scanner(System.in);

        while(true){
            String line = sc.nextLine();
            String[] usrIn = line.split(" ");
            if(usrIn[0].equals("init")){
                int seatsT = Integer.parseInt(usrIn[1]);
                int seatsP = Integer.parseInt(usrIn[2]);
                topic = new Topic(seatsT, seatsP);
            }else if(usrIn[0].equals("in")){
                String name = usrIn[1];
                int age = Integer.parseInt(usrIn[2]);
                Pass pass = new Pass(name, age);
                topic.toBoard(pass);
            }else if(usrIn[0].equals("out")){
                String name = usrIn[1];
                topic.land(name);
            }else if(usrIn[0].equals("show")){
                System.out.println(topic);
            }else if(usrIn[0].equals("end")){
                break;
            }else{
                System.out.println("Invalid Command...");
            }
        }
        sc.close();
    }

}
