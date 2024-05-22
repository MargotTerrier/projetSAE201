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

    public void VerifDeplacer(Robot R, Monde m){
        /*Le déplacement par défaut d'un robot se fait dans toute les directions possible exceptée les diagonales.
        Les directions impossible (hors du monde ou plan d'eau) sont éliminées après vérification de leur présence*/
        direction.add("Haut");
        direction.add("Bas");
        direction.add("Gauche");
        direction.add("Droit");
        if (coordonneesX == 0){ // si le robot est sur la première ligne
            direction.remove(0);
        }
        if (coordonneesY == 0){
            direction.remove(2);
        }
        if (coordonneesX == m.getLargeurMonde()) // si le robot est sur la dernière ligne
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

//    public ArrayList<String> getDirection(){
//
//    }
}
