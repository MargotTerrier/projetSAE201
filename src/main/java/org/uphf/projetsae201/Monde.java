package org.uphf.projetsae201;


import java.util.ArrayList;
import java.util.Random;
import java.util.*;

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

        // le nb de terrains represente au moins 90% +- 10% -
        this.nbTerrains = (int) (0.9*(this.largeurMonde*this.longueurMonde))+new Random().nextInt((int) (0.1*(this.largeurMonde*this.longueurMonde)+1))-1;

        //System.out.println((int) (0.9*(this.largeurMonde*this.longueurMonde)+0.1*(0))-1);
        //System.out.println((int) (0.9*(this.largeurMonde*this.longueurMonde)+0.1*(this.largeurMonde*this.longueurMonde)-1));
        //System.out.println(this.nbTerrains);


        // Mme Lepreux nous a dit au moins un plans d'eau.
        this.nbPlanEau = 1 + this.largeurMonde*this.longueurMonde+this.nbTerrains;

        // au moins une mine d'or et une mine de nickel
        this.nbMines = 2+ new Random().nextInt(2);

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
        return nbPlanEau;
    }

    public int getLongueurMonde() {
        return longueurMonde;
    }

    public int getLargeurMonde() {
        return largeurMonde;
    }

    public void creationMonde() {
        int l; //longueur
        int L; //Largeur

        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> pas = new ArrayList<ArrayList<Integer>>(5) ; //secteur deja choisi

        System.out.println(this.longueurMonde);


        for (int x = 0; x < this.nbPlanEau;) {

            l = new Random().nextInt(this.longueurMonde);
            L = new Random().nextInt(this.largeurMonde);

            temp.add(l);
            temp.add(L);

            if (!(pas.contains(temp))){

                pas.add(temp);
                System.out.println(pas);
                this.lstSecteur[temp.get(0)][temp.get(1)]  = new Terrain();
                x+=1;
                System.out.println(this.lstSecteur[temp.get(0)][temp.get(1)]);


            }


        }


    }






}
