/*  Histogram (Question 4)
    Group Members: Mayur Bhai and Nirojan Arunakirinathan

    This program will create a histogram based off of the occurrences of each
    letter in a text file. The program will ask the user to enter the name of
    a text file to check the letter occurrences and then click the view button
    to display the histogram.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.GridPane;




public class Histogram extends Application {

    @Override
    // Creates the Histogram
    public void start(Stage primaryStage) throws Exception {
        // Create a Grid Pane and set the alignment to be centered
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);


        // Creates a text field and label for Filename an adds it to the pane
        pane.add(new Label("Filename:"),0,1);
        TextField text1 = new TextField();
        text1.setMaxWidth(100);
        pane.setMinSize(50,50);
        pane.add(text1, 1,1);

        // Creates a button that when clicked, it will change the graph to the
        // txt file entered in the text field.
        Button view_button = new Button("View");
        pane.add(view_button, 2,1);
        GridPane.setHalignment(view_button, HPos.RIGHT);

        // Upon clicking the button, it will calculate the investment's
        // future value and output it into the "Future Value" text field
        view_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String filename = text1.getText();

                // Calls the CheckOccurrences Function to compute the occurrences of
                // each letter in a text.
                int[] OccurrenceArray = new int[0];
                try {
                    OccurrenceArray = CheckOccurrences(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                // Create a primary stage called Histogram
                primaryStage.setTitle("Histogram");

                // Set the x and y axis and label it
                CategoryAxis x_axis = new CategoryAxis();
                x_axis.setLabel("Letters");
                NumberAxis y_axis = new NumberAxis();
                y_axis.setLabel("Occurrences");

                // In order to create a histogram, we are converting a bar graph to a
                // histogram graph
                BarChart HistogramGraph = new BarChart(x_axis, y_axis);

                // Remove spaces, legend, gaps and background lines to create histogram
                // from a bar graph
                HistogramGraph.setBarGap(0);
                HistogramGraph.setCategoryGap(0);
                HistogramGraph.setLegendVisible(false);
                HistogramGraph.setTitle("Letter Occurrences Histogram");


                // Begin to create the letter category and store the occurrences of each
                // letter into a variable called occurrence_data
                XYChart.Series occurrence_data = new XYChart.Series();
                for (int i=0;i<26;i++) {
                    occurrence_data.getData().add(new XYChart.Data(Character.toString((char)(65+i)), OccurrenceArray[i]));
                }

                // Add the occurrence data to the Histogram graph
                HistogramGraph.getData().add(occurrence_data);

                // Add Histogram to pane.
                pane.add(HistogramGraph,0,0);

            }
        });

        // Creates a scene to add all the content in a window and sets primary
        // stage. Also sets the height and width of stage.
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(700);
        primaryStage.setTitle("Histogram");
        primaryStage.show();
    }

//
//    public static void main(String[] args) throws FileNotFoundException {
//        int[] array = CheckOccurrences();
//
//    }

    // This function counts the number of occurrences for each letter and stores
    // it into an array. It takes in the filename as a parameter to access it.
    public static int[] CheckOccurrences (String file_name) throws FileNotFoundException {
        // Open a file and create a input scanner
        File filename = new File(file_name);
        Scanner scInput = new Scanner(filename);

        // Set an array for all the letters of the alphabet
        int letterOccurrenceArray[] = new int[26];

        // Continue to loop over each word till there is no lines left
        while (scInput.hasNextLine()) {
            // Store each word into a temporary cell called text_input
            String text_input = scInput.next();
            // Capitalize all the letters
            text_input = text_input.toUpperCase();

            // Create a character array that splits each word into separate letters
            char charArray[] = text_input.toCharArray();

            // Loop over the letters of the word with each alphabet and if they
            // match, then it stores it into the letterOccurrenceArray inorder
            // to keep track of the occurrences
            for (int i=0;i<text_input.length();i++) { // Each word loop
                for (int j = 0; j < 26; j++) {        // 26 alphabet loop
                    if (charArray[i] == 65 + j)       // checks if they match
                        letterOccurrenceArray[j] += 1; // count + 1
                }
            }
        }

        // Close input scanner
        scInput.close();
        // Return the int array
        return letterOccurrenceArray;
    }
}

