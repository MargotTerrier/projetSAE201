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

        this.nbEntrepots = nbEntrepots;
        this.compteurTour =0;
        this.nbRobot = nbRobot;
        this.longueurMonde = longueurMonde;
        this.largeurMonde = largeurMonde;
        creationMonde();
    }

    public int getNbTerrains() {
        return nbTerrains;
    }

    public int getNbMines() {
        return nbMines;
    }

    public int getNbEntrepots() {
        return nbEntrepots;
    }

    public int getNbRobot() {
        return nbRobot;
    }

    public int getNbPlantEau() {
        return nbPlantEau;
    }

    public int getLongueurMonde() {
        return longueurMonde;
    }

    public int getLargeurMonde() {
        return largeurMonde;
    }

    public void creationMonde() {

        // le nb de terrains represente au moins 90% +- 10%
        this.nbTerrains = (int) (0.9*(this.largeurMonde*this.longueurMonde) + new Random(1).nextInt((int) (this.largeurMonde*this.longueurMonde*0.1))-1);

        // Mme Lepreux nous a dit au moins un plans d'eau.
        this.nbPlantEau = 1 + this.largeurMonde*this.longueurMonde+this.nbTerrains;

        // au moins une mine d'or et une mine de nickel
        this.nbMines = 2+ new Random(0).nextInt(2);

    }


}
