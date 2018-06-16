import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class images extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 550, 450);
        primaryStage.setTitle("Resume");
        primaryStage.setScene(scene);
        gridPane.setPadding(new Insets(35, 35, 30, 45));
        primaryStage.show();
        gridPane.setVgap(20);
        gridPane.setHgap(15);

        Label resume = new Label("RESUME");
        resume.setUnderline(true);
        GridPane.setHalignment(resume, HPos.CENTER);
        gridPane.add(resume, 1, 0, 2, 1);
        Label name = new Label("Name: ");
        TextField namefield = new TextField();
        namefield.setPrefWidth(115);
        GridPane.setHalignment(name, HPos.LEFT);
        gridPane.add(name, 0, 1);

        GridPane.setHalignment(namefield, HPos.LEFT);
        gridPane.add(namefield, 1, 1);

        Label skills = new Label("Skills ");
        GridPane.setHalignment(skills, HPos.LEFT);
        gridPane.add(skills, 0, 2);

        CheckBox java = new CheckBox("Java");
        CheckBox Python = new CheckBox("Python");
        CheckBox c = new CheckBox("C++");

        GridPane.setHalignment(java, HPos.CENTER);
        GridPane.setHalignment(Python, HPos.CENTER);
        GridPane.setHalignment(c, HPos.CENTER);
        gridPane.add(java, 0, 3);
        gridPane.add(Python, 0, 4);
        gridPane.add(c, 0, 5);

        Label gender = new Label("Gender");
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup group = new ToggleGroup();
        male.setToggleGroup(group);
        female.setToggleGroup(group);

        GridPane.setHalignment(gender, HPos.CENTER);
        gridPane.add(gender, 2, 2);
        GridPane.setHalignment(male, HPos.CENTER);
        GridPane.setHalignment(female, HPos.CENTER);
        gridPane.add(male, 2, 3);
        gridPane.add(female, 2, 4);

        Label country = new Label("Country: ");
        GridPane.setHalignment(country, HPos.LEFT);
        gridPane.add(country, 0, 6);

        ComboBox<levels> comboBox = new ComboBox<>();
        ObservableList<levels> list = LevelsN.getLevellist();
        comboBox.setItems(list);
        comboBox.getSelectionModel().select(1);

        GridPane.setHalignment(comboBox, HPos.LEFT);
        gridPane.add(comboBox, 1, 6);

        Button btn = new Button("OK");
        Button btn1 = new Button("Cancel");
        GridPane.setHalignment(btn, HPos.CENTER);
        GridPane.setHalignment(btn1, HPos.CENTER);

        gridPane.add(btn, 2, 8);
        gridPane.add(btn1, 3, 8);


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                System.out.println("Name: "+namefield.getText());

                if(male.isSelected())
                    System.out.println("Gender: male");
                if(female.isSelected())
                    System.out.println("Gender: Female");

                String ska = "";
                if(java.isSelected())
                    ska += "java";
                if(Python.isSelected())
                    ska +=", Python";
                if(c.isSelected())
                    ska += ", C++";
                System.out.println("Skills:"+ ska);
                System.out.println("Country: "+ comboBox.getValue());

            }
        });



    }
}