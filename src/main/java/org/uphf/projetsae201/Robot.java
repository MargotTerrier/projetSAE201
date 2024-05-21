package org.uphf.projetsae201;



import javafx.event.Event;

import java.util.ArrayList;
import java.util.Random;

public class Robot {
    private static int idRobot =1;
    private int capaciteExtraction;
    private int capaciteStockage;
    private int nbMineraisExtraits;
    private ArrayList<String> direction;

    public Robot(){
        idRobot ++;
        this.capaciteStockage= new Random().nextInt(10-5) + 5;
        this.capaciteExtraction= new Random().nextInt(4-1) + 1 ;
        this.nbMineraisExtraits=0;


    }

    public void deplacer(Event e){

    }

    public void extraire(){
        while (nbMineraisExtraits < capaciteStockage){
            if (capaciteExtraction <= capaciteStockage - nbMineraisExtraits){

            }
        }
    }

    public void seVider(){

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
