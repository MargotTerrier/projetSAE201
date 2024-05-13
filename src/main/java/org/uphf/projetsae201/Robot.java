package org.uphf.projetsae201;

import jdk.jfr.Event;

import java.util.ArrayList;
import java.util.Random;

public class Robot {
    private int capciteExtraction;
    private int capaciteStockage;
    private int nbMineraisExtraits;
    private ArrayList<String> direction;

    public Robot(){
        this.capaciteStockage= new Random().nextInt(10-5) + 5;


    }

    public void deplacer(Event e){

    }

    public void extraire(){

    }

    public void seVider(){

    }

    public int getCapaciteExtraction(){
        return 0;
    }

    public int getCapaciteStockage(){
        return 0;
    }

    public ArrayList<String> getDirection(){

    }
}
