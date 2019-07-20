import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

public class Utilities {

    public Utilities() {
    }

    public static void showCorses(Set<Course> courses){
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
            String info="";
            try {
                 info = courseChoiceBox.getValue().getCoureName()+"\n"+
                        courseChoiceBox.getValue().getValue()+"\n"+
                        courseChoiceBox.getValue().getClassRoom().toString()+"\n"+
                        courseChoiceBox.getValue().getCourseTeacher().toString()+"\n"+
                        courseChoiceBox.getValue().getStudents().toString();
            }
            catch (NullPointerException e){

            }

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
    public static void showCorse(Set<Course> courses){
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
                    courseChoiceBox.getValue().getClassRoom().toString()+"\n";

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


    public static void seeAllStudents(Set<Course> courses){
        Stage stage = new Stage();
        Pane pane = new GridPane();
        pane.setPadding(new Insets(50,50,50,50));

        Scene scene = new Scene(pane,300,300);
        stage.setTitle("See Students");
        Button button = new Button("Back");
        int i =1;

        for (Course c:courses
                ) {

            Text text = new Text();
            text.setText(c.toString()+c.getStudents().toString());
            GridPane.setConstraints(text,1,i);
            pane.getChildren().add(text);
            i++;


        }
        GridPane.setConstraints(button,0,0);
        pane.getChildren().add(button);
        stage.setScene(scene);
        stage.show();

        button.setOnAction(event -> stage.close());

    }
}
