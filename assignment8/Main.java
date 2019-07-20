/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 8
  98/02/22
  Milad Zolfkhani
  94463172
 */

import java.io.File;
import java.util.ArrayList;


public class Main {

    static File file = new File("Students.txt");

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        StudentWriter studentWriter = new StudentWriter();
        FileSaver fileSaver = new FileSaver();
        FileRead fileRead = new FileRead();

        ArrayList<Student> students = studentWriter.generate();
        fileSaver.Save(students);
        System.out.println("File Saved");
        fileRead.read(stringBuffer);
        System.out.println(stringBuffer.toString());









    }
}
