package org.uphf.projetsae201.Controller;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.uphf.projetsae201.Model.*;
import org.uphf.projetsae201.View.GUI;

import java.util.Random;

public class VGraphique {
    private int nbTour;
    private GUI gui;
    private Monde m;
    private EventGUI eg;
    private int cpt;


    public VGraphique() {

        this.m = new Monde(2, new Random().nextInt(2, 5), 10, 10);
        this.m.getRobots().get(0).resetRobot();
        for (Mine m : m.getMines()){
            m.setNbMinerais(0);
        }
        gui = new GUI(m);
        this.eg = new EventGUI(this);



    }

    public GUI getGUI() {
        return gui;
    }
    public Monde getMonde(){
        return this.m;
    }

    public void actualise(){


        if(getMonde().verifFin()){

            this.eg = new EventGUI(this);

            Text fin = new Text("Fin de la partie");
            fin.setStrokeWidth(2);
            fin.setStroke(Color.WHITE);
            fin.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

            Button ok = new Button("Ok");

            Image fond = new Image(getClass().getResourceAsStream("/Images/FondAccueil.png"));
            BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));
            Background bg = new Background(backgroundImage);
            VBox g = new VBox();
            g.getChildren().addAll(fin, ok);
            g.setAlignment(Pos.CENTER);
            g.setSpacing(10);
            g.setBackground(bg);

            gui.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icone.png")));
            gui.setTitle("Fin");
            gui.setScene(new Scene(g, 570,   320));
            gui.centerOnScreen();
            gui.show();

            ok.setOnMouseClicked(eg);

        }


    }











}
