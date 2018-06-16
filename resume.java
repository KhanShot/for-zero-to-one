import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javafx.scene.image.Image;
import java.awt.Desktop;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class resume extends Application {
    private String url = "";
    private Desktop desktop = Desktop.getDesktop();
    public static void main(String[] args) {
        Application.launch(args);
    }
    ImageView imageView;
    @Override
    public void start(Stage primaryStage) {

        final GridPane[] gridPane = {new GridPane()};
        Scene scene = new Scene(gridPane[0],565,550);
        primaryStage.setTitle("Resume");
        primaryStage.setScene(scene);
        gridPane[0].setPadding(new Insets(35,35,30,45));
        primaryStage.show();
        gridPane[0].setVgap(10);
        gridPane[0].setHgap(10);

        Label resume = new Label("RESUME");
        resume.setUnderline(true);
        GridPane.setHalignment(resume, HPos.CENTER);
        gridPane[0].add(resume,1,0,2,1);
        Label name = new Label("Name: ");
        TextField namefield = new TextField();
        namefield.setPrefWidth(115);
        GridPane.setHalignment(name,HPos.LEFT);
        gridPane[0].add(name,0,1);

        GridPane.setHalignment(namefield,HPos.LEFT);
        gridPane[0].add(namefield, 1,1);

        Label skills = new Label("Skills ");
        GridPane.setHalignment(skills,HPos.LEFT);
        gridPane[0].add(skills,0,2);

        CheckBox java = new CheckBox("Java");
        CheckBox Python = new CheckBox("Python");
        CheckBox c = new CheckBox("C++");

        GridPane.setHalignment(java,HPos.CENTER);
        GridPane.setHalignment(Python, HPos.CENTER);
        GridPane.setHalignment(c,HPos.CENTER);
        gridPane[0].add(java,0,3);
        gridPane[0].add(Python,0,4);
        gridPane[0].add(c,0,5);

        Label gender = new Label("Gender");
        RadioButton male =new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup group = new ToggleGroup();
        male.setToggleGroup(group);
        female.setToggleGroup(group);

        GridPane.setHalignment(gender,HPos.CENTER);
        gridPane[0].add(gender,2,2);
        GridPane.setHalignment(male, HPos.CENTER);
        GridPane.setHalignment(female,HPos.CENTER);
        gridPane[0].add(male,2,3);
        gridPane[0].add(female,2,4);

        Label country = new Label("Country: ");
        GridPane.setHalignment(country,HPos.LEFT);
        gridPane[0].add(country,0,6);

        ComboBox<levels> comboBox = new ComboBox<>();
        ObservableList<levels> list = LevelsN.getLevellist();
        comboBox.setItems(list);
        comboBox.getSelectionModel().select(1);

        GridPane.setHalignment(comboBox, HPos.LEFT);
        gridPane[0].add(comboBox, 1,6);

        Button btn = new Button("OK");
        Button btn1 = new Button("Cancel");
        GridPane.setHalignment(btn,HPos.CENTER);
        GridPane.setHalignment(btn1,HPos.CENTER);

        gridPane[0].add(btn,2,8);
        gridPane[0].add(btn1, 3,8);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    primaryStage.close();
                }
        });
        final String[] ali = {""};
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BufferedWriter writer = null;
                try {
                    String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                    File file = new File(timeLog);
                    String name = namefield.getText();
                    String gender = "";
                    String skills = "";



                    if(male.isSelected())
                        gender = "Gender: male";
                    if(female.isSelected())
                        gender = "Gender: Female";

                    if(java.isSelected())
                        skills += "java";
                    if(Python.isSelected())
                        skills +=", Python";
                    if(c.isSelected())
                        skills += ", C++";

                    String country = "" + comboBox.getValue();




                    writer = new BufferedWriter(new FileWriter(file));
                    writer.write("Name: " + name+ "\nGender: " + gender +"\nSkills: " + skills + "\nCountry: " + country + "\nPhoto(url): " + Arrays.toString(ali));

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        writer.close();
                    } catch (Exception e) {}
                }
            }
        });
        Button choose = new Button("Choose");
        ImageView myimage = new ImageView();
        GridPane.setHalignment(choose, HPos.CENTER);
        gridPane[0].add(choose,4,4);

        choose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

                File file = fileChooser.showOpenDialog(null);

                try {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    Image image = SwingFXUtils.toFXImage(bufferedImage,null);
                    myimage.setFitWidth(150);
                    myimage.setFitHeight(170);

                    myimage.setImage(image);
                    ali[0] += file.getAbsolutePath()+ "\n";
                } catch (IOException e) {
                    Logger.getLogger(resume.class.getName()).log(Level.SEVERE, null, e);
                }

                GridPane.setHalignment(myimage,HPos.CENTER);
                gridPane[0].add(myimage,4,1);
            }
        });

    }
}
