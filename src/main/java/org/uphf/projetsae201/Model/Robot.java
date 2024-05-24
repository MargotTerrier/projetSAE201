package org.uphf.projetsae201.Model;



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
        this.direction.add("Haut"); //Le déplacement par défaut d'un robot se fait dans toute les directions possibles (haut, bas, gauche, droite)
        this.direction.add("Bas");
        this.direction.add("Gauche");
        this.direction.add("Droit");

        this.coordonneesX = x;
        this.coordonneesY = y;

    }

    public boolean verifDeplacement(Monde m, String direction){
        int tmpY = this.coordonneesY;
        int tmpX = this.coordonneesX;

        switch (direction) {
            case "Haut" -> tmpY -= 1;
            case "Bas" -> tmpY += 1;
            case "Gauche" -> tmpX -= 1;
            case "Droit" -> tmpX += 1;
        }
        return (!EstPasDansLeMonde(tmpX,tmpY,m) && !estPlanEau(tmpX,tmpY,m));


    }

    public boolean estPlanEau(int x , int y, Monde m ){
        return ((Secteur) m.getLstSecteur()[x][y]) instanceof PlanDeau;
    }

    public boolean EstPasDansLeMonde(int x,int y,Monde m){
        return (x < 0 || x>m.getLongueurMonde() || y<0 || y>m.getLargeurMonde()) ;
    }


    public void VerifDeplacer(Monde m) {
        /*Les directions impossible (hors du monde ou plan d'eau) sont éliminées après vérification, au fur et à mesure.
        Pas de else if pour passser dans toutes les vérifications*/

        // vérification du bord du monde
        if (this.coordonneesX == 0) { // si le robot est sur la première ligne
            this.direction.removeFirst();
        }
        if (this.coordonneesX == m.getLongueurMonde()) { // si le robot est sur la dernière colonne
            this.direction.removeLast();
        }
        if (this.coordonneesY == 0) { // si le robot est sur la première colonne
            this.direction.remove(2);
        }
        if (this.coordonneesY == m.getLargeurMonde()) { // si le robot est sur la dernière colonne
            this.direction.remove(1);
        }

        // Vérification de la présence d'un plans d'eau
        for (int i = 0; i < this.direction.size(); i++) { // parcours des directions restantes
            int tmpX = -1;
            int tmpY = 0;
            if (this.direction.get(i) == "Haut") {
                tmpX = this.coordonneesX - 1;
                tmpY = this.coordonneesY;
            } else if (this.direction.get(i) == "Bas") {
                tmpX = this.coordonneesX + 1;
                tmpY = this.coordonneesY;
            } else if (this.direction.get(i) == "Gauche") {
                tmpX = this.coordonneesX;
                tmpY = this.coordonneesY - 1;
            } else if (this.direction.get(i) == "Droit") {
                tmpX = this.coordonneesX;
                tmpY = this.coordonneesY + 1;
            }
            if (tmpX == -1) break; // On casse le for s'il n'y a plus de direction
            if (m.getLstSecteur()[tmpX][tmpY] instanceof PlanDeau) {
                this.direction.remove(i);
            }
        }
    }

    public boolean extraire(Mine m){
        if (m.extraction(this) == -1) return false; // Vérifie que la mine n'est pas vide
        else {
            this.nbMineraisExtraits += m.extraction(this);
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

    public void deplacer(String dir){


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

    public int getCoordonneesY() {
        return coordonneesY;
    }

    public int getCoordonneesX() {
        return coordonneesX;
    }

    public void setCoordonneesX(int coordonneesX) {
        this.coordonneesX = coordonneesX;
    }

    public void setCoordonneesY(int coordonneesY) {
        this.coordonneesY = coordonneesY;
    }

    public ArrayList<String> getDirection() {
        return direction;
    }
    //    public ArrayList<String> getDirection(){
//
//    }
}
