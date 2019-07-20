import java.io.*;
import java.util.ArrayList;
import java.util.Set;

public class WriteFile {

    File userpass = new File("userPass.txt");


    public WriteFile() throws IOException {
        if(userpass.exists()==false){
            userpass.createNewFile();
        }
    }


    public void writeStudent(Student student, Set<Student>students) throws IOException {


        PrintWriter d = new PrintWriter(new FileWriter(userpass,true));

        d.append("1"+" "+student.getUsername()+" "+student.getPassword()+" ");
        d.close();
        students.add(student);

    }
    public void writeMaster(Master master,Set<Master> masters) throws IOException {


        PrintWriter d = new PrintWriter(new FileWriter(userpass,true));
        d.append("2"+" "+master.getUsername()+" "+master.getPassword()+" ");
        d.close();
        masters.add(master);


    }



}
