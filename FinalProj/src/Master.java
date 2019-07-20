import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Master {

    private  String username;
    private  String password;

    private String fname,lname,email;
    private String teachingID;
    Set<Course> mastersCourses = new HashSet<>();


    public Master(String username, String teachingID) {
        this.username = username;
        this.teachingID = teachingID;
    }




    //Setters And Getters
    public String getUsername() {
        return username;
    }
    public String getTeachingID() {
        return teachingID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Course> getMastersCourses() {
        return mastersCourses;
    }
    public void setMastersCourses(Course c) {
        mastersCourses.add(c);
    }

    public void removeStdFromCourse(){
        Button button = new Button("Remove");
        Button button1 = new Button("Back");
        Stage stage = new Stage();
        stage.setTitle("Remove a student");
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Scene scene = new Scene(pane,300,300);
        ChoiceBox<Student> studentChoiceBox = new ChoiceBox<>();
        for (Course c:mastersCourses
             ) {
            for (Student s: c.getStudents()
                 ) {
                studentChoiceBox.getItems().add(s);
            }
        }


        Label label2 = new Label("select your Student");



        GridPane.setConstraints(label2,0,2);
        GridPane.setConstraints(studentChoiceBox,2,2);
        GridPane.setConstraints(button,0,4);
        GridPane.setConstraints(button1,2,4);

        button.setOnAction(event -> {
            studentChoiceBox.getValue().remCorses();
        });
        button1.setOnAction(event -> stage.close());

        pane.getChildren().addAll(label2,studentChoiceBox,button,button1);
        stage.setScene(scene);
        stage.show();

    }




    public void seeMastersClass(){
        Utilities.showCorses(mastersCourses);
    }

    public void setGrade(){

        Stage stage = new Stage();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane,300,300);

        Label choiceboxLabel = new Label("Select your Course and Student:");
        ChoiceBox<Course> courseChoiceBox = new ChoiceBox<>();
        for (Course c:mastersCourses
             ) {
            courseChoiceBox.getItems().add(c);
        }
        ChoiceBox<Student> studentChoiceBox = new ChoiceBox<>();

        Label gradeLabel = new Label("Set Grade");
        GridPane.setConstraints(gradeLabel,0,2);
        TextField textField = new TextField();
        textField.setPromptText("0-20");

        Button setButt = new Button("Set");
        setButt.setOnAction(event -> {
            int x = Integer.parseInt(textField.getText());
            System.out.println(x);
            studentChoiceBox.getValue().setGrade(x);
        });
        GridPane.setConstraints(setButt,0,5);
        Button setStd = new Button("Students");
        setStd.setOnAction(event -> {
            for (Student s: courseChoiceBox.getValue().getStudents()
                    ) {
                studentChoiceBox.getItems().add(s);
            }
        });
        GridPane.setConstraints(setStd,0,4);

        Button back = new Button("back");
        back.setOnAction(event -> stage.close());
        GridPane.setConstraints(back,2,5);


        GridPane.setConstraints(textField,2,2);
        GridPane.setConstraints(choiceboxLabel,0,0);
        GridPane.setConstraints(courseChoiceBox,2,0);
        GridPane.setConstraints(studentChoiceBox,6,0);
        gridPane.getChildren().addAll(choiceboxLabel,courseChoiceBox,studentChoiceBox,gradeLabel,textField,setButt,back,setStd);
        stage.setScene(scene);
        stage.show();

    }


    public void seeAllStudents(){
        Utilities.seeAllStudents(mastersCourses);
    }


    public void sCourse(Set<Course>courses){
        this.mastersCourses=courses;
    }



    //Equals and Tostring And Hashcode
    @Override
    public String toString() {
        return fname + "\t" +lname + '\t' + teachingID + '\t' +username+ '\t' +password+ '\t' +email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return Objects.equals(username, master.username) &&
                Objects.equals(teachingID, master.teachingID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, teachingID);
    }
}
