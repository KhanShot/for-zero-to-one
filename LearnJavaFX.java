import  java.util.Date;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.*;

public class LearnJavaFX extends Application{
    public static void main(Button args) {
        Application.launch(String.valueOf(args));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //SCENE
        GridPane gridPane = new GridPane();
        primaryStage.setTitle("JavaFX from Khan_Shot");
        Scene scene = new Scene(gridPane,350,250);
        primaryStage.setScene(scene);
        primaryStage.show();
        gridPane.setPadding(new Insets(35,35,30,45));
        gridPane.setHgap(20);
        gridPane.setVgap(15);

        // labelset and textset
        Label labeltitle = new Label("Enter your name ");
        gridPane.add(labeltitle,0,0,2,1);

        Label labeluser = new Label("Username:");
        TextField fielduser = new TextField();

        Button login = new Button("Enter");
        //ADDING BUTTONS AND LABEL
        GridPane.setHalignment(labeluser, HPos.RIGHT);
        gridPane.add(labeluser,0,1);
        GridPane.setHalignment(fielduser,HPos.LEFT);
        gridPane.add(fielduser,1,1);

        GridPane.setHalignment(login, HPos.RIGHT);
        gridPane.add(login,1,3);

        //CHOOSE LEVEL
        ComboBox<levels> comboBox = new ComboBox<>();
        ObservableList<levels> list = LevelsN.getLevellist();
        comboBox.setItems(list);
        comboBox.getSelectionModel().select(1);

        GridPane.setHalignment(comboBox, HPos.LEFT);
        gridPane.add(comboBox, 0,3);

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GridPane second = new GridPane();
                Scene secondScene = new Scene(second,400,400);
                Stage newWindow = new Stage();
                newWindow.setTitle("Sudoku");
                newWindow.setScene(secondScene);
                newWindow.show();




                TextField t1 = new TextField();
                t1.setPrefWidth(23);
                TextField t2 = new TextField();
                t2.setPrefWidth(23);
                TextField t3 = new TextField();
                t3.setPrefWidth(23);

                GridPane.setHalignment(t1,HPos.CENTER);
                second.add(t1,1,2);
                GridPane.setHalignment(t1,HPos.LEFT);
                second.add(t1,2,3);
                GridPane.setHalignment(t1,HPos.RIGHT);
                second.add(t1,3,4);

            }
        });

    }
}

