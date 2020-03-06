// By: Mayur Bhai & Nirojan Arunakirinathan

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Random;

public class Question1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        String [] card = cardSelector();

        Pane pane = new HBox(10 );
        Image card1 = new Image(card[0]);
        ImageView viewCard1 = new ImageView(card1);
        pane.getChildren().add(viewCard1);

        Image card2 = new Image(card[1]);
        ImageView viewCard2 = new ImageView(card2);
        pane.getChildren().add(viewCard2);

        Image card3 = new Image(card[2]);
        ImageView viewCard3 = new ImageView(card3);
        pane.getChildren().add(viewCard3);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // Function randomly selects cards
    public static String[] cardSelector(){
        Random rand = new Random();
        String [] card = new String[3];
        card[0] = ("/Cards/" + Integer.toString(rand.nextInt(55) + 1) + ".png").toString();
        card[1] = ("/Cards/" + Integer.toString(rand.nextInt(55) + 1) + ".png").toString();
        card[2] = ("/Cards/" + Integer.toString(rand.nextInt(55) + 1) + ".png").toString();
        return (card);
    }
}
