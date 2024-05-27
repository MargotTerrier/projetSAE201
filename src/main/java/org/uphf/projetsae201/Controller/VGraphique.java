package org.uphf.projetsae201.Controller;

import org.uphf.projetsae201.Model.*;
import org.uphf.projetsae201.View.GUI;

import java.util.Random;

public class VGraphique {
    private GUI gui;
    private Monde m;
    private EventGUI eg;
    private String[] mouvement;

    public VGraphique() {
        this.m = new Monde(2, new Random().nextInt(2, 5), 10, 10);
        gui = new GUI(m);
        this.mouvement = new String[this.m.getNbRobot()];
        this.eg = new EventGUI(this);


    }

    public GUI getGUI() {
        return gui;
    }
    public Monde getMonde(){
        return this.m;
    }

    public void actualise(int i , String mouve){
        boolean depl = true;
        this.mouvement[i] = mouve;

        for (String verif : this.mouvement){
            if (verif==null){
                depl=false;
            }
        }

        if (depl){
            int index=0;
            for (Robot d : this.m.getRobots()){

                m.deplacerRobot(this.mouvement[index],((Terrain) m.getLstSecteur()[d.getCoordonneesX()][d.getCoordonneesY()]));
                index += 1;
            }

        }
        else {
            gui.Affiche(eg);
        }



    }











}
