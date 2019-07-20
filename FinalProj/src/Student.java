import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {

    private  String username;
    private  String password;

    private String fname,lname,email;
    private String studentID;
    private Set<Course> courses = new HashSet<>();
    private int grade;

    public Student(String username, String studentID) {
        this.username = username;
        this.studentID = studentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(username, student.username) &&
                Objects.equals(studentID, student.studentID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, studentID);
    }

    public String getUsername() {
        return username;
    }

    public String getStudentID() {
        return studentID;
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void sCourses(Set<Course> courses){
        this.courses= courses;
    }


    public void setCourses(Set<Course> allCourses){
        Button button = new Button("Add");
        Button button1 = new Button("Back");
        Stage stage = new Stage();
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Scene scene = new Scene(pane,300,300);
        Label label = new Label("select your course");
        ChoiceBox<Course> courseChoiceBox = new ChoiceBox<>();
        for (Course c:allCourses
             ) {

            courseChoiceBox.getItems().add(c);
        }


        pane.getChildren().addAll(label,courseChoiceBox,button,button1);
        GridPane.setConstraints(label,0,0);
        GridPane.setConstraints(courseChoiceBox,0,1);
        GridPane.setConstraints(button,0,3);
        GridPane.setConstraints(button1,0,10);
        stage.setScene(scene);
        stage.show();
        button.setOnAction(event -> {

            courseChoiceBox.getValue().setStudent(this);
            courseChoiceBox.getValue().getClassRoom().changeSize(1);
            courses.add(courseChoiceBox.getValue());
            Button seecorses = new Button("See your Courses");
            GridPane.setConstraints(seecorses,0,4);
            pane.getChildren().addAll(seecorses);
            seecorses.setOnAction(event1 -> Utilities.showCorses(courses));
        });
        button1.setOnAction(event -> stage.close());
    }

    public void remCorses(){
       Button button = new Button("Remove");
       Button button1 = new Button("Back");
        Stage stage = new Stage();
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Scene scene = new Scene(pane,400,300);
        Label label = new Label("Select your course:");
        ChoiceBox<Course> courseChoiceBox = new ChoiceBox<>();
        for (Course c:courses
                ) {
            courseChoiceBox.getItems().add(c);
        }


        pane.getChildren().addAll(label,courseChoiceBox,button,button1);
        GridPane.setConstraints(label,0,0);
        GridPane.setConstraints(courseChoiceBox,0,1);
        GridPane.setConstraints(button,4,0);
        GridPane.setConstraints(button1,0,10);
        stage.setScene(scene);
        stage.show();
       button.setOnAction(event -> {

          courseChoiceBox.getValue().remStudent(this);
          courseChoiceBox.getValue().getClassRoom().changeSize(-1);
          courses.remove(courseChoiceBox.getValue());


           Button seecorses = new Button("See your Courses:");
           GridPane.setConstraints(seecorses,0,4);
           pane.getChildren().addAll(seecorses);
           seecorses.setOnAction(event1 -> Utilities.showCorses(courses));




       });
       button1.setOnAction(event -> stage.close());

    }

    @Override
    public String toString() {
        return fname+"\t"+lname+"\t"+studentID;
    }

    public void seeCoursesnname(Set<Course>courses){
        Button button = new Button("See");
        Button button1 = new Button("Back");
        Stage stage = new Stage();
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Scene scene = new Scene(pane,300,300);
        Label label = new Label("See All Availble Courses:");



        pane.getChildren().addAll(label,button,button1);
        GridPane.setConstraints(label,0,0);

        GridPane.setConstraints(button,0,3);
        GridPane.setConstraints(button1,0,10);
        stage.setScene(scene);
        stage.show();
        button.setOnAction(event -> {

            int i =1;
                for (Course c:courses
                        ) {

                    Text text = new Text();
                    text.setText(c.getCoureName()+c.getCourseTeacher()+c.getValue()+c.getClassRoom().toString());
                    GridPane.setConstraints(text,1,i);
                    i++;
                }


        });
        button1.setOnAction(event -> stage.close());

    }

    public void seeCourses(){
        Stage stage = new Stage();
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));

        Scene scene = new Scene(pane,300,300);
        stage.setTitle("See Courses");
        Button button = new Button("Back");
        ChoiceBox<Course> courseChoiceBox = new ChoiceBox<>();
        GridPane.setConstraints(courseChoiceBox,2,0);

        for (Course c:courses
                ) {

            courseChoiceBox.getItems().add(c);

        }
        Button button1 = new Button("See Info");
        button1.setOnAction(event -> {
            Stage stage1 = new Stage();
            GridPane gridPane = new GridPane();
            Scene scene1 = new Scene(gridPane);
            String info = courseChoiceBox.getValue().getCoureName()+"\n"+
                    courseChoiceBox.getValue().getValue()+"\n"+
                    courseChoiceBox.getValue().getClassRoom().toString()+"\n"+
                    courseChoiceBox.getValue().getCourseTeacher().toString()+"\n"+
                    this.grade;

            Text text = new Text();
            text.setText(info);
            GridPane.setConstraints(text,1,1);
            Button button3 = new Button("back");
            button3.setOnAction(event1 -> stage1.close());
            gridPane.getChildren().addAll(text,button3);
            stage1.setScene(scene1);
            stage1.show();

        });
        GridPane.setConstraints(button1,0,3);
        GridPane.setConstraints(button,0,0);
        pane.getChildren().addAll(button,button1,courseChoiceBox);
        stage.setScene(scene);
        stage.show();

        button.setOnAction(event -> stage.close());
    }

}
