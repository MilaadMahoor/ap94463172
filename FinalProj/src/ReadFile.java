import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ReadFile {
    public ReadFile() {
    }

    public boolean loginRead(String filename,String username,String password) throws IOException {
        boolean value =false;

        String content = new String(Files.readAllBytes(Paths.get(filename)));



        StringTokenizer st = new StringTokenizer(content," ");
        while (st.hasMoreTokens()){
            if(username.equalsIgnoreCase(st.nextToken())){
                String pass= st.nextToken();
                if(pass.equalsIgnoreCase(password)){
                    value=true;
                    break;
                }

            }
            else {
                value=false;
            }

        }

        return value;
    }

    public Student loginStudent(String filename, String username, String password, Set<Student> students) {



        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));

        } catch (IOException e) {
            e.printStackTrace();
        }


        StringTokenizer st = new StringTokenizer(content, " ");
        String user = null;
        String pass = null;

        while (st.hasMoreTokens()) {
            if (st.nextToken().equalsIgnoreCase("1")) {
                user = st.nextToken();
                if (user.equalsIgnoreCase(username)) {
                    pass = st.nextToken();
                    if (pass.equalsIgnoreCase(password)) {
                        break;
                    }

                }
            }
        }


          String usernam = new String();
         String passwor= new String();

         String fname= new String();
         String lname= new String();
         String email= new String();;
         String studentID= new String();;
        Set<Course> courses = new HashSet<>();


        for (Student s : students) {
            if (user.equalsIgnoreCase(s.getUsername()) && pass.equalsIgnoreCase(s.getPassword())) {
                usernam= s.getUsername();
                passwor=s.getPassword();
               fname=s.getFname();
                lname=s.getLname();
              email= s.getEmail();
              courses=s.getCourses();
                studentID=s.getStudentID();

            }

        }

        Student student = new Student(usernam,studentID);
        student.setFname(fname);
        student.setLname(lname);
        student.setEmail(email);
        student.sCourses(courses);
        student.setPassword(passwor);

        return student;
    }
    public Master loginMaster(String filename, String username, String password, Set<Master> masters) {



        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));

        } catch (IOException e) {
            e.printStackTrace();
        }


        StringTokenizer st = new StringTokenizer(content, " ");
        String user = null;
        String pass = null;

        while (st.hasMoreTokens()) {
            if (st.nextToken().equalsIgnoreCase("2")) {
                user = st.nextToken();

                if (user.equalsIgnoreCase(username)) {

                    pass = st.nextToken();

                    if (pass.equalsIgnoreCase(password)) {
                        break;
                    }

                }
            }
        }


        String usernam = new String();
        String passwor= new String();

        String fname= new String();
        String lname= new String();
        String email= new String();;
        String teachID= new String();;
        Set<Course> courses = new HashSet<>();


        for (Master m:masters) {
            if (user.equalsIgnoreCase(m.getUsername()) && pass.equalsIgnoreCase(m.getPassword())) {
                usernam= m.getUsername();
                passwor=m.getPassword();
                fname=m.getFname();
                lname=m.getLname();
                email= m.getEmail();
                courses=m.getMastersCourses();
                teachID=m.getTeachingID();

            }

        }

        Master master = new Master(usernam,passwor);
        master.setFname(fname);
        master.setLname(lname);
        master.setEmail(email);
        master.sCourse(courses);
        master.setPassword(passwor);


        return master;
    }

















    }


