
/* This program is for
  Advanvaned Programming Course 972 ZNU
  Assignment 4
  98/01/27
  Milad Zolfkhani
  94463172
 */


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix {

    public int row, column;
    public int i, j;


    public Scanner sc = new Scanner(System.in);


    public Matrix() {

        System.out.println("Please set Matrix ROWs:");
        row = sc.nextInt();
        System.out.println("Please set Matrix COLUMNs:");
        column = sc.nextInt();


    }


    public void genrate() {

        int arry[][] = new int[row][column];
            for (i = 0; i < row; i++) {
                 for (j = 0; j < column; j++) {
                     int randomNumber = ThreadLocalRandom.current().nextInt(0, 101);
                     arry[i][j] = randomNumber;

                        if (j == column - 1) {
                              System.out.print(arry[i][j]);
                              System.out.println();
                        } else {
                                System.out.print(arry[i][j] + "     ");
                }


            }


        }
        System.out.println("Please set a row for ordering:( rows number starts at 0):");
        int k = sc.nextInt();


            {
                for(j=0;j<column-1;j++){
                    for(int c=0;c<column-1;c++){
                        i=k;
                        if (arry[i][c]>arry[i][c+1]){
                                int temp = arry[i][c];
                            arry[i][c]=arry[i][c+1];
                            arry[i][c+1]=temp;
                        }
                    }
                }
            }
                     System.out.println("Ordering row number "+k+" ............" );
                 for (i = 0; i < row; i++) {
                     for (j = 0; j < column; j++) {
                       if (j == column - 1) {
                           System.out.print(arry[i][j]);
                           System.out.println();

                        } else {
                           System.out.print(arry[i][j] + "     ");
                         }

                     }




                 }

                     System.out.println("This Command only gives order to your selected row of Matrix");



            }





































 }


