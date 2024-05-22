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
    private ArrayList<String> direction;

    public Robot(){
        idRobot = id;
        id ++;
        this.capaciteStockage= new Random().nextInt(10-5) + 5;
        this.capaciteExtraction= new Random().nextInt(4-1) + 1 ;
        this.nbMineraisExtraits=0;


    }

    public void deplacer(Event e){

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
