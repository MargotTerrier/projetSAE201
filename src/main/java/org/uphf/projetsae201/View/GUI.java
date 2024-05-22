package org.uphf.projetsae201.View;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;

public class GUI extends Stage{

    public GUI(){

        Group root = new Group();

        Button commencer = new Button("Commencer une partie");
        commencer.setFont(new Font("Arial", 15));

        Button quitter = new Button("Quitter");
        quitter.setFont(new Font("Arial", 15));


        Text text = new Text("Jeu de la mine");
        text.setFont(new Font("Arial", 20));

        VBox box = new VBox(text, commencer, quitter);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.setLayoutY(-20);


        Scene scene = new Scene(box, 300, 400);
        box.getChildren().addAll(root);
        this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlXw-Np3cMZ4kj518EfxS3uKmiZ6Wx6tbHvJ2CJRBVxA&s"));
        this.setTitle("Jeu de la mine");
        this.setScene(scene);
        this.show();

    }

    public void gui(){
        Group gui = new Group();

        Button console = new Button("Console");
        console.setFont(new Font("Arial", 15));
        Button graphique = new Button("Graphique");
        graphique.setFont(new Font("Arial", 15));
        Button quitter2 = new Button("Quitter");
        quitter2.setFont(new Font("Arial", 15));

        Text text2 = new Text("Choisissez le mode d'affichage :");
        text2.setFont(new Font("Arial", 20));

        VBox box2 = new VBox(text2, console, graphique, quitter2);
        box2.setAlignment(Pos.CENTER);
        box2.setSpacing(10);
        box2.setLayoutY(-20);


        Scene scene2 = new Scene(box2, 300, 400);
        box2.getChildren().addAll(gui);
        this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlXw-Np3cMZ4kj518EfxS3uKmiZ6Wx6tbHvJ2CJRBVxA&s"));
        this.setTitle("Jeu de la mine");
        this.setScene(scene2);
        this.show();
    }

    public GUI(Monde m){
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
