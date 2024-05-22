package org.uphf.projetsae201.Model;



import javafx.event.Event;

import java.util.ArrayList;
import java.util.Random;

public class Robot {
    private static int id =1;
    private int idRobot;
    private int capaciteExtraction;
    private int capaciteStockage;
    private int nbMineraisExtraits; // Nombre de minerais dans sa besace
    private int coordonneesX;
    private int coordonneesY;
    private ArrayList<String> direction; // Sous la forme ["Haut", "Bas", "Gauche", "Droit"]

    public Robot(int x, int y){
        idRobot = id;
        id ++;
        this.capaciteStockage= new Random().nextInt(10-5) + 5;
        this.capaciteExtraction= new Random().nextInt(4-1) + 1 ;
        this.nbMineraisExtraits=0;
        this.direction = new ArrayList<>();
        this.coordonneesX = x;
        this.coordonneesY = y;

    }

    public void VerifDeplacer(Monde m){
        /*Le déplacement par défaut d'un robot se fait dans toute les directions possible exceptée les diagonales.
        Les directions impossible (hors du monde ou plan d'eau) sont éliminées après vérification de leur présence, au fur et à mesure.
        Pas de else if pour passser dans toutes les vérifications, si un monde de taille 1 x 1 est créé par exemple*/
        this.direction.add("Haut");
        this.direction.add("Bas");
        this.direction.add("Gauche");
        this.direction.add("Droit");

        // vérification du bord du monde
        if (this.coordonneesX == 0){ // si le robot est sur la première ligne
            this.direction.removeFirst();
        }
        if (this.coordonneesX == m.getLongueurMonde()){ // si le robot est sur la dernière colonne
            this.direction.removeLast();
        }
        if (this.coordonneesY == 0){ // si le robot est sur la première colonne
            this.direction.remove(2);
        }
        if (this.coordonneesY == m.getLargeurMonde()){ // si le robot est sur la dernière colonne
            this.direction.remove(1);
        }

        // Vérification de la présence d'un plans d'eau
        for (int i = 0; i < this.direction.size(); i++) { // parcours des directions restantes
            if (this.direction.get(i) == "Haut"){
                int tmpX = this.coordonneesX - 1;
                int tmpY = this.coordonneesY;
            } else if (this.direction.get(i) == "Bas") {
                int tmpX = this.coordonneesX + 1;
                int tmpY = this.coordonneesY;
            } else if (this.direction.get(i) == "Gauche") {
                int tmpX = this.coordonneesX;
                int tmpY = this.coordonneesY - 1;
            } else if (this.direction.get(i) == "Droit") {
                int tmpX = this.coordonneesX;
                int tmpY = this.coordonneesY + 1;
            }
            if (m.getLstSecteur()[tmpX][tmpY] )
        }

    }

    public boolean extraire(Mine m){
        if (m.extraction(this) == -1) return false; // Vérifie que la mine n'est pas vide
        else {
            nbMineraisExtraits += m.extraction(this);
            return true;
        }
    }

    public boolean vider(Entrepot e){
        if (this.nbMineraisExtraits == 0) return false;
        else {
            e.remplissage(this);
            this.nbMineraisExtraits = 0;
            return true;
        }
    }

    public int getCapaciteExtraction(){
        return this.capaciteExtraction;
    }

    public int getCapaciteStockage(){
        return this.capaciteStockage;
    }

    public int getNbMineraisExtraits(){
        return this.nbMineraisExtraits;
    }

    public int getIdRobot(){
        return idRobot;
    }

    public int getCoordonneesX() {
        return coordonneesX;
    }

    public int getCoordonneesY() {
        return coordonneesY;
    }
}
