package assignment1;

public class Diamond {


        int row=7;
        int midRow = (row+1)/2;

        int diff=0;

        public Diamond(){
        }

        public void draw() {
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
