package org.uphf.projetsae201.Controller;

import org.uphf.projetsae201.Model.*;
import org.uphf.projetsae201.View.GUI;

import java.util.ArrayList;
import java.util.Random;

import static javafx.application.Application.launch;

public class VGraphique {
    private GUI gui;
    private Monde m;
    public VGraphique() {
        this.m =new Monde(2   ,new Random().nextInt(2,5),10,10);
        launch();
    }
    public void launch(){
        gui.monde(this.m);
        boolean Fin=false;
        while(!Fin){
            ArrayList<Robot>robots=m.getRobots();
            ArrayList<Mine>mine=m.getMines();
            ArrayList< Entrepot>entrepot=m.getEntrepots();
        }

    }










}
