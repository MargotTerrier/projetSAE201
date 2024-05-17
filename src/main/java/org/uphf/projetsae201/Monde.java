package org.uphf.projetsae201;


import java.util.ArrayList;
import java.util.Random;

public class Monde {
    private int nbTerrains;
    private int nbMines;
    private int nbEntrepots;
    private int compteurTour;
    private int nbRobot;
    private int nbPlanEau;
    private int longueurMonde;
    private int largeurMonde;


    private Secteur[][] lstSecteur;





    public Monde( int nbEntrepots, int nbRobot, int longueurMonde, int largeurMonde) {

        this.nbEntrepots = nbEntrepots;
        this.compteurTour =0;
        this.nbRobot = nbRobot;
        this.longueurMonde = longueurMonde;
        this.largeurMonde = largeurMonde;

        // le nb de terrains represente au moins 90% +- 10%
        this.nbTerrains = (int) (0.9*(this.largeurMonde*this.longueurMonde) + new Random(1).nextInt((int) (this.largeurMonde*this.longueurMonde*0.1))-1);

        // Mme Lepreux nous a dit au moins un plans d'eau.
        this.nbPlanEau = 1 + this.largeurMonde*this.longueurMonde+this.nbTerrains;

        // au moins une mine d'or et une mine de nickel
        this.nbMines = 2+ new Random(0).nextInt(2);

        //on crée un tableau car on connait le nombre de case et c'est fixe
        this.lstSecteur = new Secteur[this.longueurMonde][this.largeurMonde];
        creationMonde();
    }

    public int getCompteurTour() {
        return this.compteurTour;
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
        Integer l; //longueur
        Integer L; //Largeur
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pas; //secteur deja choisi
        for (int x = 0; x < this.nbPlanEau;) {
            l = new Random(0).nextInt(this.longueurMonde);
            L = new Random(0).nextInt(this.largeurMonde);
            temp.add(l);
            temp.add(L);
            if (!(pas.contains(temp)){
                pas.add(temp);
                this.lstSecteur[temp[0]][temp[1]] = new Terrain();


            }


        }


    }






}
