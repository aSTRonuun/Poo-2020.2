import entities.Pass;
import entities.Topic;

public class Aplication {

    public static void main(String[] args) {
        Topic topic = new Topic(3, 2);

        topic.toBoard(new Pass("davi", 17));
        topic.toBoard(new Pass("gui", 80));
        topic.toBoard(new Pass("ana", 35));
        topic.toBoard(new Pass("ana", 20));
        topic.land("davi");
        
    }

}
