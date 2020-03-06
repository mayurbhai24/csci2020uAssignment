/*  Investment Value Calculator (Question 2)
    Group Members: Mayur Bhai and Nirojan Arunakirinathan

    This program will create an user interactive calculator that calculates the
    future value of an investment. The user must enter the initial investment
    amount/principal, the amount of years the investment will be kept for, and
    the annual interest rate of the investment. Once all three of the fields is
    filled out, the program will calculate the future value of the investment.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.DecimalFormat;


public class InvestmentValueCalculator extends Application {

    // A decimal formatter that rounds a number to two decimal places
    private static DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a Grid Pane and set the alignment to be centered
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        // Set the Padding and vertical and horizontal gaps
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(5);
        pane.setHgap(5);

        // Creates a text field and label for Investment Amount/Principal and
        // adds it to the pane
        pane.add(new Label("Investment Amount"),0,0);
        TextField text1 = new TextField();
        pane.add(text1, 1,0);

        // Creates a text field and label for Years and adds it to the pane
        pane.add(new Label("Years"), 0,1);
        TextField text2 = new TextField();
        pane.add(text2, 1,1);

        // Creates a text field and label for Annual Interest Rate and adds it
        // to the pane
        pane.add(new Label("Annual Interest Rate"), 0 , 2);
        TextField text3 = new TextField();
        pane.add(text3, 1 ,2);

        // Creates a non-editable text field and label for Future Value and
        // adds it to the pane. This is a read only text field
        pane.add(new Label("Future Value"),0,3);
        TextField text4 = new TextField();
        text4.setEditable(false);
        pane.add(text4, 1 ,3);

        // Creates a "Calculate" button, adds it to the pane and positions
        // it on the right side
        Button calculate_button = new Button("Calculate");
        pane.add(calculate_button, 1,6);
        GridPane.setHalignment(calculate_button, HPos.RIGHT);

        // Upon clicking the button, it will calculate the investment's
        // future value and output it into the "Future Value" text field
        calculate_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Stores the investment amount, years and annual interest rate
                // from the test fields to there respective variables. In order
                // to be used in the formula, it must be changed from string to
                // double.
                double investment_amount = Double.parseDouble(text1.getText());
                double years = Double.parseDouble(text2.getText());
                double annual_interest_rate = (Double.parseDouble(text3.getText()))/100;
                // Computes the monthly interest rate
                double monthly_interest_rate = annual_interest_rate/12;
                // Future investment value formula
                double future_value = investment_amount * Math.pow((1 + monthly_interest_rate),(years*12));
                // Format the future value to two decimal places.
                String future_value_string = df.format(future_value);

                // Outputs the calculated future value to the empty text field
                text4.setText(future_value_string);

            }
        });

        // Creates a scene to add all the content in a window and sets primary
        // stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Investment-Value Calculator");
        primaryStage.show();
    }
}
