// By: Mayur Bhai & Nirojan Arunakirinathan

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Question3 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(200,200, 100, Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);

        double[] initialAngles = {((double)Math.random()*360),((double)Math.random()*360),((double)Math.random()*360)};

        // X-coordinates for the draggable points
        double[] x = {(circle.getCenterX()+circle.getRadius()*Math.cos(Math.toRadians(initialAngles[0]))),
                      (circle.getCenterX()+circle.getRadius()*Math.cos(Math.toRadians(initialAngles[1]))),
                      (circle.getCenterX()+circle.getRadius()*Math.cos(Math.toRadians(initialAngles[2])))};
        // Y-coordinates for the draggable points
        double[] y = {(circle.getCenterY()+circle.getRadius()*Math.sin(Math.toRadians(initialAngles[0]))),
                      (circle.getCenterY()+circle.getRadius()*Math.sin(Math.toRadians(initialAngles[1]))),
                      (circle.getCenterY()+circle.getRadius()*Math.sin(Math.toRadians(initialAngles[2])))};

        // Places the coordinates initially on random parts of the circumference of the circle
        Circle[] coordinates = {(new Circle(x[0],y[0],7, Color.RED)),(new Circle(x[1],y[1],7, Color.RED)),
                            (new Circle(x[2],y[2],7, Color.RED))};

        // Lines connecting the vertices to form the triangle
        Line[] edges = {(new Line(coordinates[0].getCenterX(),coordinates[0].getCenterY(),coordinates[1].getCenterX(),
                                coordinates[1].getCenterY())),
                        (new Line(coordinates[1].getCenterX(),coordinates[1].getCenterY(),coordinates[2].getCenterX(),
                                coordinates[2].getCenterY())),
                        (new Line(coordinates[2].getCenterX(),coordinates[2].getCenterY(),coordinates[0].getCenterX(),
                                coordinates[0].getCenterY()))};

        Text[] angles = calculateAngle(edges);

        // Function regulates the mouse movement
        mouseMovement(coordinates, circle, edges, angles);
        
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        pane.getChildren().addAll(edges);
        pane.getChildren().addAll(coordinates);
        pane.getChildren().addAll(angles);
        moveedges(edges, coordinates, angles);
        stage.setScene(new Scene(pane,400,400));
        stage.show();
    }

    /* The calculateAngle function below determines the length of each edge of the triangle and uses it to calculate
        the corresponding angles */
    public Text[] calculateAngle(Line[] edges){
        double[] length = new double[3];
        for (int i = 0; i < edges.length;i++){
            length[i] = Math.sqrt(Math.pow(edges[i].getEndX()-edges[i].getStartX(),2) +
                    Math.pow(edges[i].getEndY()-edges[i].getStartY(),2));
        }

        Text[] angles = new Text[3];
        angles[0] = new Text(Integer.toString((int) Math.toDegrees(Math.acos((length[0]*length[0] - length[1]*length[1] -
                length[2]*length[2])/(-2*length[1]*length[2])))));
        angles[1] = new Text(Integer.toString((int) Math.toDegrees(Math.acos((length[1]*length[1] - length[0]*length[0] -
                length[2]*length[2])/(-2*length[0]*length[2])))));
        angles[2] = new Text(Integer.toString((int) Math.toDegrees(Math.acos((length[2]*length[2] - length[1]*length[1] -
                length[0]*length[0])/(-2*length[0]*length[1])))));
        return(angles);
    }

    /*The function below consists of three mouse event handler, one being for each vertice of the triangle*/
    public void mouseMovement (Circle[] coordinates, Circle circle,Line[] edges,Text[] angles){
        coordinates[0].setOnMouseDragged(m->{
            double angle = Math.atan2(m.getY()-circle.getCenterY(),m.getX()-circle.getCenterX());
            coordinates[0].setCenterX(circle.getCenterX()+circle.getRadius()*Math.cos(angle));
            coordinates[0].setCenterY(circle.getCenterY()+circle.getRadius()*Math.sin(angle));
            moveedges(edges, coordinates, angles);
        });
        coordinates[1].setOnMouseDragged(m->{
            double angle = Math.atan2(m.getY()-circle.getCenterY(),m.getX()-circle.getCenterX());
            coordinates[1].setCenterX(circle.getCenterX()+circle.getRadius()*Math.cos(angle));
            coordinates[1].setCenterY(circle.getCenterY()+circle.getRadius()*Math.sin(angle));
            moveedges(edges, coordinates,angles);
        });
        coordinates[2].setOnMouseDragged(m->{
            double angle = Math.atan2(-circle.getCenterY() + m.getY(),-circle.getCenterX() + m.getX());
            coordinates[2].setCenterX(circle.getRadius() * Math.cos(angle) + circle.getCenterX());
            coordinates[2].setCenterY(circle.getRadius() * Math.sin(angle) + circle.getCenterY());
            moveedges(edges, coordinates,angles);
        });

    }
    /*The moveedges function determines the location of the moved vertice and moves the corresponding edges*/
    private void moveedges(Line[] edges,Circle[] coordinates,Text[] angles) {
        for (int i = 0; i < edges.length; i++) {
            edges[i].setStartX(coordinates[i].getCenterX());
            edges[i].setStartY(coordinates[i].getCenterY());

            /* The conditional statement is used so that if the edge being moved is the one connected by vertex 1 and 3
               the array indexing doesn't go out of bounds and so vertex 3 is connected back to vertex 1*/
            if(i==2){
                edges[i].setEndX(coordinates[0].getCenterX());
                edges[i].setEndY(coordinates[0].getCenterY());
            } else {
                edges[i].setEndX(coordinates[i+1].getCenterX());
                edges[i].setEndY(coordinates[i+1].getCenterY());
            }
            calculateAngle(edges);
            angles[i].setX(coordinates[i].getCenterX()+ 5);
            angles[i].setY(coordinates[i].getCenterY()+ 20);
        }
    }
}






