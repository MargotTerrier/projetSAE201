package org.uphf.projetsae201.View;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GUIChoix {
    /* Création de la fenêtre du choix de mode d'affichage */
    public GUIChoix(){
        Group gui = new Group();

        // bouton pour lancer le jeu en mode console
        Button console = new Button("Console");
        console.setFont(new Font(15));

        //  pour lancer le jeu en mode graphique
        Button graphique = new Button("Graphique");
        graphique.setFont(new Font(15));

        // bouton pour fermer la fenêtre
        Button quitter2 = new Button("Quitter");
        quitter2.setFont(new Font(15));

        Text text = new Text("Choisissez le mode d'affichage :");
        text.setStrokeWidth(2);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        VBox box = new VBox(text, console, graphique, quitter2);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        // Image de fond
        Image fond = new Image(getClass().getResourceAsStream("/Images/FondAccueil.png"));
        BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));
        Background bg = new Background(backgroundImage);

        Scene scene = new Scene(box, 570,   320);
        box.setBackground(bg);
        box.getChildren().addAll(gui);

        // changer l'icone du jeu
        this.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icone.png")));

        this.setTitle("Choix du mode");
        this.setScene(scene);
        this.setResizable(false);
        this.show();

        // Event des boutons
        graphique.setOnMouseClicked(eg);
        console.setOnMouseClicked(eg);
        quitter2.setOnMouseClicked(eg);
    }
}
