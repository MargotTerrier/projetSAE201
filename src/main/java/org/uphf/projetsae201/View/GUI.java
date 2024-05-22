package org.uphf.projetsae201.View;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;

public class GUI extends Stage{

    public GUI(Monde m ){

    }

    public GUI(){
        Group g = new Group();
        Scene scene = new Scene(g, 1440, 811);

        Button quit = new Button("Quitter le jeu");
        quit.setLayoutX(10);
        quit.setLayoutY(10);
        quit.setFont(new Font("Arial", 15));

        Button redemarrer = new Button("Redémarrer une partie");
        redemarrer.setLayoutX(140);
        redemarrer.setLayoutY(10);
        redemarrer.setFont(new Font("Arial", 15));

        Label tour = new Label("Tour ");
        tour.setLayoutY(10);
        tour.layoutXProperty().bind(scene.widthProperty().subtract(tour.prefWidth(-1)).divide(2.1));
        tour.setFont(new Font("Arial", 30));


        g.getChildren().addAll(quit, redemarrer, tour);
        this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlXw-Np3cMZ4kj518EfxS3uKmiZ6Wx6tbHvJ2CJRBVxA&s"));
        this.setTitle("Jeu de la mine");
        this.setScene(scene);
        this.show();

    }
}
