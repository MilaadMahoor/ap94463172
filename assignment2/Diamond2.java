package assignment2;

import java.util.Scanner;

public class Diamond2 {


        Scanner sc = new Scanner(System.in);

        int row;
        int diff=0;

        public Diamond2(){
            System.out.println("Please choose an odd number for n:");
            row = sc.nextInt();

        }

        public void draw() {

            int midRow = (row+1)/2;

            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < row + 1; j++) {
                    if (((midRow - diff) <= j && (j <= midRow + diff))) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                }
                System.out.println();
                if (i < midRow) {
                    diff++;
                } else {
                    diff--;
                }
            }

        }


    }



