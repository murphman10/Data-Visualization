/**
 * Data Visualization Project
 * Developed by: Asa Murphy
 * Date: 11/26/2020
 *
 * README
 * This program takes user input from an array and then displays it on a line graph. The technologies used to develop
 * this are Java and JavaFX. I have included comment lines to explain what each JavaFX component represents and it's
 * action in the working code.
 */

package com.graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Scanner;

public class LineGraph extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        int size = 6; // represents the data collected from the past 6 months
        int[] arr = new int[size]; //used to store user input

        System.out.println("Enter the data to be displayed on the graph\n");

        Scanner s = new Scanner(System.in); //Initialization and action of receiving user input.
        for(int i = 0; i < size; i++) {

            arr[i] = s.nextInt();
        }

        HBox root = new HBox(); //Layout component which positions all its child nodes (components) in a horizontal row.
        Scene scene = new Scene(root, 450, 330);  //Contains all the visual JavaFX GUI components inside it.

        CategoryAxis xAxis = new CategoryAxis(); //Implementation that works on string categories where each value as a unique category(tick mark) along the axis.
        xAxis.setLabel("Months");

        NumberAxis yAxis = new NumberAxis(); //A axis class that plots a range of numbers with major tick marks every "tickUnit".
        yAxis.setLabel("Jobs Applied");

        //Displays information as a series of data points. In this case, it will display strings along the x-axis and numbers along the y-axis. (formation of graph).
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Jobs Applied in the Last 6 Months");

        XYChart.Series<String, Number> data = new XYChart.Series<>(); //Responsible for drawing the two axes and the plot content. (formation of data on graph).
        data.getData().add(new XYChart.Data<String, Number>("Jul", arr[0]));
        data.getData().add(new XYChart.Data<String, Number>("Aug", arr[1]));
        data.getData().add(new XYChart.Data<String, Number>("Sep", arr[2]));
        data.getData().add(new XYChart.Data<String, Number>("Oct", arr[3]));
        data.getData().add(new XYChart.Data<String, Number>("Nov", arr[4]));
        data.getData().add(new XYChart.Data<String, Number>("Dec", arr[5]));
        data.setName("Jobs");

        lineChart.getData().add(data); //sets data onto line chart.
        root.getChildren().add(lineChart); //Obtains the nodes, in this case the line chart.

        primaryStage.setTitle("Data Visualization on Applied Jobs"); //displayed on GUI window
        primaryStage.setScene(scene); //Specify the scene to be used on this stage.
        primaryStage.show(); //Attempts to show this Window by setting visibility to true.
    }

    public static void main(String[] args) {

        launch(args);
    }
}