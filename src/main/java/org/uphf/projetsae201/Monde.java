package org.uphf.projetsae201;


import java.util.Random;

public class Monde {
    int nbTerrains;
    int nbMines;
    int nbEntrepots;
    int compteurTour;
    int nbRobot;
    int nbPlantEau;
    int longueurMonde;
    int largeurMonde;

    public int getCompteurTour() {
        return this.compteurTour;
    }

    public Monde( int nbEntrepots, int nbRobot, int longueurMonde, int largeurMonde) {
        nbTerrains = nbTerrains;
        nbMines = nbMines;
        this.nbEntrepots = nbEntrepots;
        this.compteurTour =0;
        this.nbRobot = nbRobot;
        this.longueurMonde = longueurMonde;
        this.largeurMonde = largeurMonde;
        this.nbPlantEau = 90 + new Random(0).nextInt(this.largeurMonde*this.longueurMonde-90);

    }
}
