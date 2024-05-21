package org.uphf.projetsae201;

import java.util.Random;

public class Mine extends District{
    private static int id = 1;
    private  int idMine;
    private int nbMinerais;
    private Minerai typeMinerai;
    private int capacite;
    private boolean vide;

    public Mine(int id){
        this.idMine = id;
        id += 1;
        this.nbMinerais = 50 + new Random().nextInt(50);
        this.capacite = nbMinerais;
        this.vide = false;
    }

    @Override
    public int getId(){
        return this.idMine;
    }


    public int getNbMinerais(){
        return this.nbMinerais;
    }
    public int getCapacite(){
        return this.capacite;
    }

    public void extraction(Robot r){
        this.nbMinerais -= r.getCapaciteExtraction();
    }

    public void setVide(boolean v) {
        this.vide=v;
    }

    public boolean getVide(){
        return this.vide;
    }

}