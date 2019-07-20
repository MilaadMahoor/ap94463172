/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 8
  98/02/22
  Milad Zolfkhani
  94463172
 */


import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {


    public FileSaver(){

    }
    public void Save(ArrayList<Student> students){
        try {

            FileWriter fileWriter = new FileWriter(Main.file);
            fileWriter.write(students.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
