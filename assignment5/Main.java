/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 5
  98/01/31
  Milad Zolfkhani
  94463172
 */

public class Main {
    public static void main(String[] args) {
        long  startTimer = System.currentTimeMillis();
        Sub s1 = new Sub();
        s1.varsSetter();
        s1.display();
        System.out.println((System.currentTimeMillis()-startTimer)+" ms");
    }
}
