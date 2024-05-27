package org.uphf.projetsae201.Controller;

import org.uphf.projetsae201.Model.*;
import org.uphf.projetsae201.View.GUI;

import java.util.ArrayList;
import java.util.Random;

import static javafx.application.Application.launch;

public class VGraphique {
    private GUI gui;
    private Monde m;
    private EventGUI eg;
    public VGraphique(EventGUI eg) {
        this.m =new Monde(2   ,new Random().nextInt(2,5),10,10);
        this.gui = new GUI(eg);
        launch();
    }

    public GUI getGUI() {
        return gui;
    }
    public Monde getMonde(){
        return this.m;
    }
    public EventGUI getEventGUI(){
        return this.eg;
    }

    public void launch(){
        gui.monde(this.m);
        boolean Fin=false;
        while(!Fin){
            boolean Valider = false;
            ArrayList<Robot>robots=m.getRobots();
            ArrayList<Mine>mine=m.getMines();
            ArrayList< Entrepot>entrepot=m.getEntrepots();
            while(!Valider){






            }
        }

    }










}
