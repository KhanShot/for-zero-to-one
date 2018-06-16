import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PieChartSabak extends  Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Piechart scene
        PieChart pieChart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("Red", 0);
        PieChart.Data slice2 = new PieChart.Data("Yellow", 0);
        PieChart.Data slice3 = new PieChart.Data("Green", 0);


        //SCENE
        BorderPane borderPane = new BorderPane();
        GridPane gridPane  = new GridPane();
        borderPane.setPadding(new Insets(15,15,20,15));
        Scene scene  = new Scene(borderPane,750,400);
        primaryStage.setTitle("PieChart");
        primaryStage.setScene(scene);
        primaryStage.show();
        GridPane pane = new GridPane();

        gridPane.setHgap(15);
        gridPane.setVgap(20);
        Label hello = new Label("WELCOME");
        pane.add(hello,0,3);
        borderPane.setTop(pane);

        Label Lred  = new Label("Red");
        TextField red = new TextField();
        red.setMaxWidth(30);


        red.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Red changed from " + oldValue + " to " + newValue);
            slice1.setPieValue(Double.parseDouble(newValue));
            if(newValue.isEmpty())
                slice1.setPieValue(0);
        });


        Label Lyellow = new Label("Yellow");
        TextField yellow = new TextField();
        yellow.setMaxWidth(30);

        yellow.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Yellow changed from " + oldValue + " to " + newValue);
            slice2.setPieValue(Double.parseDouble(newValue));
        });
        Label Lgreen  = new Label("Green");
        TextField green  = new TextField();

        green.setMaxWidth(30);
        green.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Green changed from " + oldValue + " to " + newValue);
            slice3.setPieValue(Double.parseDouble(newValue));
        });


        gridPane.add(Lred,1,1);
        gridPane.add(red,2,1);
        gridPane.add(Lyellow,1,2);
        gridPane.add(yellow,2,2);
        gridPane.add(Lgreen,1,3);
        gridPane.add(green,2,3);


        borderPane.setLeft(gridPane);


        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        pieChart.setLegendSide(Side.LEFT);

        borderPane.setCenter(pieChart);

    }
}
