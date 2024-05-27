package org.uphf.projetsae201.Controller;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
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
            Circle c =new Circle(100);
            gui.setScene(new Scene(new Group(c)));
            gui.show();
        }
        else {

        }


    }











}
