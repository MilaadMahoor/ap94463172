import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;


public class Institude extends Application {


    Set<Course>courses = new HashSet<>();
    Set<Master> masters = new HashSet<>();
    Set<Student> students = new HashSet<>();
    Set<ClassRoom> classRooms = new HashSet<>();
    Managment managment;
    Student student;
    Master master;



    Scene scene;



    public static void main(String[] args)  {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            managment= new Managment("admin","1111");
            managment.setFname("Ali");
            managment.setLname("Hakimi");
            managment.setEmail("managment@gmail.com");
            managment.setPassword("admin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        setdefualtInfo(students,classRooms,masters,courses);









      // scene = new Scene(studentForm(student,primaryStage),300,300);
       scene =new Scene(managmentForm(managment,primaryStage,classRooms),300,300);
      // scene = new Scene(masterForm(master,primaryStage),300,300);
      //  scene = new Scene(loginForm(primaryStage),300,300);
        primaryStage.setScene(scene);
        primaryStage.show();






    }



    //////forms///////////
    public GridPane studentForm(Student student,Stage stage){
        stage.setTitle("Student Control Panel");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Button button= new Button("Remove a Course");
        Button button2= new Button("Assign a Course");
        Button button3= new Button("See All Available Courses");
        Button button4= new Button("See Your Own Courses");
        Button button5 = new Button("logout");

        button.setOnAction(event -> student.remCorses());
        button2.setOnAction(event -> {

                student.setCourses(courses);

        });
        button3.setOnAction(event -> Utilities.showCorse(courses));
        button4.setOnAction(event -> student.seeCourses());
        button5.setOnAction(event ->{
            stage.close();
            Stage stage1 = new Stage();

            Scene scene1 = new Scene(loginForm(stage1));
            stage1.setScene(scene1);
            stage1.show();
        } );
        GridPane.setConstraints(button,0,0);
        GridPane.setConstraints(button2,0,2);
        GridPane.setConstraints(button3,0,4);
        GridPane.setConstraints(button4,0,6);
        GridPane.setConstraints(button5,0,7);
        pane.getChildren().addAll(button,button2,button3,button4,button5);
        return pane;
    }

    public GridPane managmentForm(Managment managment,Stage stage,Set<ClassRoom>classRooms){
        stage.setTitle("Managment Control Panel");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Button button= new Button("Make a Course");
        Button button2= new Button("Hire a Master");
        Button button3= new Button("Accept a Student");
        Button button4= new Button("See All Courses ");
        Button button5 = new Button("logout");

        button.setOnAction(event -> {
            courses.add(managment.makeCourse(courses,classRooms,masters));

        });
        button2.setOnAction(event -> managment.hireMaster(masters));
        button3.setOnAction(event -> managment.acceptStudents(students));
        button4.setOnAction(event -> managment.seeClassnStudentInfo(courses));
        button5.setOnAction(event -> {
            stage.close();
            Stage stage1 = new Stage();

            Scene scene1 = new Scene(loginForm(stage1));
            stage1.setScene(scene1);
            stage1.show();
        });

        GridPane.setConstraints(button,0,0);
        GridPane.setConstraints(button2,0,2);
        GridPane.setConstraints(button3,0,4);
        GridPane.setConstraints(button4,0,6);
        GridPane.setConstraints(button5,0,7);
        pane.getChildren().addAll(button,button2,button3,button4,button5);

        return pane;
    }

    public GridPane masterForm(Master master,Stage stage){
        stage.setTitle("Master Control Panel");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));
        Button button= new Button("See your Classes");
        Button button2= new Button("Students for each class");
        Button button3= new Button("Remove a Student");
        Button button4= new Button("Set Grades");
        Button button5 = new Button("logout");


        button.setOnAction(event -> master.seeMastersClass());
        button2.setOnAction(event -> master.seeAllStudents());
        button3.setOnAction(event -> master.removeStdFromCourse());
        button4.setOnAction(event -> master.setGrade());
        button5.setOnAction(event -> {
            stage.close();
            Stage stage1 = new Stage();

            Scene scene1 = new Scene(loginForm(stage1));
            stage1.setScene(scene1);
            stage1.show();
        });



        GridPane.setConstraints(button,0,0);
        GridPane.setConstraints(button2,0,2);
        GridPane.setConstraints(button3,0,4);
        GridPane.setConstraints(button4,0,6);
        GridPane.setConstraints(button5,0,7);
        pane.getChildren().addAll(button,button2,button3,button4,button5);
        return pane;
    }


    public GridPane loginForm(Stage stage){

        stage.setTitle("Login ");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 1);


        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Master","Student","Managment");
        GridPane.setConstraints(choiceBox,0,0);


        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput, 2, 1);


        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);


        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 2, 2);


        Button loginButton = new Button("Log In");
        loginButton.setOnAction(event -> {


            ReadFile readFile = new ReadFile();
            try {
                String username = nameInput.getText();
                String password = passInput.getText();
              if(choiceBox.getValue().equalsIgnoreCase("Managment")){
                  Scene scene = new Scene(managmentForm(managment,stage,classRooms),300,300);
                  stage.setScene(scene);
                  stage.show();
              }
              else if(choiceBox.getValue().equalsIgnoreCase("Student")) {

                 Student student1 = readFile.loginStudent("userPass.txt",username,password,students);
                 Scene scene = new Scene(studentForm(student1,stage),300,300);
                 stage.setScene(scene);
                 stage.show();
              }
              else if(choiceBox.getValue().equalsIgnoreCase("Master"))
              {
                  Master master1 =readFile.loginMaster("userPass.txt",username,password,masters);
                  Scene scene = new Scene(masterForm(master1,stage),300,300);
                  stage.setScene(scene);
                  stage.show();
              }
            } catch (Exception e) {
                Label error = new Label("Invalid Username or Password");
                GridPane.setConstraints(error,1,4);
                grid.getChildren().add(error);
                grid.getChildren().remove(error);
            }
        });
        GridPane.setConstraints(loginButton, 1, 4);






        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton,choiceBox);

       ;
        return grid;
    }

    public void setdefualtInfo(Set<Student> students,Set<ClassRoom> classRooms,Set<Master> masters,Set<Course> courses){

        ClassRoom classRoom = new ClassRoom("101");
        ClassRoom classRoom2 = new ClassRoom("102");
        ClassRoom classRoom3 = new ClassRoom("103");
        ClassRoom classRoom4 = new ClassRoom("201");
        ClassRoom classRoom5 = new ClassRoom("202");
        ClassRoom classRoom6 = new ClassRoom("203");
        classRooms.add(classRoom);
        classRooms.add(classRoom2);
        classRooms.add(classRoom3);
        classRooms.add(classRoom4);
        classRooms.add(classRoom5);
        classRooms.add(classRoom6);

        Student student = new Student("hassan","987654");
        student.setLname("alipour");
        student.setFname("hassan");
        student.setEmail("hassanalipor@gmail.com");
        student.setPassword("hassan1234");
        students.add(student);

        Student student2 = new Student("mohammad","987455");
        student2.setLname("shafie");
        student2.setFname("mahommad");
        student2.setEmail("mohammadsh@gmail.com");
        student2.setPassword("mo1235");
        students.add(student2);

        Student student3 = new Student("narges","987154");
        student3.setLname("mohammadi");
        student3.setFname("narges");
        student3.setEmail("mohammadinarges@gmail.com");
        student3.setPassword("narges4444");
        students.add(student3);

        Student student4 = new Student("roya","987774");
        student4.setLname("nazari");
        student4.setFname("roya");
        student4.setEmail("nazariroyaa@gmail.com");
        student4.setPassword("rnazar876");
        students.add(student4);

        Student student5 = new Student("milad","985554");
        student5.setLname("mahoor");
        student5.setFname("milad");
        student5.setEmail("miladmahoor@gmail.com");
        student5.setPassword("987milad");
        students.add(student5);

        Student student6 = new Student("ahmad","987110");
        student6.setLname("bayat");
        student6.setFname("ahmad");
        student6.setEmail("ahmadbayat@gmail.com");
        student6.setPassword("bayat1444");
        students.add(student6);

        Student student7 = new Student("masoud","988888");
        student7.setLname("mohammadi");
        student7.setFname("masoud");
        student7.setEmail("masoud1234@gmail.com");
        student7.setPassword("masoud");
        students.add(student7);

        Student student8 = new Student("helia","987440");
        student8.setLname("rahmani");
        student8.setFname("helia");
        student8.setEmail("heliaaaaa@gmail.com");
        student8.setPassword("hl154");
        students.add(student8);

        Student student9 = new Student("omid","987726");
        student9.setLname("jalili");
        student9.setFname("omid");
        student9.setEmail("omidddjalili@gmail.com");
        student9.setPassword("omid154");
        students.add(student9);

        Student student10 = new Student("hooman","987523");
        student10.setLname("khatibi");
        student10.setFname("hooman");
        student10.setEmail("khatibi@gmail.com");
        student10.setPassword("tmx123");
        students.add(student10);

        Student student11 = new Student("navid","987368");
        student11.setLname("mousavi");
        student11.setFname("navid");
        student11.setEmail("mnavid@gmail.com");
        student11.setPassword("navid4466");
        students.add(student11);

        Student student12 = new Student("parisa","987555");
        student12.setLname("hasani");
        student12.setFname("parisa");
        student12.setEmail("phasani@gmail.com");
        student12.setPassword("parisaa");
        students.add(student12);

        Student student13 = new Student("ramin","987546");
        student13.setLname("hosseini");
        student13.setFname("ramin");
        student13.setEmail("ramin@gmail.com");
        student13.setPassword("rh1515");
        students.add(student13);

        Master master = new Master("master1","1234567");
        master.setFname("Hassani");
        master.setLname("Abbas");
        master.setEmail("master1@gmail.com");
        master.setPassword("ab1254");
        masters.add(master);
        Master master2 = new Master("master2","1234589");
        master2.setFname("Tufan");
        master2.setLname("Reza");
        master2.setEmail("tufan@gmail.com");
        master2.setPassword("t124");
        masters.add(master2);
        Master master3 = new Master("master3","1234145");
        master3.setFname("Nazari");
        master3.setLname("Sara");
        master3.setEmail("saramaster@gmail.com");
        master3.setPassword("pass1111");
        masters.add(master3);
        Master master4 = new Master("master4","1234888");
        master4.setFname("Rezaie");
        master4.setLname("Soheil");
        master4.setEmail("email.gmail.com");
        master4.setPassword("soh154");
        masters.add(master4);

        Course course = new Course("Electrical Circus",3);
        Course course2 = new Course("Math",2);
        Course course3 = new Course("Programming",3);
        Course course4 = new Course("Physics",3);
        Course course5 = new Course("Discrete Mathematics",3);
        Course course6 = new Course("DataBase Structure",3);
        course.setClassRoom(classRoom);
        course2.setClassRoom(classRoom2);
        course3.setClassRoom(classRoom4);
        course4.setClassRoom(classRoom5);
        course5.setClassRoom(classRoom);
        course6.setClassRoom(classRoom6);

        course.setCourseTeacher(master);
        course2.setCourseTeacher(master2);
        course3.setCourseTeacher(master);
        course4.setCourseTeacher(master4);
        course5.setCourseTeacher(master3);
        course6.setCourseTeacher(master2);

        courses.add(course);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);


















    }

}


