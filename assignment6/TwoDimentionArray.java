import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TwoDimentionArray {

    public Scanner sc = new Scanner(System.in);

    public ArrayList <ArrayList<Integer>> arry = new ArrayList();
    public static int x;
    public int i;
    public static int randomNumber = ThreadLocalRandom.current().nextInt(0,10);

    public TwoDimentionArray (){
        System.out.println("Set x:");
        x = sc.nextInt();
        System.out.println(randomNumber);
    }
    public void randomNumber(){
        x = randomNumber;
        System.out.println(x);
    }




}
