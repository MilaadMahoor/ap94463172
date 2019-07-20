
/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 3
  98/01/23
  Milad Zolfkhani
  94463172
 */


import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix {

    public int n = 0;
    public int i, j;



    public  Scanner sc = new Scanner(System.in);


    public Matrix() {

        System.out.println("Please Select a number for n as your random Matrix columns ands rows:");
        n = sc.nextInt();



    }


    public void genrate() {
        int x = this.n;



        int arry[][] = new int[x][x];

        for (i = 0; i < x; i++) {
            for (j = 0; j < x; j++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
                arry[i][j] = randomNumber;

                if (j == x - 1) {
                    System.out.print(arry[i][j]);
                    System.out.println();

                } else {
                    System.out.print(arry[i][j] + "     ");
                }

            }


        }
        System.out.println("Th generated Matrix is in bound of (0,100)");
        System.out.println("and we have with diagnally order:");

        for (int k =0;k<n;k++){
            for(j=0;j<=k;j++){
                i = k-j;
                System.out.print(arry[j][i]+"   ");
            }

        }
        for(int k = n-2;k>=0;k--){
            for (j=0;j<=k;j++){
                i=k-j;
                System.out.print(arry[n-i-1][n-j-1]+"   ");
            }

        }











        }


















}






