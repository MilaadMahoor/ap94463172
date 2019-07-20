import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

public class Managment {
    private  String username;
    private  String password;

    private String fname,lname,email;
    private String personalID;
    WriteFile writeFile;

    {
        try {
            writeFile = new WriteFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Managment(String username, String personalID) throws FileNotFoundException, UnsupportedEncodingException {
        this.username = username;
        this.personalID = personalID;
    }

    public String getUsername() {
        return username;
    }

    public String getPersonalID() {
        return personalID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setFname(String fname) {
        this.fname = fname;
    }



    public void setLname(String lname) {
        this.lname = lname;
    }



    public void setEmail(String email) {
        this.email = email;
    }


    public Course makeCourse(Set<Course>courses,Set<ClassRoom> classRooms,Set<Master> masters){
        final Course[] course = new Course[1];
        Stage stage = new Stage();
        stage.setTitle("Make a Course");
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Scene scene = new Scene(pane,300,300);
        Label coursnameLable = new Label("Course Name:");
        TextField nametextField = new TextField();
        nametextField.setPromptText("Course Name");
        Label valueLable = new Label("Value:");
        TextField valuetextField = new TextField();
        valuetextField.setPromptText("value in number");
        ChoiceBox<Master> masterChoiceBox = new ChoiceBox<>();
        Label masterLable = new Label("Select Master:");
        for (Master m:masters
             ) {
            masterChoiceBox.getItems().add(m);
        }
        Label classLable = new Label("Select a ClassRoom:");
        ChoiceBox<ClassRoom> classRoomChoiceBox = new ChoiceBox<>();
        for (ClassRoom c: classRooms
             ) {
            classRoomChoiceBox.getItems().add(c);
        }
        Button setButt = new Button("Set");
        Button backButt = new Button("Back");
        pane.getChildren().addAll(coursnameLable,nametextField,valueLable,valuetextField,masterChoiceBox,masterLable,classLable,classRoomChoiceBox,setButt,backButt);
        setButt.setOnAction(event -> {
            int value = Integer.parseInt(valuetextField.getText());
            course[0] = new Course(nametextField.getText(),value);
            course[0].setClassRoom(classRoomChoiceBox.getValue());
            course[0].setCourseTeacher(masterChoiceBox.getValue());
            courses.add(course[0]);

        });
        backButt.setOnAction(event -> stage.close());
        GridPane.setConstraints(coursnameLable,0,0);
        GridPane.setConstraints(valueLable,0,2);
        GridPane.setConstraints(masterLable,0,4);
        GridPane.setConstraints(classLable,0,6);

        GridPane.setConstraints(nametextField,4,0);
        GridPane.setConstraints(valuetextField,4,2);
        GridPane.setConstraints(masterChoiceBox,4,4);
        GridPane.setConstraints(classRoomChoiceBox,4,6);

        GridPane.setConstraints(setButt,0,10);
        GridPane.setConstraints(backButt,4,10);

        stage.setScene(scene);
        stage.show();






        return course[0];
    }

    public void seeClassnStudentInfo(Set<Course> courses){
        Utilities.showCorses(courses);

    }

    public void hireMaster(Set<Master> masters){

        Stage stage = new Stage();
        stage.setTitle("Hire A Master");
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Scene scene = new Scene(pane,300,300);

        Label fnameLable = new Label("Master First Name:");
        Label lnameLable = new Label("Master Last Name:");
        Label emailLable = new Label("Master Email:");
        Label teachingLable = new Label("Master Teaching ID:");
        Label usernameLable = new Label("Master Username:");
        Label passLable = new Label("Master password:");

        TextField ftextField = new TextField();
        TextField lnametextField = new TextField();
        TextField emailtextField = new TextField();
        TextField teachingtextField = new TextField();
        TextField usertextField = new TextField();
        TextField passtextField = new TextField();

        ftextField.setPromptText("First name");
        lnametextField.setPromptText("Last name");
        emailtextField.setPromptText("Email");
        teachingtextField.setPromptText("Teaching ID");
        usertextField.setPromptText("Username");
        passtextField.setPromptText("Password");

        Button setButt = new Button("Set");
        Button back = new Button("Back");

        setButt.setOnAction(event -> {
            Master master = new Master(usertextField.getText(),teachingtextField.getText());
            master.setFname(ftextField.getText());
            master.setLname(lnametextField.getText());
            master.setEmail(emailtextField.getText());
            master.setPassword(passtextField.getText());
            masters.add(master);
            try {
                writeFile.writeMaster(master,masters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        back.setOnAction(event -> stage.close());

        GridPane.setConstraints(fnameLable,0,0);
        GridPane.setConstraints(lnameLable,0,1);
        GridPane.setConstraints(emailLable,0,2);
        GridPane.setConstraints(teachingLable,0,3);
        GridPane.setConstraints(usernameLable,0,4);
        GridPane.setConstraints(passLable,0,5);
        GridPane.setConstraints(ftextField,3,0);
        GridPane.setConstraints(lnametextField,3,1);
        GridPane.setConstraints(emailtextField,3,2);
        GridPane.setConstraints(teachingtextField,3,3);
        GridPane.setConstraints(usertextField,3,4);
        GridPane.setConstraints(passtextField,3,5);
        GridPane.setConstraints(setButt,0,8);
        GridPane.setConstraints(back,3,8);

        pane.getChildren().addAll(fnameLable,lnameLable,emailLable,teachingLable,usernameLable,passLable
        ,ftextField,lnametextField,emailtextField,teachingtextField,usertextField,passtextField,setButt,back);

        stage.setScene(scene);
        stage.show();




    }



    public void acceptStudents(Set<Student> students){
        Stage stage = new Stage();
        stage.setTitle("Accept A Student");
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Scene scene = new Scene(pane,300,300);

        Label fnameLable = new Label("Student First Name:");
        Label lnameLable = new Label("Student Last Name:");
        Label emailLable = new Label("Student Email:");
        Label studyLable = new Label("Student ID:");
        Label usernameLable = new Label("Student Username:");
        Label passLable = new Label("Student password:");

        TextField ftextField = new TextField();
        TextField lnametextField = new TextField();
        TextField emailtextField = new TextField();
        TextField studytextField = new TextField();
        TextField usertextField = new TextField();
        TextField passtextField = new TextField();

        ftextField.setPromptText("First name");
        lnametextField.setPromptText("Last name");
        emailtextField.setPromptText("Email");
        studytextField.setPromptText("Student ID");
        usertextField.setPromptText("Username");
        passtextField.setPromptText("Password");

        Button setButt = new Button("Set");
        Button back = new Button("Back");

        setButt.setOnAction(event -> {
            Student student = new Student(usertextField.getText(),studytextField.getText());
            student.setFname(ftextField.getText());
            student.setLname(lnametextField.getText());
            student.setEmail(emailtextField.getText());
            student.setPassword(passtextField.getText());
            students.add(student);
            try {
                writeFile.writeStudent(student,students);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        back.setOnAction(event -> stage.close());


        GridPane.setConstraints(fnameLable,0,0);
        GridPane.setConstraints(lnameLable,0,1);
        GridPane.setConstraints(emailLable,0,2);
        GridPane.setConstraints(studyLable,0,3);
        GridPane.setConstraints(usernameLable,0,4);
        GridPane.setConstraints(passLable,0,5);
        GridPane.setConstraints(ftextField,3,0);
        GridPane.setConstraints(lnametextField,3,1);
        GridPane.setConstraints(emailtextField,3,2);
        GridPane.setConstraints(studytextField,3,3);
        GridPane.setConstraints(usertextField,3,4);
        GridPane.setConstraints(passtextField,3,5);
        GridPane.setConstraints(setButt,0,8);
        GridPane.setConstraints(back,3,8);

        pane.getChildren().addAll(fnameLable,lnameLable,emailLable,studyLable,usernameLable,passLable
                ,ftextField,lnametextField,emailtextField,studytextField,usertextField,passtextField,setButt,back);

        stage.setScene(scene);
        stage.show();



    }
}
