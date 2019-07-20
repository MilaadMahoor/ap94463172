/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 8
  98/02/22
  Milad Zolfkhani
  94463172
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentWriter {
    public Scanner sc = new Scanner(System.in);





    public StudentWriter() {

    }

    public ArrayList<Student> generate(){

        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Set n numbers");
        int n = sc.nextInt();
        String command;
        System.out.println("if you want to sign a Graduated Student type 1" +
                "\n if you want to sign a Studing Student type 2" +
                "\n if you want to exit type exit");

        for (int i = 0; i < n ; i++) {


            command = sc.next();
            switch (command){
                case "1": {
                    System.out.print("name: \t");
                    String fname = sc.next();
                    System.out.print("last name: \t");
                    String lname = sc.next();
                    System.out.print("Student Id: \t");
                    int stId = sc.nextInt();
                    System.out.print("graduationYear: \t");
                    int graduationYear = sc.nextInt();
                    Student student = new GraduatedStudent(1,fname,lname,stId,graduationYear);
                    students.add(student);
                    System.out.println("Done!");
                    break;
                }
                case "2": {
                    System.out.print("name: \t");
                    String fname = sc.next();
                    System.out.print("last name: \t");
                    String lname = sc.next();
                    System.out.print("Student Id: \t");
                    int stId = sc.nextInt();
                    System.out.print("Expended Units: \t");
                    int expendedUnits = sc.nextInt();
                    Student student = new StudingStudent(2,fname,lname,stId,expendedUnits);
                    students.add(student);
                    System.out.println("Done!");
                    break;
                }
                case "exit":{
                    return students;
                }
                default:{
                    System.out.println("invalid Command");
                    i= i-1;
                    break;
                }



            }



        }


        return students;
    }
}
