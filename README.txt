CSCI2020U - Software System Development and Integration Assignment

The purpose of this assignment was to test and apply our knowledge of java, javafx, and UI development. Four exercises
were assigned that all revolved around UI development. First exercise required us to display three regular cards on a frame. The three cards
displayed are distinct and randomly selected. The second exercise required us to create a calculator that calculates the investment value
given the initial principal, the amount of years for the investment and the annual interest rate. The third question requires us to create 
a circle where three random dots on the circles can be dragged around to display a triangle and its angle. The fourth question requires us 
to create a histogram that shows the occurrences of each letter i a test file. 

Prerequisites
In order to run the programs, you must have Java JDK 13 and JavaFX 13. The following versions were used: jdk-13.0.1 and javafx-sdk-13.0.2.
You must set up VM options if using IntelliJ to run the programs.

Installing
First download the files from GitHub using the following link: https://github.com/mayurbhai24/csci2020uAssignment.git

If using IntelliJ, you must set up VM options. In order to do this, do the following:
1. Under the "Run" tab, click "Edit Configurations..."
2. Under Application, select the four program files and copy and paste the following code where it says "VM options:
	--module-path "%Folder Path%\javafx-sdk-13.0.2\lib" --add-modules javafx.controls,javafx.fxml
3. Replace "%Folder Path%" with the path of the folder where your javafx is located.
4. Click apply and ok.

After completing this step, the run time environment should be set up to compile and run the code.

To run and compile the codes, if using IntelliJ, you can use the shortcut, Alt+Shift+F10, or the run button at the top of the IDE.

Built With
IntelliJ - Java IDE used to generate UI windows

Authors
Mayur Bhai
Nirojan Arunakirinathan
