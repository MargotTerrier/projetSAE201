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
    private Minerai typeMinerai;

    public Robot(Robot r) { //constructeur par copie
        this.idRobot = r.getIdRobot();
        this.capaciteExtraction = r.getCapaciteExtraction();
        this.capaciteStockage = r.getCapaciteStockage();
        this.nbMineraisExtraits = r.getNbMineraisExtraits();
        this.coordonneesX = r.getCoordonneesX();
        this.coordonneesY = r.getCoordonneesY();
    }

    public Robot(int x, int y,Minerai minerai){
        idRobot = id;
        id ++;
        this.capaciteStockage= new Random().nextInt(10-5) + 5;
        this.capaciteExtraction= new Random().nextInt(4-1) + 1 ;
        this.nbMineraisExtraits=0;
        this.coordonneesX = x;
        this.coordonneesY = y;
        this.typeMinerai=minerai;

    }

    public boolean verifDeplacement(Monde m, String direction){
        int tmpY = this.coordonneesY;
        int tmpX = this.coordonneesX;

        switch (direction) {
            case "Haut" -> tmpX -= 1;
            case "Bas" -> tmpX += 1;
            case "Gauche" -> tmpY -= 1;
            case "Droit" -> tmpY += 1;
            case "Extraire" -> {
                if(((Terrain)m.getLstSecteur()[tmpX][tmpY]).getDistrict() instanceof Mine){
                    return ((Mine) ((Terrain) m.getLstSecteur()[tmpX][tmpY]).getDistrict()).getTypeMinerai() == this.typeMinerai && ((Mine) ((Terrain) m.getLstSecteur()[tmpX][tmpY]).getDistrict()).getNbMinerais() != 0;
                }
            }
            case "Vider" -> {
                if(((Terrain)m.getLstSecteur()[tmpX][tmpY]).getDistrict() instanceof Entrepot){
                    return (((Entrepot) ((Terrain) m.getLstSecteur()[tmpX][tmpY]).getDistrict()).getTypeMinerai()) == this.typeMinerai;
            }
            }

        }
        if ((EstPasDansLeMonde(tmpX,tmpY,m))){
            return false;
        }
        else return !(estPlanEau(tmpX, tmpY, m));
    }

    public boolean estPlanEau(int x , int y, Monde m ){
        return ( m.getLstSecteur()[x][y] instanceof PlanDeau);
    }

    public boolean EstPasDansLeMonde(int x,int y,Monde m){
//        System.out.println(x);
//        System.out.println(y);
//        System.out.print(x < 0 || x>m.getLongueurMonde() || y<0 || y>m.getLargeurMonde());
        return (x < 0 || x>=m.getLongueurMonde() || y<0 || y>=m.getLargeurMonde()) ;
    }


//    public boolean extraire(Mine m){
//        if (m.extraction(this) == -1 || this.getTypeMinerai()!=m.getTypeMinerai()){
//            System.out.println("Impossible");
//            return false;
//        }
//
//        // Vérifie que la mine n'est pas vide
//        else {
//            System.out.println("extraction en cours");
//            this.nbMineraisExtraits += m.extraction(this);
//            System.out.println(this.nbMineraisExtraits);
//            return true;
//        }
//    }

    public boolean vider(Entrepot e){
        if (this.nbMineraisExtraits == 0) return false;
        else {
            e.remplissage(this);
            this.nbMineraisExtraits = 0;
            return true;
        }
    }

    public Minerai getTypeMinerai() {
        return typeMinerai;
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

    public void setnbMineraisExtraits(int nbMineraisExtraits) {
        this.nbMineraisExtraits = nbMineraisExtraits;
    }

    //    public ArrayList<String> getDirection(){
//
//    }
}
