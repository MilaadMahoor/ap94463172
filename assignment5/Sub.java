/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 5
  98/01/31
  Milad Zolfkhani
  94463172
 */



import java.lang.Math;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Sub  {


    int x, y;
    long result;
    boolean ast = true;

    ArrayList<Long> posResults = new ArrayList();
    ArrayList<Long> negResults = new ArrayList();

    public Sub() {
        System.out.println("Calculating Given f(x.y) where the variables are between (-1000)&(1000) and our Output has maximum Value");
        System.out.println("f(x,y)= (sqrt(x*x+y*y))/(xSin(x+y)+yCos(x+y))");

    }


    public long function() {
        long a = (long)Math.sqrt((x * x )+ (y * y));
        long temp1 = (long) Math.sin(Math.toRadians(x+y));
        long temp2 = (long) Math.cos(Math.toRadians(x+y));
        if((x*temp1+y*temp2) == 0){
            return 0;
        }
        result =  (a/(x*temp1 + y*temp2)) ;

        result = (long) (Math.round(result*100)/100.0d);

        return result;
    }


    public void varsSetter() {



        for (x = -1000; x <= 1000; x++) {
            for (y = -1000; y <= 1000; y++) {

                this.function();

                if(result>=0) {
                    posResults.add( result);

                }
                if(result<0) {
                    negResults.add(result);
                }


            }

        }


        Collections.sort(posResults);
        Collections.sort(negResults);





    }
    public void display(){
        System.out.println("Done!!! afer Calculating We Have:");
        System.out.println("The largest Number that fits to f(x,y):"+posResults.get(posResults.size()-1));
        System.out.println("The Smallest Number that fits to f(x,y):"+negResults.get(0));
    }


}
































