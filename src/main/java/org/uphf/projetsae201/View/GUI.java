package org.uphf.projetsae201.View;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.uphf.projetsae201.Controller.EventGUI;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.Model.PlanDeau;
import org.uphf.projetsae201.Model.Secteur;

public class GUI extends Stage{

    public GUI(){

        Group root = new Group();

        Button commencer = new Button("Commencer une partie");
        commencer.setFont(new Font(15));

        Button quitter = new Button("Quitter");
        quitter.setFont(new Font(15));


        Text text = new Text("Jeu de la mine");
        text.setFont(new Font(20));

        VBox box = new VBox(text, commencer, quitter);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        Image fond = new Image("https://i.etsystatic.com/18279207/r/il/0baebc/5022632129/il_570xN.5022632129_kwst.jpg");

        BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));

        Background bg = new Background(backgroundImage);

        Scene scene = new Scene(box, 535,   300);
        box.setBackground(bg);
        box.getChildren().addAll(root);
        this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlXw-Np3cMZ4kj518EfxS3uKmiZ6Wx6tbHvJ2CJRBVxA&s"));
        this.setTitle("Acceuil");
        this.setScene(scene);
        this.setResizable(false);
        this.show();

        commencer.setOnMouseClicked(new EventGUI(this));
        quitter.setOnMouseClicked(new EventGUI(this));

    }

    public void gui(){
        Group gui = new Group();

        Button console = new Button("Console");
        console.setFont(new Font(15));
        Button graphique = new Button("Graphique");
        graphique.setFont(new Font(15));
        Button quitter2 = new Button("Quitter");
        quitter2.setFont(new Font(15));

        Text text = new Text("Choisissez le mode d'affichage :");
        text.setFont(new Font(20));

        VBox box = new VBox(text, console, graphique, quitter2);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        Image fond = new Image("https://i.etsystatic.com/18279207/r/il/0baebc/5022632129/il_570xN.5022632129_kwst.jpg");

        BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));

        Background bg = new Background(backgroundImage);

        Scene scene = new Scene(box, 535,   300);
        box.setBackground(bg);
        box.getChildren().addAll(gui);
        this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlXw-Np3cMZ4kj518EfxS3uKmiZ6Wx6tbHvJ2CJRBVxA&s"));
        this.setTitle("Choix du mode");
        this.setScene(scene);
        this.setResizable(false);
        this.show();

        graphique.setOnMouseClicked(new EventGUI(this));
        console.setOnMouseClicked(new EventGUI(this));
        quitter2.setOnMouseClicked(new EventGUI(this));
    }

    public void monde(){
        Group g = new Group();
        Scene scene = new Scene(g, 1440, 811);

        Button quit = new Button("Quitter le jeu");
        quit.setLayoutX(10);
        quit.setLayoutY(10);
        quit.setFont(new Font(15));

        Button redemarrer = new Button("Redémarrer une partie");
        redemarrer.setLayoutX(140);
        redemarrer.setLayoutY(10);
        redemarrer.setFont(new Font(15));

        Label tour = new Label("Tour ");
        tour.setLayoutY(10);
        tour.layoutXProperty().bind(scene.widthProperty().subtract(tour.prefWidth(-1)).divide(2.1));
        tour.setFont(new Font(30));


        g.getChildren().addAll(quit, redemarrer, tour);
        this.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlXw-Np3cMZ4kj518EfxS3uKmiZ6Wx6tbHvJ2CJRBVxA&s"));
        this.setTitle("Jeu de la mine");
        this.setScene(scene);
        this.show();

        quit.setOnMouseClicked(new EventGUI(this));
        redemarrer.setOnMouseClicked(new EventGUI(this));

    }

    public void mondeconsole(){

        Monde m = new Monde(5,5,10,10);
//        System.out.println(m);
        Secteur a= new PlanDeau();
//        System.out.println(a);
        new AffichageConsole(m);

    }

}
