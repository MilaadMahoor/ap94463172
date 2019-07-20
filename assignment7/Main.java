import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapArray = new ArrayList();
        for (int i=0;i<10;i++){
            int randomNumber = ThreadLocalRandom.current().nextInt(1,4);
            if(randomNumber==1){

                Shape square = new Square(ThreadLocalRandom.current().nextInt(1,100));
                square.enviroment();
                square.area();
                square.toString();
                square.print();
                shapArray.add(square);


            }else if(randomNumber==2){

                Shape circle = new Circle(ThreadLocalRandom.current().nextInt(1,100));
                circle.enviroment();
                circle.area();
                circle.toString();
                circle.print();
                shapArray.add(circle);
            }else if(randomNumber==3){
               
                Shape rectangle = new Rectangle(ThreadLocalRandom.current().nextInt(1,100)
                        ,ThreadLocalRandom.current().nextInt(1,50));
                rectangle.area();
                rectangle.enviroment();
                rectangle.toString();
                rectangle.print();
                shapArray.add(rectangle);

            }
        }




















    }
}
