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
import org.uphf.projetsae201.Controller.EventGUI;

public class GUIAcceuil extends GUIControl {
    private EventGUI eg;
    public GUIAcceuil(){

        this.eg = new EventGUI(this);

        Group root = new Group();

        // bouton pour commencer une partie
        Button commencer = new Button("Commencer une partie");
        commencer.setFont(new Font(15));

        // bouton pour fermer la fenêtre
        Button quitter = new Button("Quitter");
        quitter.setFont(new Font(15));

        // Titre du jeu
        Text text = new Text("Jeu de la mine");
        text.setStrokeWidth(2);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        VBox box = new VBox(text, commencer, quitter);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        // Image de fond
        Image fond = new Image(getClass().getResourceAsStream("/Images/FondAccueil.png"));
        BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));
        Background bg = new Background(backgroundImage);

        Scene scene = new Scene(box, 570,   320);
        box.setBackground(bg);
        box.getChildren().addAll(root);

        // changer l'icone du jeu
        this.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icone.png")));

        this.setTitle("Accueil");
        this.setScene(scene);
        this.setResizable(false);
        this.show();

        // Event des boutons
        commencer.setOnMouseClicked(eg);
        quitter.setOnMouseClicked(eg);

    }
}
